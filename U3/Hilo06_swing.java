package U3;

import javax.swing.*;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hilo06_swing extends JFrame {
    private JButton botonSinHilo;
    private JButton botonConHilo;    private JLabel etiqueta;
    public Hilo06_swing() {
        setTitle("Ejemplo de cómo trabaja un hilo en Swing");        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);        setLayout(null);
        setLocationRelativeTo(null);
        botonSinHilo = new JButton("Sin hilo");        botonSinHilo.setBounds(50, 30, 200, 30);
        add(botonSinHilo);
        botonConHilo = new JButton("Con hilo");        botonConHilo.setBounds(50, 80, 200, 30);
        add(botonConHilo);
        etiqueta = new JLabel("Presiona un botón");        etiqueta.setBounds(50, 130, 200, 30);
        add(etiqueta);
        // Acción sin hilo: la interfaz se congela        }
        botonSinHilo.addActionListener(new ActionListener() {
        @Override            public void actionPerformed(ActionEvent e) {
            etiqueta.setText("Procesando sin hilo...");                // Simula una tarea larga que congela la interfaz
            try {                    Thread.sleep(5000); // Esto congela la interfaz
            } catch (InterruptedException ex) {                    ex.printStackTrace();
            }                etiqueta.setText("Tarea sin hilo completada");
        }        });
    // Acción con hilo: la interfaz sigue respondiendo
        botonConHilo.addActionListener(new ActionListener() {            @Override
        public void actionPerformed(ActionEvent e) {                etiqueta.setText("Procesando con hilo...");
            // Crear un hilo para ejecutar la tarea larga
            new Thread(() -> {
            try {                        Thread.sleep(5000); // Simula una tarea larga
            } catch (InterruptedException ex) {                        ex.printStackTrace();
            }                    SwingUtilities.invokeLater(() -> etiqueta.setText("Tarea con hilo completada"));
        }).start();            }
});
setVisible(true);    }
public static void main(String[] args) {
    new Hilo06_swing();    }
}
