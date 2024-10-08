import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Ejercicio_integracion extends JFrame {
    private JTextField taskField;
    private JComboBox<String> priorityComboBox;
    private JSlider progressSlider;
    private JTable taskTable;
    private JProgressBar progressBar;
    private DefaultTableModel tableModel;
    private JLabel sliderValueLabel;
    private boolean isEditing = false;

    public Ejercicio_integracion() {
        setTitle("Gestión de tareas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Inicialización de componentes
        taskField = new JTextField();
        taskField.setBounds(300, 10, 150, 25);
        add(taskField);

        priorityComboBox = new JComboBox<>(new String[] { "Baja", "Media", "Alta" });
        priorityComboBox.setBounds(10, 10, 200, 25);
        add(priorityComboBox);

        progressSlider = new JSlider(0, 100);
        progressSlider.setBounds(10, 65, 200, 25);
        add(progressSlider);

        sliderValueLabel = new JLabel("Porcentaje: 0%");
        sliderValueLabel.setBounds(10, 45, 100, 25);
        add(sliderValueLabel);

        progressSlider.addChangeListener(e -> {
            sliderValueLabel.setText("Porcentaje: " + progressSlider.getValue() + "%");
        });

        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(10, 120, 220, 15);
        add(progressBar);

        // Tabla donde se alistaran las tareas
        tableModel = new DefaultTableModel(new Object[] { "Tarea", "Prioridad", "Progreso" }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return isEditing; // Solo permite la edición si isEditing es true
            }
        };

        // La tabla
        taskTable = new JTable(tableModel);
        // Deshabilitar la capacidad de mover columnas
        taskTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(taskTable);
        scrollPane.setBounds(10, 150, 465, 200);
        add(scrollPane);

        JPanel tareasBotones = new JPanel();
        tareasBotones.setLayout(new BoxLayout(tareasBotones, BoxLayout.Y_AXIS));

        // Botón para agregar tareas
        JButton addButton = new JButton("Agregar Tarea");
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        Font fuentePerso = new Font("Times New Roman", Font.ITALIC, 14);
        addButton.setFont(fuentePerso);
        addButton.addActionListener(e -> addTask());
        tareasBotones.add(addButton);

        // Botón para eliminar tareas
        JButton deleteButton = new JButton("Eliminar Tarea");
        deleteButton.addActionListener(e -> deleteTask());
        tareasBotones.add(deleteButton);

        // Botón para modificar tareas
        JButton modifyButton = new JButton("Modificar Tarea");
        modifyButton.addActionListener(e -> toggleEditing());
        tareasBotones.add(modifyButton);

        // tamaño del boton modificar tarea
        tareasBotones.setBounds(350, 50, 125, 100);
        add(tareasBotones);

        setVisible(true);
    }

    // La barra de progreso"
    private void addTask() {
        String task = taskField.getText();
        String priority = (String) priorityComboBox.getSelectedItem();
        int progress = progressSlider.getValue();

        tableModel.addRow(new Object[] { task, priority, progress + "%" });
        taskField.setText("");
        updateOverallProgress();
    }

    // Metodo para eliminar una tarea
    private void deleteTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            updateOverallProgress();
        }
    }

    // Metodo para modificar tarea
    private void toggleEditing() {
        if (isEditing) {
            isEditing = false;
            JOptionPane.showMessageDialog(this, "Edición deshabilitada.");
        } else {
            int selectedRow = taskTable.getSelectedRow();
            if (selectedRow != -1) {
                isEditing = true;
                JOptionPane.showMessageDialog(this, "Ahora puede editar la tarea en la tabla. " +
                        "\n Pulse otravez ''Modificar tarea'' para desavilitar la edicion");
            }
        }
        taskTable.repaint(); // Refrescar la tabla para aplicar los cambios de edición
    }

    private void updateOverallProgress() {
        int rowCount = taskTable.getRowCount();
        if (rowCount == 0)
            return;

        int totalProgress = 0;
        for (int i = 0; i < rowCount; i++) {
            String progressStr = (String) taskTable.getValueAt(i, 2);
            int progress = Integer.parseInt(progressStr.replace("%", ""));
            totalProgress += progress;
        }

        int averageProgress = totalProgress / rowCount;
        progressBar.setValue(averageProgress);
    }

    public static void main(String[] args) {
        new Ejercicio_integracion();
    }
}