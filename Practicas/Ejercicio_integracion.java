package Practicas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Ejercicio_integracion extends JFrame {
    private JTextField taskField;
    private JComboBox<String> priorityComboBox;
    private JSlider progresSlider;
    private JTable taskTable;
    private JProgressBar ProgressBar;
    private DefaultTableModel tableModel;

    public Ejercicio_integracion() {
        setTitle("Gestión de tareas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel tareasBotones = new JPanel(new GridLayout(3, 1));

        // Panel de ingreso de tareas
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Tarea: "));
        // aniade la entrada de texto
        taskField = new JTextField();
        inputPanel.add(taskField);
        // prioridad
        inputPanel.add(new JLabel("Prioridad: "));
        // aniade la caja de prioridades
        priorityComboBox = new JComboBox<>(new String[] { "Baja", "Media", "Alta" });
        inputPanel.add(priorityComboBox);

        // progreso
        inputPanel.add(new JLabel("Progreso:"));
        progresSlider = new JSlider(0, 100);
        // aniade la barra de progreso
        inputPanel.add(progresSlider);

        add(inputPanel, BorderLayout.NORTH);

        // Tabla de tareas
        tableModel = new DefaultTableModel(new Object[] { "Tarea", "Prioridad", "Progreso" }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer todas las celdas no editable
                return false;
            }
        };


        
        taskTable = new JTable(tableModel);
        add(new JScrollPane(taskTable), BorderLayout.CENTER);

        // Barra de progreso
        ProgressBar = new JProgressBar(0, 100);
        add(ProgressBar, BorderLayout.SOUTH);

        // Botón para agregar tareas
        JButton addButton = new JButton("Agregar Tarea");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        tareasBotones.add(addButton);

        // Botón para eliminar tareas
        JButton deleteButton = new JButton("Eliminar Tarea");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
        tareasBotones.add(deleteButton);

        // Botón para modificar tareas
        JButton modifyButton = new JButton("Modificar Tarea");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyTask();
            }
        });
        tareasBotones.add(modifyButton);

        add(tareasBotones, BorderLayout.EAST);
        setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText();
        String priority = (String) priorityComboBox.getSelectedItem();
        int progress = progresSlider.getValue();

        tableModel.addRow(new Object[] { task, priority, progress + "S" });
        updateOverallProgress();
        taskField.setText("");
    }

    private void deleteTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            updateOverallProgress();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para eliminar.");
        }
    }

    private void modifyTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow != -1) {
            String task = taskField.getText();
            String priority = (String) priorityComboBox.getSelectedItem();
            int progress = progresSlider.getValue();

            tableModel.setValueAt(task, selectedRow, 0);
            tableModel.setValueAt(priority, selectedRow, 1);
            tableModel.setValueAt(progress + "S", selectedRow, 2);
            updateOverallProgress();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para modificar.");
        }
    }

    private void updateOverallProgress() {
        int rowCount = taskTable.getRowCount();
        if (rowCount == 0)
            return;

        int totalProgress = 0;
        for (int i = 0; i < rowCount; i++) {
            String progressStr = (String) taskTable.getValueAt(i, 2);
            int progress = Integer.parseInt(progressStr.replace("S", ""));
            totalProgress += progress;
        }

        int averageProgress = totalProgress / rowCount;
        ProgressBar.setValue(averageProgress);
    }

    public static void main(String[] args) {
        new Ejercicio_integracion();
    }
}