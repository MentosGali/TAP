package U2;
import javax.swing.*;import java.awt.*;
import java.awt.event.ActionEvent;import java.awt.event.ActionListener;
public class BarraProgreso extends JComponent {
    private JProgressBar progressBar;
    private JButton increaseButton;

    public BarraProgreso() {
        setLayout(new BorderLayout());
        progressBar = new JProgressBar(0, 100);  // Rango de 0 a 100        progressBar.setValue(0);  // Valor inicial
        progressBar.setStringPainted(true);  // Mostrar el porcentaje
        increaseButton = new JButton("Incrementar progreso");
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentValue = progressBar.getValue();
                if (currentValue < 100) {
                    progressBar.setValue(currentValue + 10);
                } else {
                    JOptionPane.showMessageDialog(null, "Progreso completado!", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        add(progressBar, BorderLayout.CENTER);
        add(increaseButton, BorderLayout.SOUTH);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 100); // Tamaño preferido del componente    }
    }
}