package U2.Componentes;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class ModernDatePicker2 extends JPanel {

    private JTextField dateField;
    private JButton calendarButton;
    private JDialog calendarDialog;
    private JPanel calendarPanel;
    private JLabel monthLabel; // Guardamos una referencia al JLabel del mes/año
    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;

    // Calendario para manejar los cambios de mes/año
    private Calendar calendar;

    // Constructor del DatePicker
    public ModernDatePicker2() {
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
        calendarDialog.setLayout(new BorderLayout());

        calendar = Calendar.getInstance();

        // Panel superior con los botones de navegación y el título del mes/año
        JPanel navigationPanel = new JPanel(new BorderLayout());

        // Botón para ir al mes anterior
        JButton prevButton = new JButton("<");
        prevButton.addActionListener(e -> {
            calendar.add(Calendar.MONTH, -1);  // Retrocede un mes
            updateCalendarPanel(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
        });
        navigationPanel.add(prevButton, BorderLayout.WEST);

        // Botón para ir al mes siguiente
        JButton nextButton = new JButton(">");
        nextButton.addActionListener(e -> {
            calendar.add(Calendar.MONTH, 1);  // Avanza un mes
            updateCalendarPanel(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
        });
        navigationPanel.add(nextButton, BorderLayout.EAST);

        // Etiqueta para mostrar el mes y el año actuales
        monthLabel = new JLabel("", JLabel.CENTER);  // Guardamos esta referencia para actualizarla directamente
        navigationPanel.add(monthLabel, BorderLayout.CENTER);

        calendarDialog.add(navigationPanel, BorderLayout.NORTH);

        // Panel para mostrar el calendario
        calendarPanel = new JPanel(new GridLayout(7, 7));
        calendarDialog.add(calendarPanel, BorderLayout.CENTER);

        // Botón para confirmar la selección de la fecha
        JButton selectButton = new JButton("Seleccionar");
        selectButton.addActionListener(e -> {
            Calendar cal = Calendar.getInstance();
            cal.set(selectedYear, selectedMonth, selectedDay);
            Date selectedDate = cal.getTime();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dateField.setText(sdf.format(selectedDate));

            calendarDialog.setVisible(false);
        });

        calendarDialog.add(selectButton, BorderLayout.SOUTH);
        calendarDialog.setSize(300, 300);

        // Inicializar el calendario con el mes actual
        updateCalendarPanel(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
    }

    // Método para mostrar el cuadro de diálogo del calendario
    private void showCalendarDialog() {
        selectedYear = calendar.get(Calendar.YEAR);
        selectedMonth = calendar.get(Calendar.MONTH);
        selectedDay = calendar.get(Calendar.DAY_OF_MONTH);

        calendarDialog.setLocationRelativeTo(this);
        calendarDialog.setVisible(true);
    }

    // Método para actualizar el panel del calendario
    private void updateCalendarPanel(int year, int month) {
        calendarPanel.removeAll();

        // Etiquetas para los días de la semana
        String[] daysOfWeek = {"Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"};
        for (String day : daysOfWeek) {
            JLabel label = new JLabel(day, JLabel.CENTER);
            calendarPanel.add(label);
        }

        // Actualizar la etiqueta del mes y año
        monthLabel.setText(new SimpleDateFormat("MMMM yyyy").format(calendar.getTime()));

        // Obtener el primer día del mes y cuántos días tiene
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1; // El domingo es 1, el sábado es 7
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Añadir espacios en blanco hasta el primer día del mes
        for (int i = 0; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel(""));
        }

        // Añadir los días del mes
        for (int day = 1; day <= daysInMonth; day++) {
            final int daySelected = day;
            JButton dayButton = new JButton(String.valueOf(day));
            dayButton.addActionListener(e -> selectedDay = daySelected);
            calendarPanel.add(dayButton);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    // Método para obtener la fecha seleccionada
    public String getSelectedDate() {
        return dateField.getText();
    }
}

public class Componente09 extends JFrame {

    // Constructor
    public Componente09() {
        setTitle("Modern DatePicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear una instancia del ModernDatePicker
        ModernDatePicker2 datePicker = new ModernDatePicker2();

        // Añadir el ModernDatePicker al frame
        add(datePicker, BorderLayout.CENTER);

        // Botón para mostrar la fecha seleccionada
        JButton showDateButton = new JButton("Mostrar Fecha");
        showDateButton.addActionListener(e -> {
            String selectedDate = datePicker.getSelectedDate();
            JOptionPane.showMessageDialog(this, "Fecha seleccionada: " + selectedDate);
        });

        add(showDateButton, BorderLayout.SOUTH);

        // Ajustar el tamaño de la ventana
        pack();
        setVisible(true);
    }

    // Método main que crea una instancia anónima del JFrame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Componente09());
    }
}
