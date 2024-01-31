package view;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

/**
 * The ViewLogin class represents the login frame of the application.
 */
public class ViewLogin {

	public static JFrame frameLogin;

	//GLOBAL VARIABLES
	public static JTextField tfNomUsuari;
	public static JLabel lblX;
	public static JButton btnContinuar;
	public static JButton btnRegistrar;
	public static JLabel lblAvis;
	public static JTextField tfContra;
	public static JLabel lblMalLoginPNG1;
	public static JLabel lblMalLoginPNG2;
	public static JButton btnSeePassword;

	/**
	 * Create the application.
	 */
	public ViewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLogin = new JFrame();
		frameLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewLogin.class.getResource("/view/img/avis2.png")));

		frameLogin.setUndecorated(true);
		frameLogin.getContentPane().setBackground(new Color(117, 191, 68));
		frameLogin.getContentPane().setLayout(null);
		frameLogin.setBounds(100, 100, 540, 750);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set rounded corners
		int arcWidth = 30; //
		int arcHeight = 30; 
		frameLogin.setShape(new RoundRectangle2D.Double(0, 0, frameLogin.getBounds().width, frameLogin.getBounds().height, arcWidth, arcHeight));

        // ComponentMover for frame dragging
		controller.ComponentMover cm = new controller.ComponentMover();
		cm.registerComponent(frameLogin);
		cm.setDragInsets(new Insets (0,0,750-25,0));

		JLabel lblLogo = new JLabel("");

		//Tries to set the image of the logo, and if it has a problem handles it
		try {
			lblLogo.setIcon(new ImageIcon(ViewLogin.class.getResource("/view/img/logoespotyfai.png")));
		}catch (NullPointerException e) {
			lblLogo.setText("Problema al buscar la imagen, revise la instalación. \n <<lblLogo>>");
			System.err.println("Problema al buscar la imagen, revise la instalación. \n lblLogo");
		}
		lblLogo.setBounds(10, -12, 461, 261);
		frameLogin.getContentPane().add(lblLogo);

		//Button to exit the app
		lblX = new JLabel(" X");
		lblX.setForeground(new Color(204, 236, 108));
		lblX.setBackground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblX.setBounds(488, 0, 52, 75);
		frameLogin.getContentPane().add(lblX);


		JLabel lblNomUsuari = new JLabel("Nom de l'usuari");
		lblNomUsuari.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomUsuari.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomUsuari.setBounds(222, 350, 99, 20);
		frameLogin.getContentPane().add(lblNomUsuari);

		// Here the user will write his username
		tfNomUsuari = new JTextField();
		tfNomUsuari.setText("jordi321");
		tfNomUsuari.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 64)));
		tfNomUsuari.setBounds(72, 381, 389, 20);
		frameLogin.getContentPane().add(tfNomUsuari);
		tfNomUsuari.setColumns(10);

		JLabel lblContra = new JLabel("Contrassenya");
		lblContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContra.setAlignmentX(0.5f);
		lblContra.setBounds(222, 450, 99, 25);
		frameLogin.getContentPane().add(lblContra);

		// Here the user will write his password
		tfContra = new JPasswordField();
		tfContra.setText("123idroj");
		tfContra.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 0)));
		tfContra.setBounds(72, 486, 389, 20);
		frameLogin.getContentPane().add(tfContra);

		//Button to go in
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBorder(null);
		btnContinuar.setBounds(203, 570, 141, 23);
		// Style configuration
		btnContinuar.setBackground(new Color(0, 128, 0)); // Verde
		btnContinuar.setForeground(new Color(255, 255, 255)); // Letras blancas
		btnContinuar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnContinuar.setOpaque(true);
		// Rounded Button
		btnContinuar.setBorder(new controller.RoundedButton(Color.BLACK));
		frameLogin.getContentPane().add(btnContinuar);

		//Button to go to the register frame.
		btnRegistrar = new JButton("Registrar-se");
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setFocusTraversalPolicyProvider(true);
		btnRegistrar.setBackground(new Color(117, 191, 68));
		btnRegistrar.setBounds(203, 604, 141, 23);
		frameLogin.getContentPane().add(btnRegistrar);

		// Here will be the advertises to the user
		lblAvis = new JLabel("");
		lblAvis.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvis.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAvis.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAvis.setForeground(new Color(0, 128, 64));
		lblAvis.setBounds(139, 528, 279, 20);
		frameLogin.getContentPane().add(lblAvis);

		//Funny images
		lblMalLoginPNG1 = new JLabel("");
		lblMalLoginPNG1.setBounds(369, 559, 70, 63);
		frameLogin.getContentPane().add(lblMalLoginPNG1);

		lblMalLoginPNG2 = new JLabel("");
		lblMalLoginPNG2.setBounds(109, 559, 70, 63);
		frameLogin.getContentPane().add(lblMalLoginPNG2);

		//Discovers the password
		btnSeePassword = new JButton("");
		btnSeePassword.setFocusPainted(false);
		btnSeePassword.setContentAreaFilled(false);
		btnSeePassword.setBorder(null);
		btnSeePassword.setBorderPainted(false);
		btnSeePassword.setIcon(new ImageIcon(ViewLogin.class.getResource("/view/img/seePwd2.png")));
		btnSeePassword.setBounds(462, 486, 29, 20);
		frameLogin.getContentPane().add(btnSeePassword);



	}
}
