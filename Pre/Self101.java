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


public class Self101 extends JFrame {
    
Self101(){

    setTitle("Tarea");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(300,200);
setLocationRelativeTo(null);

JButton boton1 =  new JButton("Escribir texto");
JButton boton2 = new JButton("Leer texto");
JLabel label1 = new JLabel("Texto original");
JTextField texto = new JTextField(25);


boton1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        System.out.println("hola");
    }
});



}

}
