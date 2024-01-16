package exercise1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Exercise1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise1 frame = new Exercise1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Exercise1() {
		Dimension d = new Dimension(150,30);

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Set a GridLayout layout manager on the CENTER region
		JPanel panel_2 = new JPanel(new GridLayout(1, 3));
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 0, 255));
		panel_2.add(panel_3);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("CENTER");
		panel_3.add(lblNewJgoodiesLabel_2);

		JLabel lblNORTH = new JLabel("NORTH");
		lblNORTH.setBackground(new Color(255, 128, 255));
		lblNORTH.setHorizontalAlignment(SwingConstants.CENTER);
		lblNORTH.setOpaque(true);
		contentPane.add(lblNORTH, BorderLayout.NORTH);

		JLabel lblSOUTH = DefaultComponentFactory.getInstance().createLabel("SOUTH");
		lblSOUTH.setBackground(new Color(240, 240, 240));
		lblSOUTH.setHorizontalAlignment(SwingConstants.CENTER);
		lblSOUTH.setOpaque(true);
		contentPane.add(lblSOUTH, BorderLayout.SOUTH);
		
		JPanel panelWEST = new JPanel();
		panelWEST.setBackground(new Color(0, 255, 128));
		panelWEST.setPreferredSize(d);
		contentPane.add(panelWEST, BorderLayout.WEST);
		
		JLabel lblWEST = DefaultComponentFactory.getInstance().createLabel("WEST");
		panelWEST.add(lblWEST);
		
		JPanel panelEAST = new JPanel();
		panelEAST.setBackground(new Color(128, 255, 128));
		panelEAST.setPreferredSize(d);
		contentPane.add(panelEAST, BorderLayout.EAST);
		
		JLabel lblEAST = DefaultComponentFactory.getInstance().createLabel("EAST");
		lblEAST.setBackground(new Color(128, 255, 128));
		lblEAST.setHorizontalAlignment(SwingConstants.CENTER);
		panelEAST.add(lblEAST);
	}
}