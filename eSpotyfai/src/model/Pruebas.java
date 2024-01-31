package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.RoundedPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class Pruebas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pruebas window = new Pruebas();
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
	public Pruebas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		


		JPanel panel = new JPanel();
		panel.setBounds(105, 39, 630, 373);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		RoundedPanel rp = new RoundedPanel(25);
		rp.setBounds(0, 0,190, 270);
		rp.setBackground(new Color(28, 28, 28));
		panel.add(rp);
		rp.setLayout(null);
		
		RoundedPanel image = new RoundedPanel(25);
		
		image.setBounds(20, 24, 148, 137);
		rp.add(image);
		image.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIMG = new JLabel("");
		image.add(lblIMG, BorderLayout.CENTER);
		
		JLabel lblPlaylistName = new JLabel("Spotify");
		lblPlaylistName.setForeground(new Color(255, 255, 255));
		lblPlaylistName.setBounds(20, 175, 146, 22);
		lblPlaylistName.setFont(new Font("Dialog", Font.BOLD, 24));
		rp.add(lblPlaylistName);
		
		JLabel lblPlaylistArtist = new JLabel("Artists here");
		lblPlaylistArtist.setVerticalAlignment(SwingConstants.TOP);
		lblPlaylistArtist.setForeground(new Color(140, 140, 140));
		lblPlaylistArtist.setBounds(20, 208, 148, 51);
		lblPlaylistArtist.setFont(new Font("Dialog", Font.BOLD, 14));
		rp.add(lblPlaylistArtist);
		
		
		
	}
}
