package Pre;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Swing09 {
    
public static void main(String[] args) {
    JFrame frame = new JFrame("Seleccionador de opciones");
frame.setSize(300,200);
frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
frame.setLayout(null);
frame.setLocation(null);

JCheckBox checkBox1 = new JCheckBox("Opc 1");
JCheckBox checkBox2 = new JCheckBox("Opc 2");
JButton botonMostrar =  new JButton("Mostras seleccione");
JLabel label1 = new JLabel("Selecciona una opcion");

}



}
