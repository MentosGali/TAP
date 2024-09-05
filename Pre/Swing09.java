package Pre;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Swing09 {
    
public static void main(String[] args) {
    JFrame frame = new JFrame("Seleccionador de opciones");
    frame.pack();
frame.setSize(300,200);
frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
frame.setLayout(new FlowLayout());
frame.setLocationRelativeTo(null);

JCheckBox opc1 = new JCheckBox("Opc 1");
JCheckBox opc2 = new JCheckBox("Opc 2");
JButton botonMostrar =  new JButton("Mostrar seleccione");
JLabel etiqueta = new JLabel("Selecciona una opcion");


botonMostrar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String seleccion = "Seleccionado : ";
        if(opc1.isSelected()){
            seleccion += "Opcion 1";
        }
        if(opc2.isSelected()){
            seleccion += "Opcion 2";
        }
        etiqueta.setText(seleccion);
        }
});

frame.add(opc1);
frame.add(opc2);
frame.add(botonMostrar);
frame.add(etiqueta);

frame.setVisible(true);


}



}
