package exemple2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Color;

public class Example2 {

	private JFrame frame;
	private JLabel lblSuperior;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Example2 window = new Example2();
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
	public Example2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Exemple 2 - Layout managers Xavi");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JButton btnE = new JButton("E");
		btnE.setBackground(new Color(128, 255, 255));
		btnE.setPreferredSize(new Dimension(66, 23));
		frame.getContentPane().add(btnE, BorderLayout.WEST);
		
		JButton btnC = new JButton("C");
		btnC.setBackground(new Color(0, 255, 255));
		frame.getContentPane().add(btnC, BorderLayout.CENTER);
		
		JButton btnD = new JButton("D");
		btnD.setBackground(new Color(128, 255, 255));
		btnD.setPreferredSize(new Dimension(66, 23));
		frame.getContentPane().add(btnD, BorderLayout.EAST);
		
		JTextArea txtrInferiorTextArea = new JTextArea();
		txtrInferiorTextArea.setText("Inferior text area..");
		frame.getContentPane().add(txtrInferiorTextArea, BorderLayout.SOUTH);
		
		lblSuperior = new JLabel();
		lblSuperior.setText("Superior label");
		frame.getContentPane().add(lblSuperior, BorderLayout.NORTH);
	}

}
