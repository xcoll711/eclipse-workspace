package exercise3;

import java.awt.*;
import javax.swing.*;


public class Exercise3 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise3 window = new Exercise3();
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
	public Exercise3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		JPanel panel = new JPanel(new BorderLayout());
		
		frame.getContentPane().add(panel);
		
		JLabel lblNorth = new JLabel(" ETIQUETA ZONA NORTH");
		panel.add(lblNorth, BorderLayout.NORTH);
		
		JPanel panelCenter = new JPanel();
		panel.add(panelCenter, BorderLayout.SOUTH);
		panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		textField = new JTextField();
		textField.setColumns(20);
		textField.setPreferredSize(new Dimension (280,30));
		panelCenter.add(textField);
		
		
		JButton btnNewButton = new JButton("DONE");
		panelCenter.add(btnNewButton);
		
		JPanel panelSouth = new JPanel();
		panel.add(panelSouth, BorderLayout.CENTER);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		Dimension dBtn = new Dimension(180,30);
		JButton btn1 = new JButton("1");
		btn1.setPreferredSize(dBtn);
		panelSouth.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setPreferredSize(dBtn);
		

		panelSouth.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setPreferredSize(dBtn);

		panelSouth.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setPreferredSize(dBtn);

		panelSouth.add(btn4);
	}

}
