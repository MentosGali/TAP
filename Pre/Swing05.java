package Pre;

import javax.swing.*;

public class Swing05 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("¡Hola Swing!");
        JLabel etiqueta = new JLabel("Hola a todos con Swing...");

        frame.getContentPane().add(etiqueta);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}