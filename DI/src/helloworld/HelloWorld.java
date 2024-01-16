package helloworld;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class HelloWorld {

	public static void main(String[] args) {

        JFrame holaFrame = new JFrame();
        holaFrame.setTitle("Jelou uorld");
        
        FuncionsForms.CreaFormulari(holaFrame, 7, 77, "PRÁCTICA GRID LAYOUT ACT 02");

        
        JPanel holaPanel = new JPanel();
        
        JLabel holaLabel = new JLabel("Hello World");
        
       
        
        holaPanel.add(holaLabel);
       
        holaFrame.add(holaPanel);

        FuncionsForms.lanzaFormulario(holaFrame, true, true);

	}

}
