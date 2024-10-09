package U2.Componentes.Componente05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TimeInputComponent extends JPanel {
    private JTextField hoursField;
    private JTextField minutesField;
    private JTextField secondsField;

    public TimeInputComponent() {
        setLayout(new FlowLayout());
        hoursField = createTextField(2);
        minutesField = createTextField(2);
        secondsField = createTextField(2);

        add(new JLabel("Horas"));
        add(hoursField);
        add(new JLabel("Minutos"));
        add(minutesField);
        add(new JLabel("Segundos"));
        add(secondsField);
    }

    // metodo para crear un JTextField con un valor numerico

    private JTextField creaTextField(int columns) {
        JTextField field = new JTextField(columns);
        field.addFocusListener(new FocusListener() {
            public void focusLost(FocusEvent e) {
                String text = field.getText();
                int value = Integer.parseInt(text);
                // aseguramos que la hora este en tre 0 y 23
                // minutos/segundos de 0 a 59

                if (value < 0 || value > 59 || (field == hoursField && value > 23)) {
                    JOptionPane.showMessageDialog(null, "por favor, introuduce un numero valido");
                }
            }
        });
    }

}
