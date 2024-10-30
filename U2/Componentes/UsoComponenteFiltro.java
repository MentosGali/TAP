package U2.Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;

class Autocompletar extends JPanel {
    private JTextField textField;
    private JList<String> suggestionList;
    private DefaultListModel<String> listModel;
    private List<String> suggestions;

    public Autocompletar(List<String> suggestions) {
        this.suggestions = suggestions;
        setLayout(new BorderLayout());

        // Inicializar el campo de texto
        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = textField.getText();

                updateSuggestions(input);
            }
        });

        // Inicializar la lista de sugerencias
        listModel = new DefaultListModel<>();
        suggestionList = new JList<>(listModel);

        add(textField, BorderLayout.NORTH);
        add(new JScrollPane(suggestionList), BorderLayout.CENTER);
    }

    // Método para actualizar las sugerencias según el texto ingresado
    private void updateSuggestions(String input) {
        String entradaMinuscula = input.toLowerCase();

        listModel.clear();
        if (!entradaMinuscula.isEmpty()) {
            for (String suggestion : suggestions) {
                suggestion.toLowerCase();
                if (suggestion.startsWith(input)) {
                    listModel.addElement(suggestion);
                }
            }
        }
    }
}

public class Componente06 extends JFrame {
    public Componente06() {
        setTitle("Componente de Autocompletado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Lista de sugerencias
        List<String> palabras = new ArrayList<>();
        palabras.add("Java");
        palabras.add("JavaScript");
        palabras.add("Python");
        palabras.add("PHP");
        palabras.add("C++");

        Autocompletar autoComplete = new Autocompletar(palabras);

        add(autoComplete, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Componente06());
    }
}
