package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import controller.RoundedImageIcon;
import controller.RoundedLabel;
import controller.RoundedPanel;
import model.ServerFunctions;
import view.ViewClient;
import view.ViewLogin;
import view.ViewRegister;


/**
 * Provides various utility functions for handling user interactions,
 * database operations, and window management in the application.
 */
public class Functions {

	private static boolean isPwdVisible = false;
	private static boolean ventanaCompleta = false;
	private static int numintents = 0;
	private static int anchoOriginal;
	private static int altoOriginal;


	public static void updateBottomButtonsLocation() {

		Dimension size = ViewClient.frameClient.getSize();
		int halfWidth = size.width / 2;

		ViewClient.sl_panelControlsMid.putConstraint(SpringLayout.WEST, ViewClient.btnPlayPause, halfWidth, SpringLayout.WEST, ViewClient.panelControlsMid);
		// Revalidate and repaint the container
		ViewClient.panelControlsMid.revalidate();
		ViewClient.panelControlsMid.repaint();

	}
	/**
	 * Checks if a given string contains at least one numerical character.
	 *
	 * @param str The string to check.
	 * @return True if the string contains at least one numerical character,
	 * false otherwise.
	 */
	public static boolean containsNumber(String str) {
		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Clears the registration form fields (username, password, confirmation password).
	 */
	public static void clearRegisterFields() {
		ViewRegister.tfNomUsuari.setText("");
		ViewRegister.tfContra.setText("");
		ViewRegister.tfContraRep.setText("");
		ViewRegister.lblAvis.setText("");
		ViewRegister.lblAvisPNG1.setIcon(null);
		ViewRegister.lblAvisPNG2.setIcon(null);
	}

	/**
	 * Clears the login form fields (username, password).
	 */
	public static void clearLoginFields() {
		ViewLogin.tfNomUsuari.setText("");
		ViewLogin.tfContra.setText("");
		ViewLogin.lblAvis.setText("");
		ViewLogin.lblMalLoginPNG1.setIcon(null);
		ViewLogin.lblMalLoginPNG2.setIcon(null);
	}

	/**
	 * Configures the mouse event handling for the given label,
	 * toggling its image between two states (normal and highlighted)
	 * when the mouse enters or exits the label.
	 *
	 * @param label The label to configure.
	 */
	public static void configureLabelMouseAdapter(JLabel label) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (label.getIcon().toString().equals("/view/img/inici1.png") || label.getIcon().toString().equals("/view/img/cerca1.png")) {
					label.setIcon(new ImageIcon(ViewClient.class.getResource(label.getIcon().toString().replace("/view/img/inici1.png", "/view/img/cerca3.png"))));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				label.setIcon(new ImageIcon(ViewClient.class.getResource(label.getIcon().toString().replace("/view/img/inici1.png", "/view/img/cerca2.png"))));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				label.setIcon(new ImageIcon(ViewClient.class.getResource(label.getIcon().toString().replace("/view/img/inici2.png", "/view/img/cerca1.png"))));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (label.getIcon().toString().equals("/view/img/inici1.png") || label.getIcon().toString().equals("/view/img/cerca1.png")) {
					label.setIcon(new ImageIcon(ViewClient.class.getResource(label.getIcon().toString().replace("/view/img/inici1.png", "/view/img/cerca2.png"))));
				}
			}
		});

	}


	/**
	 * Handles the case where the user leaves the registration form with
	 * incomplete fields.
	 */
	public static void handleIncompleteFieldsRegister() {
		ViewRegister.lblAvis.setText("Completi tots els camps, gràcies.");
		numintents++;

		switch (numintents) {
		case 1:
			ViewRegister.lblAvisPNG1.setIcon(new ImageIcon(ViewRegister.class.getResource("/view/img/avis1.png")));
			break;
		case 2:
			ViewRegister.lblAvisPNG2.setIcon(new ImageIcon(ViewRegister.class.getResource("/view/img/avis2.png")));
			ViewRegister.lblAvis.setForeground(Color.RED);
			break;
		case 3:
			ViewRegister.lblAvis.setForeground(Color.BLACK);
			break;
		case 4:
			ViewRegister.lblAvis.setText(ViewRegister.lblAvis.getText().toUpperCase());
			break;
		default:
			ViewRegister.lblAvis.setText(ViewRegister.lblAvis.getText().toUpperCase());
			ViewRegister.lblAvis.setForeground(Color.BLACK);
		}
	}


	/**
	 * Handles the registration of a new user.
	 *
	 * @param username The username of the new user.
	 * @param password The password of the new user.
	 * @throws SQLException If the user already exists.
	 */
	public static void handleUserRegistration(String username, String password) throws SQLException {
		// Check if the user already exists
		if (ServerFunctions.userExists(username)) {
			ViewRegister.lblAvis.setText("El nom d'usuari ja està en ús.");
		} else {
			numintents = 0;
			ServerFunctions.register(username, password);
			ViewLogin.lblAvis.setForeground(Color.BLACK);
			ViewLogin.lblAvis.setText("Compte creat amb èxit");
			Functions.clearRegisterFields();
			ViewRegister.frameRegister.setVisible(false);
			ViewLogin.frameLogin.setVisible(true);
		}
	}

	/**
	 * Handles the case where the user enters a valid password
	 * in the registration form.
	 */
	public static void handleValidPassword() {
		String username = ViewRegister.tfNomUsuari.getText().toLowerCase();
		String password = ViewRegister.tfContra.getText();

		if (password.length() >= 6 && Functions.containsNumber(password)) {
			try {
				Functions.handleUserRegistration(username, password);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else {
			ViewRegister.lblAvis.setText("La contrasenya ha de tenir com a mínim 6 caràcters i contenir números.");
		}
	}

	/*
	 * 
	 */
	public static void loginAction() {
		if (!ViewLogin.tfNomUsuari.getText().isBlank() && !ViewLogin.tfContra.getText().isBlank()) {
			ViewClient.lblUsername.setText(ViewLogin.tfNomUsuari.getText());

			if (ServerFunctions.checkCredentials(ViewLogin.tfNomUsuari.getText().toLowerCase(), ViewLogin.tfContra.getText())) {
				ViewClient.frameClient.setVisible(true);
				ViewLogin.frameLogin.setVisible(false);
				Functions.clearLoginFields();
				numintents = 0;
			}
		} else {
			handleIncompleteFieldsLogin();
		}
	}

	/**
	 * Handles the case where the user leaves the login form with
	 * incomplete fields.
	 */
	public static void handleIncompleteFieldsLogin() {
		ViewLogin.lblAvis.setText("Completi tots els camps, gràcies.");
		numintents++;

		switch (numintents) {
		case 1:
			ViewLogin.lblMalLoginPNG1.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/avis1.png")));
			break;
		case 2:
			ViewLogin.lblMalLoginPNG2.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/avis2.png")));
			ViewLogin.lblAvis.setForeground(Color.RED);
			break;
		case 3:
			ViewLogin.lblAvis.setForeground(Color.BLACK);
			break;
		case 4:
			ViewLogin.lblAvis.setText(ViewLogin.lblAvis.getText().toUpperCase());
			break;
		default:
			ViewLogin.lblAvis.setText(ViewLogin.lblAvis.getText().toUpperCase());
			ViewLogin.lblAvis.setForeground(Color.BLACK);
		}
	}



	public static void togglePasswordVisibilityRegister(JPasswordField... passwordFields) {
		for (JPasswordField passwordField : passwordFields) {
			if (isPwdVisible) {
				passwordField.setEchoChar('●');
				ViewRegister.btnSeePasswordR.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/seePwd2.png")));

			} else {

				passwordField.setEchoChar((char) 0);
				ViewRegister.btnSeePasswordR.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/seePwd1.png")));

			}
		}
		isPwdVisible = !isPwdVisible;
	}

	public static void togglePasswordVisibilityLogin(JTextField tfContra) {
		if (isPwdVisible) {
			((JPasswordField) tfContra).setEchoChar('●');
			ViewLogin.btnSeePassword.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/seePwd2.png")));

		} else {
			((JPasswordField) tfContra).setEchoChar((char) 0);
			ViewLogin.btnSeePassword.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/seePwd1.png")));

		}

		isPwdVisible = !isPwdVisible;		
	}

	public static void createAccountAction() {
		if (!ViewRegister.tfNomUsuari.getText().isEmpty() && !ViewRegister.tfContra.getText().isEmpty()
				&& !ViewRegister.tfContraRep.getText().isEmpty()) {
			if (ViewRegister.tfContra.getText().equals(ViewRegister.tfContraRep.getText())) {
				handleValidPassword();
			} else {
				ViewRegister.lblAvis.setText("Les contrassenyes no són iguals");
			}
		} else {
			Functions.handleIncompleteFieldsRegister();
		}
	}


	/**
	 * Calls the ScreenMode methods
	 */
	public static void toggleFullScreen() {
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ViewClient.btnVentana);

		if (ventanaCompleta) {
			exitFullScreenMode(frame);

		} else {
			enterFullScreenMode(frame);

		}
	}


	public static void enterFullScreenMode(JFrame frame) {
		if (frame != null) {
			ventanaCompleta = true;

			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			gd.setFullScreenWindow(frame);

			// Adjust the resolution to 1920x1080 if compatible
			if (gd.isDisplayChangeSupported()) {
				gd.setDisplayMode(new DisplayMode(1920, 1080, 32, DisplayMode.REFRESH_RATE_UNKNOWN));
			}

			// Change the font and icon when in full-screen mode
			Font customFont = new Font("Arial", Font.PLAIN, 16);
			ViewClient.btnVentana.setFont(customFont);
			ImageIcon icon = new ImageIcon(ViewClient.class.getResource("/view/img/w_nofullscreen.png"));
			ViewClient.btnVentana.setIcon(icon);

			Functions.updateBottomButtonsLocation();

			//ViewClient.frameClient.setShape(new RoundRectangle2D.Double(0, 0, ViewClient.frameClient.getBounds().width, ViewClient.frameClient.getBounds().height, ViewClient.ARCWIDHT, ViewClient.ARCHEIGHT));

		}
	}

	/*
	 * 
	 */
	public static void exitFullScreenMode(JFrame frame) {
		if (frame != null) {
			ventanaCompleta = false;

			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			gd.setFullScreenWindow(null); // Exit full-screen mode



			anchoOriginal = frame.getWidth();
			altoOriginal = frame.getHeight();
			// Restore the original size
			frame.setSize(anchoOriginal, altoOriginal);

			// Restore the original resolution if compatible
			if (gd.isDisplayChangeSupported()) {
				gd.setDisplayMode(new DisplayMode(anchoOriginal, altoOriginal, 32, DisplayMode.REFRESH_RATE_UNKNOWN));
			}

			// Restore the original font and icon
			Font customFont = new Font("Arial", Font.PLAIN, 12);
			ViewClient.btnVentana.setFont(customFont);
			ImageIcon icon = new ImageIcon(ViewClient.class.getResource("/view/img/w_fullscreen.png"));
			ViewClient.btnVentana.setIcon(icon);

			Functions.updateBottomButtonsLocation();

			try {
				ViewClient.frameClient.setShape(new RoundRectangle2D.Double(0, 0, ViewClient.frameClient.getBounds().width, ViewClient.frameClient.getBounds().height, ViewClient.ARCWIDHT, ViewClient.ARCHEIGHT));
			} catch (Exception e) {
				ViewClient.frameClient.setShape(new RoundRectangle2D.Double(0, 0, ViewClient.frameClient.getBounds().width, ViewClient.frameClient.getBounds().height, 15, 15));


			}
		}
	}

	public static void minimizeWindow() {
		// Get the associated JFrame (assuming you are using a JFrame)
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ViewClient.btnMinimizar);
		try {
			ViewClient.frameClient.setShape(new RoundRectangle2D.Double(0, 0, ViewClient.frameClient.getBounds().width, ViewClient.frameClient.getBounds().height, ViewClient.ARCWIDHT, ViewClient.ARCHEIGHT));
		} catch (Exception e) {
			ViewClient.frameClient.setShape(new RoundRectangle2D.Double(0, 0, ViewClient.frameClient.getBounds().width, ViewClient.frameClient.getBounds().height, 15, 15));


		}

		// Minimize the window
		if (frame != null) {
			frame.setState(JFrame.ICONIFIED);
		}
	}

	public static void switchToLoginView() {
		numintents = 0;
		Functions.clearRegisterFields();
		ViewRegister.frameRegister.setVisible(false);
		ViewLogin.frameLogin.setVisible(true);
	}

	public static void addPlaylistRow(JPanel parentPanel) {
		// Add vertical strut above the title and showAll button
		parentPanel.add(Box.createVerticalStrut(10));


		// Crear un panel con GridBagLayout
		JPanel topPanel = new JPanel(new GridBagLayout());
		topPanel.setBackground(null);

		// Crear un objeto GridBagConstraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 20, 0, 20); // Espacios a 20 del lado izquierdo y derecho

		// Agregar un espacio en la parte superior
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		topPanel.add(Box.createVerticalStrut(10), gbc);

		// Crear el JLabel para el playlistTitle
		JLabel playlistTitle = new JLabel("Nombre");
		playlistTitle.setFont(new Font("Arial", Font.BOLD, 18));
		playlistTitle.setForeground(Color.WHITE);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		topPanel.add(playlistTitle, gbc);

		// Crear el JButton para showAll
		JButton showAll = new JButton("Show All");
		showAll.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		showAll.setForeground(Color.LIGHT_GRAY);
		showAll.setBackground(null);
		showAll.setBorder(null);
		showAll.setFocusable(false);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		topPanel.add(showAll, gbc);

		// Agregar un espacio en la parte inferior del panel superior
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		topPanel.add(Box.createVerticalStrut(15), gbc);

		// Agregar el panel superior al panel principal
		parentPanel.add(topPanel);

		// Add vertical strut below the title and showAll button
		parentPanel.add(Box.createVerticalStrut(15));

		// Create the playlist row
		JPanel playlistRow = new JPanel();
		playlistRow.setLayout(new BoxLayout(playlistRow, BoxLayout.X_AXIS));
		playlistRow.setBackground(Color.BLACK);
		playlistRow.setBorder(null);


		//Functions.addPlaylist(playlistRow, "src/view/songImages/1.png", "Ave Maria", "David Bisbal");
		
		//Functions.addPlaylist(playlistRow, new Playlist());		
		Functions.addPlaylistOLD(playlistRow, new ImageIcon("src/view/songImages/1.png"), "Ave Maria", "David Bisbal");
		Functions.addPlaylistOLD(playlistRow, new ImageIcon("src/view/songImages/1.png"), "Ave Maria", "David Bisbal");
		Functions.addPlaylistOLD(playlistRow, new ImageIcon("src/view/songImages/1.png"), "Ave Maria", "David Bisbal");		
		Functions.addPlaylistOLD(playlistRow, new ImageIcon("src/view/songImages/1.png"), "Ave Maria", "David Bisbal");
		Functions.addPlaylistOLD(playlistRow, new ImageIcon("src/view/songImages/1.png"), "Ave Maria", "David Bisbal");

		// Set size preferences for playlistRow
		playlistRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, playlistRow.getPreferredSize().height));
		playlistRow.setPreferredSize(new Dimension(playlistRow.getPreferredSize().width, playlistRow.getPreferredSize().height));

		// Create and configure the scroll pane
		JScrollPane scrollPane = new JScrollPane(playlistRow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, scrollPane.getPreferredSize().height));
		scrollPane.setBorder(null);

		// Add the scroll pane to the parent panel
		parentPanel.add(scrollPane);

		// Add vertical strut below the playlist
		parentPanel.add(Box.createVerticalStrut(25));


	}
	
	public static void addPlaylist(JPanel panel, ImageIcon icon, String name, String artist) {


		panel.add(Box.createHorizontalStrut(5)); // left margin 

		RoundedPanel rp = new RoundedPanel(25);
		rp.setSize(190, 270);
		rp.setBackground(new Color(28, 28, 28));
		rp.setLayout(null);

		panel.add(rp);

		RoundedPanel image = new RoundedPanel(25);
		image.setBounds(20, 24, 148, 137);
		image.setLayout(new BorderLayout(0, 0));
		image.setBackground(new Color(28, 28, 28));

		rp.add(image);

		// Utiliza RoundedImageIcon en lugar de ImageIcon para redondear la imagen
		JLabel lblIMG = new JLabel(new RoundedImageIcon(icon,150,140));
		lblIMG.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMG.setVerticalAlignment(SwingConstants.CENTER);

		// Aplica bordes y transparencia al JLabel
		lblIMG.setOpaque(false);

		// Añade el JLabel al RoundedPanel
		image.add(lblIMG);

		JLabel lblPlaylistName = new JLabel(name);
		lblPlaylistName.setForeground(new Color(255, 255, 255));
		lblPlaylistName.setBounds(20, 175, 146, 22);
		lblPlaylistName.setFont(new Font("Dialog", Font.BOLD, 24));
		rp.add(lblPlaylistName);

		JLabel lblPlaylistArtist = new JLabel(artist);
		lblPlaylistArtist.setVerticalAlignment(SwingConstants.TOP);
		lblPlaylistArtist.setForeground(new Color(140, 140, 140));
		lblPlaylistArtist.setBounds(20, 208, 148, 51);
		lblPlaylistArtist.setFont(new Font("Dialog", Font.BOLD, 14));
		rp.add(lblPlaylistArtist);



		panel.add(Box.createHorizontalStrut(20)); // right margin 

		// Set the size directly when adding the playlist panel
		rp.setMaximumSize(new Dimension(190, 270));
		rp.setMinimumSize(new Dimension(190, 270));

	}

	public static void addPlaylistOLD(JPanel panel, ImageIcon icon, String name, String artist) {


		panel.add(Box.createHorizontalStrut(5)); // left margin 

		RoundedPanel rp = new RoundedPanel(25);
		rp.setSize(190, 270);
		rp.setBackground(new Color(28, 28, 28));
		rp.setLayout(null);

		panel.add(rp);

		RoundedPanel image = new RoundedPanel(25);
		image.setBounds(20, 24, 148, 137);
		image.setLayout(new BorderLayout(0, 0));
		image.setBackground(new Color(28, 28, 28));

		rp.add(image);

		// Utiliza RoundedImageIcon en lugar de ImageIcon para redondear la imagen
		JLabel lblIMG = new JLabel(new RoundedImageIcon(icon,150,140));
		lblIMG.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMG.setVerticalAlignment(SwingConstants.CENTER);

		// Aplica bordes y transparencia al JLabel
		lblIMG.setOpaque(false);

		// Añade el JLabel al RoundedPanel
		image.add(lblIMG);

		JLabel lblPlaylistName = new JLabel(name);
		lblPlaylistName.setForeground(new Color(255, 255, 255));
		lblPlaylistName.setBounds(20, 175, 146, 22);
		lblPlaylistName.setFont(new Font("Dialog", Font.BOLD, 24));
		rp.add(lblPlaylistName);

		JLabel lblPlaylistArtist = new JLabel(artist);
		lblPlaylistArtist.setVerticalAlignment(SwingConstants.TOP);
		lblPlaylistArtist.setForeground(new Color(140, 140, 140));
		lblPlaylistArtist.setBounds(20, 208, 148, 51);
		lblPlaylistArtist.setFont(new Font("Dialog", Font.BOLD, 14));
		rp.add(lblPlaylistArtist);



		panel.add(Box.createHorizontalStrut(20)); // right margin 

		// Set the size directly when adding the playlist panel
		rp.setMaximumSize(new Dimension(190, 270));
		rp.setMinimumSize(new Dimension(190, 270));

	}


	

	/*---*/
	/*- -*/

	public static void playPause() {
		ImageIcon currentIcon = (ImageIcon) ViewClient.btnPlayPause.getIcon();


		if (currentIcon != null && currentIcon.getImage() == new ImageIcon(ViewClient.class.getResource("/view/img/playpause1.png")).getImage()) {
			ViewClient.btnPlayPause.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/playpause2.png")));
		}else {
			ViewClient.btnPlayPause.setIcon(new ImageIcon(ViewClient.class.getResource("/view/img/playpause1.png")));

		}



	}




}
