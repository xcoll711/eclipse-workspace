package exercise4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;

public class Exercise4 {

    private JFrame frame;
    private JLabel lblHelloWorld;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Exercise4 window = new Exercise4();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Exercise4() {
        initialize();
    }

  
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblHelloWorld = new JLabel("");
        lblHelloWorld.setFont(new Font("Tahoma", Font.PLAIN, 68));
        lblHelloWorld.setHorizontalAlignment(0);
        frame.getContentPane().add(lblHelloWorld, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        
        
        
        
       JButton btn1 = new JButton("Click here!!");
       
       //added for exercise 5
       JButton btn2 = new JButton("Kaboom");

        panel.add(btn1);
        panel.add(btn2);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblHelloWorld.setText("Hello World");
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblHelloWorld.setText("");
            }
        });
    }
}
