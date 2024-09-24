package Practicas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Practica02 extends JFrame {
JLabel etiqueta;
JTextField campotexto;
JButton boton;

static int intentos=5;
static int fallos =0;
static int numero = new Random().nextInt(100) + 1;


void adivinaNumero() {

try{
    int num = Integer.parseInt(campotexto.getText());
    if( num== numero){
etiqueta.setText("ADIVINASTE EL NUMERO :D " + numero);

boton.setEnabled(false);
    }else{
        if (num<numero) {
           etiqueta.setText("El numero debe ser mayor a: "+ num);
           campotexto.setText("");
           campotexto.requestFocus();
        }else{
            etiqueta.setText("El numero debe ser menor a: "+ num);
            campotexto.setText("");
            campotexto.requestFocus();
        }
        fallos++;    
}

if(fallos>=intentos) {etiqueta.setText("El numero era: "+ numero + " PERDISTE JIJIJIJA");
boton.setEnabled(false);
}
}catch(Exception e){
etiqueta.setText("Digite un numero entre 1 y 100");
}
}

public Practica02(){
    
setTitle("Adivina el numero");
setSize(300,200);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new FlowLayout());
setLocationRelativeTo(null);

etiqueta= new JLabel("Digite un numero entre 1 y 100: ");
boton = new JButton("Prueba");
campotexto= new JTextField(10);

boton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        campotexto.setColumns(20);
        adivinaNumero();
        //campotexto.requestFocus();
    }
});





add(etiqueta);
add(campotexto);
add(boton);

setVisible(true);
}

public static void main(String[] args) {
    Practica02 pra2 = new Practica02();
}

}
