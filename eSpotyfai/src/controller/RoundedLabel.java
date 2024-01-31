package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedLabel extends JLabel {

    private int cornerRadius;

    public RoundedLabel(String text, int cornerRadius) {
        super(text);
        this.cornerRadius = cornerRadius;
    }

    public RoundedLabel(ImageIcon imageIcon, int cornerRadius2) {
    	  super(imageIcon);
          this.cornerRadius = cornerRadius;	
          }

	@Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, cornerRadius, cornerRadius);

        g2d.clip(roundedRectangle);
        super.paintComponent(g2d);
        g2d.dispose();
    }

}
