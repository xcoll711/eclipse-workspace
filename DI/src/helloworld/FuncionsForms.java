package helloworld;


import javax.swing.*;
import java.awt.*;

public class FuncionsForms {

    static void CreaFormulari(JFrame frmForm, int amplada, int alsada, String titulo) {

        frmForm.setTitle(titulo);
        frmForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frmForm.setSize(amplada, alsada);
    }

    static void lanzaFormulario(JFrame frmForm, boolean resizable, boolean visible) {

        frmForm.setLocationRelativeTo(null);
        frmForm.setResizable(resizable);
        frmForm.setVisible(visible);
    }

    static void setSize(JButton b1, int amplada, int alsada) {
        b1.setPreferredSize(new Dimension(amplada, alsada));

    }
}