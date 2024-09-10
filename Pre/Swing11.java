package Pre;
//FlowLayout
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class Swing11 extends JFrame{
//JComboBox  

//only acept String values
JComboBox <String> comboBox;
JLabel etiqueta;


Swing11(){

setTitle("Ejemplo ComboBox");
setSize(300,200);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new FlowLayout());
setLocationRelativeTo(null);

String[] opciones = {"Opcion 1", "Opcion 2", "Opcion 3"};
comboBox = new JComboBox<>(opciones);

etiqueta = new JLabel("Seleccione una opcion");


comboBox.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e){
String seleccion =  (String)  comboBox.getSelectedItem();
    etiqueta.setText("Seleccionaste: "+ seleccion);
    }
});

add(comboBox);
add(etiqueta);
setVisible(true);
}

public static void main(String[] args) {
    Swing11 ob = new Swing11();
    
}



}
