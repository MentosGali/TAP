package Pre;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Swing07 {
    private static String lblPrefijo = "No. clicks: ";
    private static int numClicks = 0;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Swing Evento 2");
        JButton boton = new JButton("Evento 2");
        final JLabel etiqueta = new JLabel(lblPrefijo + "0   ");

        boton.setMnemonic(KeyEvent.VK_U); // alt + U
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numClicks++;
                etiqueta.setText(lblPrefijo + numClicks);
            }}
        );

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(boton);
        frame.getContentPane().add(etiqueta);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);

       


    }
}




