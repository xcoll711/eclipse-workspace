package controller;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class RoundedImageIcon implements Icon {

    private ImageIcon imageIcon;
    private int width;
    private int height;

    public RoundedImageIcon(ImageIcon imageIcon, int width, int height) {
        this.imageIcon = imageIcon;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        Image roundedImage = createRoundedImage(imageIcon.getImage(), width, height);


        g.drawImage(roundedImage, x, y, c);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    private Image createRoundedImage(Image image, int width, int height) {
        BufferedImage roundedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = roundedImage.createGraphics();

        // Crear una forma redondeada para los bordes
        RoundRectangle2D roundedRect = new RoundRectangle2D.Double(0, 0, width, height, 25, 25);

        // Configurar el recorte para que solo se dibuje dentro de la forma redondeada
        g2d.setClip(roundedRect);

        // Dibujar la imagen original
        g2d.drawImage(image, 0, 0, width, height, null);

        // Liberar los recursos de Graphics2D
        g2d.dispose();

        return roundedImage;
    }
}
