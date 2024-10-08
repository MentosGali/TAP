package Pre;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Swing13 extends JFrame {
    JSlider slide; // Asegúrate de usar el nombre correcto
    JLabel etiquetavalor;

    Swing13() {
        setTitle("Ejemplo slider");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        slide = new JSlider(0, 100, 50);
        slide.setMajorTickSpacing(20);
        slide.setMinorTickSpacing(5);
        slide.setPaintTicks(true);
        slide.setPaintLabels(true);

        etiquetavalor = new JLabel("Valor actual: 50");

        // Usamos 'slide' correctamente en lugar de 'slider'
        slide.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int valor = slide.getValue();
                etiquetavalor.setText("Valor actual: " + valor);
            }
        });

        add(slide);
        add(etiquetavalor);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Swing13();
    }
}
