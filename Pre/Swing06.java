package Pre;

import javax.swing.*;

public class Swing06 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("¡Hola Swing!");
        JLabel etiqueta = new JLabel("<html><font color='red'>Hola a todos con Swing...</font></html>");



        frame.getContentPane().add(etiqueta);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
