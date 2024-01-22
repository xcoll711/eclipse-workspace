package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import model.Functions;
import model.ServerFunctions;
import view.ViewClient;
import view.ViewLogin;
import view.ViewRegister;

/**
 * This class contains action listeners for various views in the application.
 */
public class ActionListeners {



	/**
	 * Initializes action listeners for the login view.
	 */
	public void viewLogin() {
		// Close application when 'X' button is clicked
		ViewLogin.lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		// Switch to register view when the registration button is clicked
		ViewLogin.btnRegistrar.addActionListener(e -> {
			ViewLogin.frameLogin.setVisible(false);
			ViewRegister.frameRegister.setVisible(true);
			Functions.clearLoginFields();
		});

		// Log in when the continue button is clicked
		ViewLogin.btnContinuar.addActionListener(e -> Functions.loginAction());

		// Toggle password visibility when the 'See Password' button is clicked
		ViewLogin.btnSeePassword.addActionListener(e -> Functions.togglePasswordVisibilityLogin(ViewLogin.tfContra));
	}



	/**
	 * Initializes action listeners for the register view.
	 */
	public void viewRegister() {
		// Close application when 'X' button is clicked
		ViewRegister.lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		// Create an account 
		ViewRegister.btnCrearCompte.addActionListener(e -> Functions.createAccountAction());

		// Toggle password visibility
		ViewRegister.btnSeePasswordR.addActionListener(e -> Functions.togglePasswordVisibilityRegister(ViewRegister.tfContra, ViewRegister.tfContraRep));

		// Switch to login view 
		ViewRegister.btnLogin.addActionListener(e -> Functions.switchToLoginView());
	}

	/**
	 * Initializes action listeners for the client view.
	 */
	public void viewClient() {

		/* --------------- */
		/* WINDOW SETTINGS */

		// Close application
		ViewClient.btnCerrar.addActionListener(e -> System.exit(0));


		ViewClient.btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ViewClient.btnCerrar.setBackground(new Color (200,0,0)); // Cambiar a color rojo al pasar el ratón
			}

			@Override
			public void mousePressed(MouseEvent e) {
				ViewClient.btnCerrar.setBackground(new Color (240,0,0)); // Cambiar a color rojo al pasar el ratón
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ViewClient.btnCerrar.setBackground(null); // Restaurar el color predeterminado al salir
			}
		});
		// Toggle full-screen mode 
		ViewClient.btnVentana.addActionListener(e -> Functions.toggleFullScreen());

		ViewClient.btnVentana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// Change background color when the mouse enters the button
				ViewClient.btnVentana.setBackground(Color.GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Restore the background color when the mouse exits the button
				ViewClient.btnVentana.setBackground(Color.BLACK);
			}
		});

		// Minimize the window
		ViewClient.btnMinimizar.addActionListener(e -> Functions.minimizeWindow());


		ViewClient.btnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// Change background color when the mouse enters the button
				ViewClient.btnMinimizar.setBackground(Color.GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Restore the background color when the mouse exits the button
				ViewClient.btnMinimizar.setBackground(Color.BLACK);
			}
		});

		/*------*/
		/* MENU */
		/*Functions.configureLabelMouseAdapter(ViewClient.lblInici);
		Functions.configureLabelMouseAdapter(ViewClient.lblCerca);
		Functions.configureLabelMouseAdapter(ViewClient.lblBiblioteca);*/


		 ViewClient.lblInici.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                // Change the CardLayout to show "Inici" panel
	                CardLayout cardLayout = (CardLayout)  ViewClient.panel.getLayout();
	                
	                ViewClient.lblInici.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/inici1.png")));
	                ViewClient.lblCerca.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/cerca2.png")));
	                
	                cardLayout.show( ViewClient.panel, "Inici");
	       

	            }
	        });

		 ViewClient.lblCerca.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                // Change the CardLayout to show "Cerca" panel
	                CardLayout cardLayout = (CardLayout)  ViewClient.panel.getLayout();
	                
	                ViewClient.lblInici.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/inici2.png")));
	                ViewClient.lblCerca.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/cerca1.png")));
	                
	                cardLayout.show( ViewClient.panel, "Cerca");
	            }
	        });



		/*---------------*/
		/* SONG CONTROLS */
		ViewClient.btnRepro.addActionListener(e -> {

			System.out.println("Button Random Repro pressed");

		});

		ViewClient.btnSkipB.addActionListener(e -> {

			System.out.println("Button Skip Backwards pressed");

		});


		ViewClient.btnPlayPause.addActionListener(e -> {

			System.out.println("Button Play Pause pressed");
			
			Functions.playPause();

		});

		ViewClient.btnSkipF.addActionListener(e -> {

			System.out.println("Button Skip Forward pressed");

		});

		ViewClient.btnLoop.addActionListener(e -> {

			System.out.println("Button Loop pressed");

		});


		/* --- */
		/*- RIGHT SIDE SONG WINDOW CONTROLS-*/
		ViewClient.btnFullScrSong.addActionListener(e -> {

			System.out.println("Button btnFullScrSong pressed");

		});
		
		/*ViewClient.pbVolume.addActionListener(e -> {

			System.out.println("pbVolume pressed");

		});*/
		
		ViewClient.btnVolume.addActionListener(e -> {

			System.out.println("Button btnVolume pressed");

		});
		
		ViewClient.btnDevice.addActionListener(e -> {

			System.out.println("Button btnDevice pressed");

		});
		
		ViewClient.btnQueue.addActionListener(e -> {

			System.out.println("Button btnQueue pressed");

		});
		
		ViewClient.btnLyrics.addActionListener(e -> {

			System.out.println("Button btnLyrics pressed");

		});

		ViewClient.btnNowPlaying.addActionListener(e -> {

			System.out.println("Button btnNowPlaying pressed");

		});

	}


}

