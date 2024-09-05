package Practicas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Practica01 {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Practica 1");
      
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JButton botonC = new JButton("Cambiar color");
        JButton botonS = new JButton("Salir");

        
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(botonC);
        frame.getContentPane().add(botonS);

        frame.pack();
        frame.setSize(300,200);
        
        frame.setLocationRelativeTo(null);

        
        frame.setVisible(true);

       
        botonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().setBackground(new Color((int)(Math.random() * 0x1000000)));
            }
        });

        botonS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
