package U2;

import javax.swing.*;import java.awt.*;
import java.awt.event.FocusAdapter;import java.awt.event.FocusEvent;
class TimeInputComponent extends JPanel {
    private JTextField hoursField;    private JTextField minutesField;
    private JTextField secondsField;
    public TimeInputComponent() {        setLayout(new FlowLayout());
        hoursField = createTextField(2);
        minutesField = createTextField(2);        secondsField = createTextField(2);
        add(new JLabel("Horas:"));
        add(hoursField);        add(new JLabel("Min:"));
        add(minutesField);        add(new JLabel("Seg:"));
        add(secondsField);    }
    // Método para crear un JTextField con un validador numérico
    private JTextField createTextField(int columns) {        JTextField field = new JTextField(columns);
        field.addFocusListener(new FocusAdapter() {            @Override
        public void focusLost(FocusEvent e) {                // Validación simple: asegurarse de que el valor sea numérico
            String text = field.getText();                try {
                int value = Integer.parseInt(text);                    // Asegurarse de que las horas estén en [0, 23] y minutos/segundos en [0, 59]
                if (value < 0 || value > 59 || (field == hoursField && value > 23)) {                        JOptionPane.showMessageDialog(null, "Por favor, introduce un valor válido.");
                    field.setText("00");                    }
            } catch (NumberFormatException ex) {                    JOptionPane.showMessageDialog(null, "Por favor, introduce solo números.");
                field.setText("00");                }
        }        });
        return field;    }
    // Método para obtener la hora completa como un String
    public String getTime() {        return String.format("%02d:%02d:%02d",
            Integer.parseInt(hoursField.getText()),                Integer.parseInt(minutesField.getText()),
            Integer.parseInt(secondsField.getText()));    }
}

