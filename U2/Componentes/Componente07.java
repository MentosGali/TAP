package U2.Componentes;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class DatePickerComponent extends JPanel {
    private JTextField dateField;
    private JButton calendarButton;
    private JDialog calendarDialog;
    private JSpinner daySpinner, monthSpinner, yearSpinner;

    public DatePickerComponent() {
        setLayout(new BorderLayout());
        // Campo de texto para mostrar la fecha seleccionada
        dateField = new JTextField(10);
        dateField.setEditable(false);

        // Botón para abrir el calendario
        calendarButton = new JButton("📅");
        calendarButton.setMargin(new Insets(2, 2, 2, 2));
        calendarButton.addActionListener(e -> showCalendarDialog());

        // Añadir el campo de texto y el botón al panel
        add(dateField, BorderLayout.CENTER);
        add(calendarButton, BorderLayout.EAST);

        // Inicializar el cuadro de diálogo del calendario
        initCalendarDialog();
    }

    // Método para inicializar el cuadro de diálogo con el calendario
    private void initCalendarDialog() {
        calendarDialog = new JDialog((Frame) null, "Selecciona una fecha", true);
        calendarDialog.setLayout(new GridLayout(2, 1));

        JPanel calendarPanel = new JPanel();
        calendarPanel.setLayout(new FlowLayout());

        // Spinner para seleccionar el día
        daySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        calendarPanel.add(new JLabel("Día:"));
        calendarPanel.add(daySpinner);

        // Spinner para seleccionar el mes
        monthSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        calendarPanel.add(new JLabel("Mes:"));
        calendarPanel.add(monthSpinner);

        // Spinner para seleccionar el año
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        yearSpinner = new JSpinner(new SpinnerNumberModel(currentYear, currentYear - 100, currentYear + 100, 1));
        calendarPanel.add(new JLabel("Año:"));
        calendarPanel.add(yearSpinner);

        // Botón para confirmar la selección de la fecha
        JButton selectButton = new JButton("Seleccionar");
        selectButton.addActionListener(e -> {
            int day = (int) daySpinner.getValue();
            int month = (int) monthSpinner.getValue() - 1; // Los meses en Calendar comienzan en 0
            int year = (int) yearSpinner.getValue();

            Calendar cal = Calendar.getInstance();
            cal.set(year, month, day);
            Date selectedDate = cal.getTime();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dateField.setText(sdf.format(selectedDate));

            calendarDialog.setVisible(false);
        });

        calendarDialog.add(calendarPanel);
        calendarDialog.add(selectButton);
        calendarDialog.pack();
    }

    // Método para mostrar el cuadro de diálogo del calendario
    private void showCalendarDialog() {
        calendarDialog.setLocationRelativeTo(this);
        calendarDialog.setVisible(true);
    }

    // Método para obtener la fecha seleccionada
    public String getSelectedDate() {
        return dateField.getText();
    }
}

public class Componente07 extends JFrame {
    public Componente07() {
        setTitle("Componente DatePicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DatePickerComponent datePicker = new DatePickerComponent();

        add(datePicker, BorderLayout.CENTER);

        JButton showDateButton = new JButton("Mostrar Fecha");
        showDateButton.addActionListener(e -> {
            String selectedDate = datePicker.getSelectedDate();
            JOptionPane.showMessageDialog(this, "Fecha seleccionada: " + selectedDate);
        });

        add(showDateButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Componente07());
    }
}
