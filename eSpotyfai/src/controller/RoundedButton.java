package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;
public class RoundedButton extends AbstractBorder {
    private static final long serialVersionUID = 1L;
    private Color color;

    public RoundedButton(Color color) {
        this.color = color;
    }

    @Override
    public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.drawRoundRect(x, y, width - 1, height - 1, 10, 10);
    }

    @Override
    public Insets getBorderInsets(java.awt.Component c) {
        return new Insets(10, 10, 10, 10);
    }

    @Override
    public Insets getBorderInsets(java.awt.Component c, java.awt.Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = 10;
        return insets;
    }
}
