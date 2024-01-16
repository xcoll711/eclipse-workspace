package view;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import model.Functions;


/**
/**
 * The `View` class represents the graphical user interface (GUI).
 * It is responsible for initializing and configuring all the interface components, such as windows, panels,
 * labels, text areas, combo boxes, and buttons. 
 *
 * @author Xavier Coll Vilafranca
 * @version 1.1 09-11-2023
 * @see model.CursIAssignatures#cursos()
 * 
 */
public class View {

	/*
	 * Public declarations allow access from other packages.
	 */
	public JFrame frame;
	public static JButton btnAfegeix;
	public static JButton btnReinicia;
	public static JComboBox cbAssignatures;
	public static JComboBox<String> cbCurs;
	public static JTextArea taAssignatures;
	public static JTextArea taPreuCredit;
	public static JLabel lblPreuTotal;

	/**
	 * Constructor for the View class. Initializes the graphical user interface components.
	 */
	public View() {
		initialize();
	}

	private void initialize() {

	    // Create the main frame
	    frame = new JFrame();
	    frame.setTitle("La Matrícula");
	    frame.setResizable(false);
	    frame.setBounds(100, 100, 627, 521);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);

	    /*
	     * Panels
	     */

	    // Panel for menu items
	    JPanel panelMenu = new JPanel();
	    panelMenu.setBorder(new TitledBorder(null, "La Matricula", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panelMenu.setBounds(0, 0, 612, 488);
	    frame.getContentPane().add(panelMenu);
	    panelMenu.setLayout(null);

	    // Panel to display total price
	    JPanel panelPrice = new JPanel();
	    panelPrice.setBounds(10, 422, 592, 54);
	    panelMenu.add(panelPrice);
	    panelPrice.setBackground(new Color(128, 255, 128));
	    panelPrice.setLayout(null);

	    // Panel for PREU information
	    JPanel panel = new JPanel();
	    panel.setBorder(new TitledBorder(null, "PREU", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panel.setBounds(306, 318, 285, 93);
	    panelMenu.add(panel);
	    panel.setLayout(null);

	    // Label for "Preu / credit (€)"
	    JLabel lblPreu = new JLabel("Preu / credit (€)");
	    lblPreu.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblPreu.setBounds(20, 23, 127, 18);
	    panel.add(lblPreu);

	    /*
	     * Local labels
	     */

	    // Label to display total price
	    lblPreuTotal = new JLabel("Preu Total = 0.0 €");
	    lblPreuTotal.setBounds(10, 11, 572, 37);
	    lblPreuTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblPreuTotal.setHorizontalAlignment(0);
	    panelPrice.add(lblPreuTotal);

	    // Label for displaying logo
	    JLabel lblFoto = new JLabel("");
	    lblFoto.setIcon(new ImageIcon(View.class.getResource("/view/logo.png")));
	    lblFoto.setBounds(405, 22, 139, 108);
	    panelMenu.add(lblFoto);

	    // Label for displaying "Curs"
	    JLabel lblCurs = new JLabel("Curs");
	    lblCurs.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblCurs.setBounds(326, 143, 46, 14);
	    panelMenu.add(lblCurs);

	    // Label for displaying "Assignatures"
	    JLabel lblAssignaturesTitol = new JLabel("Assignatures");
	    lblAssignaturesTitol.setFont(new Font("Courier New", Font.BOLD, 16));
	    lblAssignaturesTitol.setBounds(10, 11, 238, 25);
	    panelMenu.add(lblAssignaturesTitol);

	    // Label for displaying selected "Assignatures"
	    JLabel lblAssignatures = new JLabel("Assignatures");
	    lblAssignatures.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    lblAssignatures.setBounds(296, 208, 295, 22);
	    lblAssignatures.setHorizontalAlignment(0);
	    panelMenu.add(lblAssignatures);

	    /*
	     * TextArea Assignatures
	     */

	    // Text area for displaying selected assignments
	    taAssignatures = new JTextArea();
	    taAssignatures.setSelectionColor(new Color(128, 255, 128));
	    taAssignatures.setEditable(false);
	    taAssignatures.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    taAssignatures.setBounds(10, 32, 276, 379);
	    panelMenu.add(taAssignatures);

	    /*
	     * ComboBox Curs
	     */

	    // Combo box for selecting courses
	    cbCurs = new JComboBox<String>();
	    cbCurs.setBounds(382, 141, 209, 22);
	    Functions.fillCbCurs();
	    panelMenu.add(cbCurs);

	    /*
	     * ComboBox Assignatures
	     */

	    // Combo box for selecting assignments
	    cbAssignatures = new JComboBox();
	    cbAssignatures.setBounds(306, 241, 285, 22);
	    panelMenu.add(cbAssignatures);

	    /*
	     * Button Afegeix
	     */

	    // Button to add selected assignment
	    btnAfegeix = new JButton("Afegeix");
	    btnAfegeix.setForeground(new Color(0, 0, 0));
	    btnAfegeix.setBounds(340, 274, 89, 23);
	    panelMenu.add(btnAfegeix);

	    /*
	     * Button Reinicia
	     */

	    // Button to reset selections
	    btnReinicia = new JButton("Reinicia");
	    btnReinicia.setBounds(462, 274, 89, 23);
	    panelMenu.add(btnReinicia);

	    /*
	     * TextArea PreuCredit 
	     */

	    // Text area for entering price per credit
	    taPreuCredit = new JTextArea();
	    taPreuCredit.setFont(new Font("Monospaced", Font.PLAIN, 16));
	    taPreuCredit.setSelectionColor(new Color(128, 255, 128));
	    taPreuCredit.setText("100");
	    taPreuCredit.setBounds(160, 19, 87, 26);
	    panel.add(taPreuCredit);
	}

	
}