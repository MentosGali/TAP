package Hilos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CirculoCreciente extends JComponent {
    private int diametro = 10;

    public CirculoCreciente() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                diametro += 10;  // Aumenta el tamaño del círculo
                repaint();  // Repinta el componente cuando se hace clic
            }
        });
    }


    public void agrandarCirculo() {
        diametro += 10;
        repaint();
    }

    public void decrecerCirculo() {
        diametro -= 10;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - diametro) / 2;
        int y = (getHeight() - diametro) / 2;
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diametro, diametro);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}


public class Hilo06_swing extends JFrame {

    private CirculoCreciente circulo;
    private JButton BotonHilo;
    private JButton botonDecreciete;
    private JButton botonAgrandar;
    private JButton botonSinHilo;
    private JLabel etiqueta;
    private JPanel panelbotones;
    private JLabel etiquetaAcciones;

    public Hilo06_swing() {
        setTitle("Hilo Circulo Creciente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(2,2));
        panelbotones = new JPanel();
        circulo = new CirculoCreciente();
        etiquetaAcciones = new JLabel("");

        botonAgrandar = new JButton("Agrandar Círculo");
        botonAgrandar.setBounds(50, 30, 200, 30);
        //add(botonAgrandar);
        botonDecreciete = new JButton("Disminuir circulo");
        botonDecreciete.setBounds(50, 30, 200, 30);
        //add(botonDecreciete);
        BotonHilo = new JButton("Boton Hilo");
        BotonHilo.setBounds(50, 80, 200, 30);
        //add(BotonHilo);
        botonSinHilo = new JButton("Boton sin Hilo");
        botonSinHilo.setBounds(50, 80, 200, 30);
        //add(botonSinHilo);


        etiqueta = new JLabel("Presiona un botón");
        etiqueta.setBounds(50, 130, 200, 30);

        add(etiqueta, BorderLayout.NORTH);
        add(circulo, BorderLayout.CENTER);
        panelbotones.add(botonDecreciete);
        panelbotones.add(botonAgrandar);
        panelbotones.add(botonSinHilo);
        panelbotones.add(BotonHilo);
        add(etiquetaAcciones, BorderLayout.BEFORE_LINE_BEGINS);
        add(panelbotones, BorderLayout.SOUTH);

        botonAgrandar.addActionListener(e -> {
            circulo.agrandarCirculo();
            etiquetaAcciones.setText("Círculo agrandado");
        });

        botonDecreciete.addActionListener(e -> {
            circulo.decrecerCirculo();
            etiquetaAcciones.setText("Círculo Decreciendo");
        });


        BotonHilo.addActionListener(e -> {
            etiqueta.setText("Procesando con hilo...");
            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                SwingUtilities.invokeLater(() -> etiqueta.setText("Tarea con hilo completada"));
            }).start();
            System.out.println("Completada");
        });

        botonSinHilo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("Procesando sin hilo...");
                try {
                    Thread.sleep(5000);  // Congela la interfaz
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                etiqueta.setText("Tarea sin hilo completada");
                repaint();  // Redibujar la interfaz
            }
        });



        setVisible(true);
    }

    public static void main(String[] args) {
        new Hilo06_swing();
    }
}
