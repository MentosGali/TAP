package Pre;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Swing14 extends JFrame {
    JProgressBar progressBar; // Corrección en el nombre de la variable
    JButton botonInicia; // Corrección en el nombre de la variable
    Timer timer;

    Swing14() {
        setTitle("Ejemplo de ProgressBar");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        botonInicia = new JButton("Iniciar"); // Inicializamos el botón

        botonInicia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer = new Timer(); // Inicializamos el timer
                TimerTask tarea = new TimerTask() {
                    int progreso = 0;

                    @Override
                    public void run() {
                        progreso += 1;
                        progressBar.setValue(progreso);

                        if (progreso >= 100) {
                            timer.cancel(); // Detenemos el timer cuando llegue a 100
                        }
                    }
                };
                timer.scheduleAtFixedRate(tarea, 0, 100); // Ejecutamos cada 100 ms
            }
        });

        add(progressBar);
        add(botonInicia);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Swing14();
    }
}
