package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;

/**
 * The ViewRegister class represents the registration view of the application.
 */
public class ViewRegister {

	//GLOBAL VARIABLES
	public static JFrame frameRegister;
	public static JLabel lblX;
	public static JButton btnLogin;
	public static JButton btnCrearCompte;
	public static JLabel lblAvis;
	public static JLabel lblAvisPNG1;
	public static JLabel lblAvisPNG2;
	public static JTextField tfNomUsuari;
	public static JPasswordField tfContra;
	public static JPasswordField tfContraRep;
	public static JButton btnSeePasswordR;

	/**
	 * Launches the registration view.
	 */
	public static void runRegister() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRegister window = new ViewRegister();
					window.frameRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the registration view.
	 */
	public ViewRegister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Frame settings
		frameRegister = new JFrame();
		frameRegister.setUndecorated(true);
		frameRegister.getContentPane().setBackground(new Color(117, 191, 68));
		frameRegister.getContentPane().setLayout(null);
		frameRegister.setBounds(100, 100, 540, 750);
		frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int arcWidth = 30;
		int arcHeight = 30;
		frameRegister.setShape(new RoundRectangle2D.Double(0, 0, frameRegister.getBounds().width, frameRegister.getBounds().height, arcWidth, arcHeight));

		// ComponentMover for frame dragging
		controller.ComponentMover cm = new controller.ComponentMover();
		cm.registerComponent(frameRegister);
		cm.setDragInsets(new Insets(0, 0, 750 - 25, 0));

		//Tries to set the image of the logo, and if it has a problem handles it
		JLabel lblLogo = new JLabel("");
		try {
			lblLogo.setIcon(new ImageIcon(ViewLogin.class.getResource("/view/img/logoespotyfai.png")));
		} catch (NullPointerException e) {
			lblLogo.setText("Problema al buscar la imagen, revise la instalación. \n <<lblLogo>>");
			System.err.println("Problema al buscar la imagen, revise la instalación. \n lblLogo");
		}
		lblLogo.setBounds(10, -12, 461, 261);
		frameRegister.getContentPane().add(lblLogo);

		//Button to exit the app
		lblX = new JLabel(" X");
		lblX.setForeground(new Color(204, 236, 108));
		lblX.setBackground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblX.setBounds(488, 0, 52, 75);
		frameRegister.getContentPane().add(lblX);

		JLabel lblNomUsuari = new JLabel("Nom de l'usuari");
		lblNomUsuari.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomUsuari.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomUsuari.setBounds(222, 304, 99, 20);
		frameRegister.getContentPane().add(lblNomUsuari);

		tfNomUsuari = new JTextField();
		tfNomUsuari.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 0)));
		tfNomUsuari.setBounds(82, 335, 389, 20);
		frameRegister.getContentPane().add(tfNomUsuari);
		tfNomUsuari.setColumns(10);

		JLabel lblContra = new JLabel("Contrassenya");
		lblContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContra.setAlignmentX(0.5f);
		lblContra.setBounds(222, 396, 99, 25);
		frameRegister.getContentPane().add(lblContra);

		// Create Account button
		btnCrearCompte = new JButton("Crear compte");
		btnCrearCompte.setBorder(null);
		btnCrearCompte.setBounds(205, 570, 141, 23);
		btnCrearCompte.setBackground(new Color(0, 128, 0)); // Green background
		btnCrearCompte.setForeground(new Color(255, 255, 255)); // White text
		btnCrearCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCrearCompte.setOpaque(true);
		btnCrearCompte.setBorder(new controller.RoundedButton(Color.BLACK));
		frameRegister.getContentPane().add(btnCrearCompte);

		JLabel lblContraRep = new JLabel("Repeteix la contrassenya");
		lblContraRep.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraRep.setHorizontalTextPosition(SwingConstants.CENTER);
		lblContraRep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraRep.setAlignmentX(0.5f);
		lblContraRep.setBounds(82, 478, 389, 25);
		frameRegister.getContentPane().add(lblContraRep);

		// Here the user will write his password
		tfContra = new JPasswordField();
		tfContra.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 0)));
		tfContra.setBounds(82, 430, 389, 20);
		frameRegister.getContentPane().add(tfContra);

		// Repeat Password text field
		tfContraRep = new JPasswordField();
		tfContraRep.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 0)));
		tfContraRep.setBounds(82, 514, 389, 20);
		frameRegister.getContentPane().add(tfContraRep);

		// Warning label for incomplete or mismatched fields
		lblAvis = new JLabel("");
		lblAvis.setForeground(new Color(128, 0, 0));
		lblAvis.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvis.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAvis.setBounds(74, 644, 412, 36);
		frameRegister.getContentPane().add(lblAvis);

		// Warning icons
		lblAvisPNG2 = new JLabel("");
		lblAvisPNG2.setBounds(114, 564, 70, 63);
		frameRegister.getContentPane().add(lblAvisPNG2);

		lblAvisPNG1 = new JLabel("");
		lblAvisPNG1.setBounds(368, 570, 70, 63);
		frameRegister.getContentPane().add(lblAvisPNG1);

		//Discovers the password
		btnSeePasswordR = new JButton("");
		btnSeePasswordR.setFocusPainted(false);
		btnSeePasswordR.setContentAreaFilled(false);
		btnSeePasswordR.setBorder(null);
		btnSeePasswordR.setBorderPainted(false);
		btnSeePasswordR.setIcon(new ImageIcon(ViewLogin.class.getResource("/view/img/seePwd2.png")));
		btnSeePasswordR.setBounds(474, 430, 29, 20);
		frameRegister.getContentPane().add(btnSeePasswordR);

		// 'Already have an account?' button to switch to login view
		btnLogin = new JButton("Ja tinc compte");
		btnLogin.setBackground(new Color(117, 191, 68));
		btnLogin.setBounds(205, 604, 141, 23);
		frameRegister.getContentPane().add(btnLogin);
	}
}

