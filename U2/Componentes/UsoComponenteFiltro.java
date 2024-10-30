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
                String entradaMinuscula = input.toLowerCase();
                System.out.println(entradaMinuscula);
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
                String aux = suggestion.toLowerCase();
                System.out.println(aux);
                if (aux.startsWith(entradaMinuscula)) {
                    listModel.addElement(suggestion);
                }
            }
        }
    }
}

public class UsoComponenteFiltro extends JFrame {

    public UsoComponenteFiltro() {
        setTitle("Componente de Autocompletado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Lista de sugerencias
        List<String> palabras = new ArrayList<>();
        palabras.add("Inteligencia Artificial");
        palabras.add("Machine Learnig");
        palabras.add("Blockchain");
        palabras.add("Computacion Cuantica");
        palabras.add("Internet de las cosas");
        palabras.add("Big data");
        palabras.add("Realidas aumentada");
        palabras.add("Realidad virtual");
        palabras.add("Ciberseguridad");
        palabras.add("Edge Computing");

        Autocompletar autoComplete = new Autocompletar(palabras);

        add(autoComplete, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UsoComponenteFiltro());
    }
}