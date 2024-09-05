package Pre;

import javax.swing.*;
import java.awt.*;

public class Swing04 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing 3");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JButton("Boton Swing"));
        frame.getContentPane().add(new JButton("Otro boton Swing"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
