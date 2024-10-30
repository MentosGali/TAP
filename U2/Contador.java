package U2;


import javax.swing.*;import java.awt.*;
public class Contador extends JComponent {
    private int valor = 0;    private JLabel etiqueta;
    private JButton botonMas;    private JButton botonMenos;
    public Contador() {
        setLayout(new BorderLayout());
        etiqueta = new JLabel("Valor: " + valor, SwingConstants.CENTER);        etiqueta.setFont(new Font("Arial", Font.BOLD, 24));
        add(etiqueta, BorderLayout.CENTER);
        botonMas = new JButton("Más");        botonMenos = new JButton("Menos");
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonMas);        panelBotones.add(botonMenos);
        add(panelBotones, BorderLayout.SOUTH);
        botonMas.addActionListener(e -> {            valor++;
            actualizarValor();        });
        botonMenos.addActionListener(e -> {
            valor--;            actualizarValor();
        });    }
    private void actualizarValor() {
        etiqueta.setText("Valor: " + valor);    }
}