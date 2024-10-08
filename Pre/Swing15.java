package Pre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class Swing15 extends JFrame {
    JList<String> lista; // Definir con tipo String
    JButton botonmostrar;
    JLabel etiqueta;

    Swing15() {
        setTitle("Ejemplo JList");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        String[] opc = { "Opc 1", "Opc 2", "Opc 3", "Opc 4" };
        lista = new JList<>(opc);
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lista.setVisibleRowCount(3);

        botonmostrar = new JButton("Mostrar");
        etiqueta = new JLabel("Selecciona");

        // Acción del botón
        botonmostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.util.List<String> seleccion = lista.getSelectedValuesList();
                etiqueta.setText("Seleccionaste: " + seleccion.toString());
            }
        });

        // Agregar los componentes al JFrame
        add(lista);
        add(botonmostrar);
        add(etiqueta);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Swing15();
    }
}
