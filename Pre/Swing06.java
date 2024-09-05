package Pre;

import javax.swing.*;

public class Swing06 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("¡Hola Swing!");
        
        frame.setLocationRelativeTo(null);
        //pack antes del tamaño de la ventana
        //pack is before size window
        frame.pack();
        frame.setSize(300,200);
        JLabel etiqueta = new JLabel("<html><font color='red'>Hola a todos con Swing...</font></html>");



        frame.getContentPane().add(etiqueta);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        
       
    }
}
