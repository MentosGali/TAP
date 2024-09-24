import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {
    private JTextField resultado = new JTextField("0");
    
    private JPanel panel = new JPanel(new GridLayout(4,4, 4, 4));
    private JLabel etiqueta = new JLabel("Calculadora PRO");
 
    private boolean limpiarResultado = true;
    private int valorAcumulado = 0;
    private String operacionActual = "";

    Calculadora() {
        resultado.setFont(new Font("Arial", Font.BOLD, 20));  // Cambiar el tipo de letra y tamaño
        resultado.setForeground(Color.BLUE);  // Cambiar el color del texto
        resultado.setBackground(Color.LIGHT_GRAY);  // Cambiar el color de fondo
        resultado.setHorizontalAlignment(JTextField.RIGHT);  // Alinear el texto a la derecha
        resultado.setEditable(false);

        etiqueta.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT,13));
        etiqueta.setForeground(Color.MAGENTA);
        etiqueta.setHorizontalAlignment(JLabel.CENTER);

        setTitle("Calculadora");//la parte de arriba
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 200);

        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton bDiv = new JButton("/");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton bMul = new JButton("*");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton bDiff = new JButton("-");
        JButton b0 = new JButton("0");
        JButton bEquals = new JButton("=");
        JButton bPlus = new JButton("+");

        bEquals.setBackground(Color.white);
        bPlus.setBackground(Color.YELLOW);
        bDiff.setBackground(Color.GREEN);
        resultado.setBackground(Color.white);

        // Añade los botones al panel
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bDiv);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bMul);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bDiff);
        panel.add(b0);
        panel.add(new JLabel(""));  // Espacio en blanco
        panel.add(bEquals);
        panel.add(bPlus);

        // Función del botón "+"
        bPlus.addActionListener(e -> {
            realizarOperacion();  // Actualiza el valor acumulado sin mostrar el resultado
            operacionActual = "+";  // Establece la operación actual
            limpiarResultado = true;  // Limpiar para la siguiente entrada
        });

        // Función del botón "-"
        bDiff.addActionListener(e -> {
            realizarOperacion();
            operacionActual = "-";
            limpiarResultado = true;
        });

        // Función del botón "*"
        bMul.addActionListener(e -> {
            realizarOperacion();
            operacionActual = "*";
            limpiarResultado = true;
        });

        // Función del boton "/"
         bDiv.addActionListener(e->{
            realizarOperacion();
            operacionActual = "/";
            limpiarResultado = true;
          });

        // Función del botón "="
        bEquals.addActionListener(e -> {
            realizarOperacion();
            resultado.setText(String.valueOf(valorAcumulado));
            operacionActual = "";
            limpiarResultado = true;
        });

        // Método auxiliar para los botones numéricos
        agregarListenerBoton(b0);
        agregarListenerBoton(b1);
        agregarListenerBoton(b2);
        agregarListenerBoton(b3);
        agregarListenerBoton(b4);
        agregarListenerBoton(b5);
        agregarListenerBoton(b6);
        agregarListenerBoton(b7);
        agregarListenerBoton(b8);
        agregarListenerBoton(b9);

        panel.setBackground(Color.gray);
        add(resultado, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(etiqueta, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Método auxiliar para evitar repetir código
    private void agregarListenerBoton(JButton boton) {
        boton.addActionListener(e -> {
            if (resultado.getText().equals("0") || limpiarResultado) {
                resultado.setText(boton.getText());
                limpiarResultado = false;
            } else {
                resultado.setText(resultado.getText() + boton.getText());
            }
        });
    }

    // Método para realizar la operación acumulativa
    private void realizarOperacion() {
        int valorActual = Integer.parseInt(resultado.getText());
        
        if (operacionActual.equals("+")) {
            valorAcumulado += valorActual;
        } else if (operacionActual.equals("-")) {
            valorAcumulado -= valorActual;
        } else if (operacionActual.equals("*")) {
            valorAcumulado *= valorActual;
        } else if (operacionActual.equals("/")) {
            valorAcumulado = valorActual;
        } else {
            valorAcumulado = valorActual;
        }
    }

    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
    }
}