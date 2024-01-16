package exercise6;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Exercise6 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise6 window = new Exercise6();
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
	public Exercise6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setResizable(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setPreferredSize(new Dimension(101, 70));
		frame.getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblNorth = new JLabel("");
		lblNorth.setFont(new Font("Tahoma", Font.PLAIN, 47));
		lblNorth.setHorizontalAlignment(JLabel.RIGHT);
		panelNorth.add(lblNorth);
		
		JPanel panelSouth = new JPanel();
		frame.getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		textField = new JTextField();
		textField.setColumns(30);

		panelSouth.add(textField);
		
		JButton btnAdd = new JButton("ADD");
		panelSouth.add(btnAdd);
		
	
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btn1 = new JButton("1");
		btn1.setPreferredSize(new Dimension (200,70));
		panel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setPreferredSize(new Dimension (200,70));
		panel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setPreferredSize(new Dimension (200,70));
		panel.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setPreferredSize(new Dimension (200,70));
		panel.add(btn4);
		
		
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblNorth.setText(lblNorth.getText()+"1");
            }
        });
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblNorth.setText(lblNorth.getText()+"2");
            }
        });
		btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblNorth.setText(lblNorth.getText()+"3");
            }
        });
		btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblNorth.setText(lblNorth.getText()+"4");
            }
        });
		btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblNorth.setText(lblNorth.getText()+textField.getText());
            }
        });
	}

}
