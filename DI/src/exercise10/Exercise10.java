package exercise10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import java.awt.ScrollPane;
import java.awt.Checkbox;

public class Exercise10 {

	private JFrame frame;
	private JTextField tfIdentifier;
	private JTextField tfName;
	private JTextField tfProgress;
	private JLabel lblAvg = new JLabel("Average: ");
	private ArrayList<Integer> listProgress = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise10 window = new Exercise10();
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
	public Exercise10() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		CardLayout cl = new CardLayout(0, 0);
		
		frame = new JFrame("Exercise 10 - Xavi");
		frame.setResizable(false);
		frame.setBounds(100, 100, 419, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(cl);
		
		JPanel panelTask = new JPanel();
		frame.getContentPane().add(panelTask, "nameTask");
		panelTask.setLayout(null);
		
		JLabel lblIdentifier = new JLabel("Identifier");
		lblIdentifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdentifier.setBounds(10, 11, 66, 14);
		panelTask.add(lblIdentifier);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(10, 48, 42, 14);
		panelTask.add(lblName);
		
		JLabel lblProgress = new JLabel("Progress");
		lblProgress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProgress.setBounds(10, 92, 66, 14);
		panelTask.add(lblProgress);
		
		tfIdentifier = new JTextField();
		tfIdentifier.setBounds(66, 9, 323, 20);
		panelTask.add(tfIdentifier);
		tfIdentifier.setColumns(10);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(50, 46, 339, 20);
		panelTask.add(tfName);
		
		tfProgress = new JTextField();
		tfProgress.setColumns(10);
		tfProgress.setBounds(66, 90, 323, 20);
		panelTask.add(tfProgress);
		
		JButton btnAdd = new JButton("ADD ");
		btnAdd.setBounds(10, 302, 379, 23);
		panelTask.add(btnAdd);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(133, 164, 177, 76);
		panelTask.add(lblNewLabel);
		
		JPanel panelHistory = new JPanel();
		panelHistory.setBorder(new TitledBorder(null, "Task history", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 0, 128)));
		frame.getContentPane().add(panelHistory, "nameHistory");
		panelHistory.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBot = new JPanel();
		panelBot.setBackground(new Color(183, 219, 187));
		panelHistory.add(panelBot, BorderLayout.SOUTH);
		
		lblAvg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBot.add(lblAvg);
		
		JScrollPane scrollPane = new JScrollPane();
		panelHistory.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelMid = new JPanel();
		scrollPane.setViewportView(panelMid);
		panelMid.setLayout(new BoxLayout(panelMid, BoxLayout.Y_AXIS));
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(new Color(143, 224, 164));
		menuBar.setBackground(new Color(143, 224, 164));
		frame.setJMenuBar(menuBar);
		
		JButton btnTask = new JButton("Task");
		btnTask.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTask.setBorderPainted(false);
		btnTask.setBackground(new Color(143, 224, 164));
		menuBar.add(btnTask);
		
		JButton btnHistory = new JButton("History");
		btnHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHistory.setBorderPainted(false);
		btnHistory.setBackground(new Color(143, 224, 164));
		menuBar.add(btnHistory);
		
		
		// Add action listeners to the buttons
		btnTask.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Show the panelTask panel
		    	cl.first(frame.getContentPane());
		    }
		});

		btnHistory.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		    	cl.last(frame.getContentPane());
		    }
		});
		
		btnAdd.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {



		     try {
		    	 
		    	 if(!tfProgress.getText().isEmpty() && !tfIdentifier.getText().isEmpty() && !tfName.getText().isEmpty()) {
		        JProgressBar progressBar = new JProgressBar();
		        JLabel lblProgressBar = new JLabel("");

		        lblProgressBar.setText("ID"+tfIdentifier.getText() + ":" + tfName.getText());

		        progressBar.setString(tfProgress.getText() + " %");
				int progress = Integer.parseInt(tfProgress.getText());

		        progressBar.setValue(progress);
		        progressBar.setStringPainted(true);

		        panelMid.add(lblProgressBar);
		        panelMid.add(progressBar);

		        JLabel lblEspai = new JLabel("\n");
		        panelMid.add(lblEspai);
		    	 
		        
 
		        listProgress.add(progress);
		        
		        int sum = 0;
		        int j = 0;
		        for (int p : listProgress) {
		            sum += p;
		            j++;
		          }
		        
		        System.out.println(sum/j);
		        
		    	 lblAvg.setText("Average: "+(sum/j));
		    	 
		    	 }

		    } catch (NumberFormatException exc) {
				System.out.println("That's not a number wtf");
			}
		         
		       
		    }
		});

		
		

	}
}
