package Pre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Swing10 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Seleccion opcion unica");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);

        
        JRadioButton opc1 = new JRadioButton("Opcion 1");
        JRadioButton opc2  = new JRadioButton("Opcion 2");
ButtonGroup groupOpcions = new ButtonGroup();
groupOpcions.add(opc1);
groupOpcions.add(opc2);

JButton botonSeleccionar= new JButton("Seleccionar");
JLabel etiqueta = new JLabel("Selecciona una opcion");



botonSeleccionar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
if(opc1.isSelected()){
    etiqueta.setText("Seleccionado: Opcion A" );
}else if( opc2.isSelected()){
    etiqueta.setText("Seleccionado: Opcion B");
}
else{
    etiqueta.setText("Sin seleccion");
}
    }
});


frame.add(opc1);
frame.add(opc2);
frame.add(botonSeleccionar);
frame.add(etiqueta);
frame.setVisible(true);

    }


}
