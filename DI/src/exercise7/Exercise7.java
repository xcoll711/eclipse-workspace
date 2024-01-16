package exercise7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.List;




public class Exercise7 {

	private JFrame frame;
	private JTextField tfName;
	private JTextField tfMark;
	private int nPass;
	private int nFail;

	private JLabel lblPass ;
	private JLabel lblFail;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise7 window = new Exercise7();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Exercise7() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Exercise 7 Xavi");
		frame.setBounds(100, 100, 403, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelNorth = new JPanel();
		Border borderNorth = BorderFactory.createTitledBorder("Student");
		panelNorth.setBorder(borderNorth);

		JPanel panel = new JPanel(new BorderLayout()); // Usa BorderLayout para el panel central
		Border borderCenter = BorderFactory.createTitledBorder("Students List");
		panel.setBorder(borderCenter);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(210,210,210));
		textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añade un margen interno al área de texto
		panel.add(textArea, BorderLayout.CENTER); // Agrega el área de texto al centro del panel

		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(new Color(255, 204, 0));
		Border borderSouth = BorderFactory.createTitledBorder("Statistics");
		panelSouth.setBorder(borderSouth);

		frame.getContentPane().add(panelNorth, BorderLayout.NORTH);

		JLabel lblName = new JLabel("Name");

		tfName = new JTextField();
		tfName.setColumns(10);

		tfMark = new JTextField();
		tfMark.setColumns(10);

		JLabel lblMark = new JLabel("Mark");

		JButton btnAdd = new JButton("Add");

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				try {
					// Intenta convertir el texto de tfMark a un valor numérico
					Double nota = Double.parseDouble(tfMark.getText());
					if (!tfName.getText().isEmpty() || !tfMark.getText().isEmpty()) {
						  // tfMark no es un número

						  textArea.setText(textArea.getText() + "\n● " + tfName.getText() + " --> " + tfMark.getText());

						  if (nota >= 5) {
						    nPass++;
						  } else {
						    nFail++;
						  }

						  // Calcula el porcentaje de aprobados y reprobados
						  double passPercentage = (double) nPass / (nPass + nFail) * 100;
						  double failPercentage = (double) nFail / (nPass + nFail) * 100;

						  // Establece los textos de las etiquetas lblPass y lblFail
						  lblPass.setText("Pass: " + String.format("%.2f%%", passPercentage));
						  lblFail.setText("Fail: " + String.format("%.2f%%", failPercentage));
						}

					} catch (NumberFormatException exc) {
						System.out.println("It wasn't a number wtf");
					}


				}
			});

		GroupLayout gl_panelNorth = new GroupLayout(panelNorth);
		gl_panelNorth.setHorizontalGroup(
				gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelNorth.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMark, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelNorth.createParallelGroup(Alignment.TRAILING)
								.addComponent(tfName, Alignment.LEADING)
								.addComponent(tfMark, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
						.addGap(12))
				.addGroup(Alignment.TRAILING, gl_panelNorth.createSequentialGroup()
						.addContainerGap(323, Short.MAX_VALUE)
						.addComponent(btnAdd)
						.addContainerGap())
				);
		gl_panelNorth.setVerticalGroup(
				gl_panelNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorth.createSequentialGroup()
						.addGroup(gl_panelNorth.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelNorth.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfMark, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMark))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAdd)
						.addContainerGap())
				);
		panelNorth.setLayout(gl_panelNorth);



		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);

		lblPass = new JLabel("Pass:");
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		panelSouth.add(lblPass);

		JLabel lblEspai = new JLabel("                                                                   ");
		panelSouth.add(lblEspai);

		lblFail = new JLabel("Fail:");
		panelSouth.add(lblFail);
		}
	}
