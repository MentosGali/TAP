package U2.Componentes;

import javax.swing.*;
import java.awt.*;

public class Componente05 extends JFrame {
    public Componente05() {
    setTitle("Componente de Entrada de Hora");        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setLocationRelativeTo(null);
    TimeInputComponent timeInput = new TimeInputComponent();
    JButton showTimeButton = new JButton("Mostrar Hora");
    showTimeButton.addActionListener(e -> {            String time = timeInput.getTime();
        JOptionPane.showMessageDialog(null, "Hora ingresada: " + time);        });
    add(timeInput, BorderLayout.CENTER);
    add(showTimeButton, BorderLayout.SOUTH);
    pack();        setVisible(true);
}
    // Método main que crea una instancia anónima del JFrame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Componente05());    }
}