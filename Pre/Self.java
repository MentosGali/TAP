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

public class Self {
    

public static void main(String[] args) {
    JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
frame.pack(); 
frame.setSize(400, 200);
frame.setLayout(new FlowLayout());
frame.setLocationRelativeTo(null);


JButton botonMotrar = new JButton("Mostrar");
JButton botonColor = new JButton("Change Color");
JButton botonBorrar = new JButton("Borrar");
JLabel etiqueta = new JLabel("Informacion: ");
TextField campotexto = new TextField  ("                      ");


botonMotrar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e){
    etiqueta.setText("Informacion: "+campotexto.getText());
}
});

botonColor.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e){
    frame.getContentPane().setBackground(new Color((int)(Math.random() * 0x1000000)));
campotexto.setBackground(new Color((int)(Math.random() * 0x1000000)));
etiqueta.setForeground(new Color((int)(Math.random() * 0x1000000)));
}
});

botonBorrar.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e){
    etiqueta.setText("Informacion: ");
    campotexto.setText("");
    campotexto.setBackground(Color.white);
    frame.getContentPane().setBackground(null);
    etiqueta.setForeground(null);
   } 
});




frame.add(campotexto);
frame.add(botonMotrar);
frame.add(botonBorrar);
frame.add(botonColor);

frame.add(etiqueta);

frame.setVisible(true);
}



}
