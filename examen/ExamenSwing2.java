package examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExamenSwing2 extends JFrame {
    private JLabel label;
    private JTextField textField;
    private JSlider slider;
    private JButton buttonCalcular;
    private JButton buttonReiniciar;

    public ExamenSwing2() {
        setTitle("Examen Swing 2");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.white);

        label = new JLabel("Introduce un número:");
        textField = new JTextField(10);
        slider = new JSlider(1, 10, 5); // Rango de 1 a 10, valor inicial 5
        slider.setMajorTickSpacing(2);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        // Aquí va la configuración de los ticks del JSlider

        buttonCalcular = new JButton("Calcular");

        buttonCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    int sve = (slider.getValue());
                    int jtfe = Integer.parseInt(textField.getText());
                    int mule = sve * jtfe;
                    JOptionPane.showMessageDialog(null, "El resultado es: " + mule);

                    if (mule > 50) {
                        getContentPane().setBackground(Color.red);
                    } else {
                        getContentPane().setBackground(Color.green);
                    }

                } catch (NumberFormatException E) {

                    JOptionPane.showMessageDialog(null, "Dijite un numero valido en el campo de texto");
                }

            }
        });

        buttonReiniciar = new JButton("Reinicia");
        buttonReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText((""));
                slider.setValue(5);
                getContentPane().setBackground(Color.white);
            }
        });

        add(label);
        add(textField);
        add(new JLabel("Selecciona un multiplicador (1-10):"));
        add(slider);
        add(buttonCalcular);
        add(buttonReiniciar);
    }

    public static void main(String[] args) {
        new ExamenSwing2().setVisible(true);
    }
}