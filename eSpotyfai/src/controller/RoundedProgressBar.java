package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JProgressBar;

public class RoundedProgressBar extends JProgressBar {
    private int radius;

    public RoundedProgressBar(int radius) {
        this.radius = radius;
        setOpaque(false); // Asegúrate de que la barra de progreso sea transparente para que se vean los bordes redondeados.
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Puedes ajustar el color del borde según tus preferencias.
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
}
