package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.net.URL;

public class RoundedImageIcon extends ImageIcon {

    private int cornerRadius;

    public RoundedImageIcon(String filename, int cornerRadius) {
        super(filename);
        this.cornerRadius = cornerRadius;
    }

    public RoundedImageIcon(URL resource , int cornerRadius) {
    	   super(resource);
           this.cornerRadius = cornerRadius;
           }

	@Override
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        int width = getIconWidth();
        int height = getIconHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, cornerRadius, cornerRadius);

        g2d.clip(roundedRectangle);
        super.paintIcon(c, g2d, 0, 0);
        g2d.dispose();

        g.drawImage(image, x, y, c);
    }
}