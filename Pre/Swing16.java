package Pre;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Swing16 extends JFrame {
    JTable tabla;
    JScrollPane scrollPane;

    Swing16() {
        setTitle("Ejemplo tabla");
        setSize(400, 300); // Ajusté el tamaño de la ventana para mejor visibilidad
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        String[][] datos = {
                { "1", "juan", "ing" },
                { "2", "juan", "in3g" },
                { "3", "juan", "ing4" }
        };

        String[] columnas = { "ID", "Nombre", "Carrera" };

        tabla = new JTable(datos, columnas);
        scrollPane = new JScrollPane(tabla);

        // Ajustar el ancho de la columna ID
        TableColumn columnaID = tabla.getColumnModel().getColumn(0);
        columnaID.setPreferredWidth(50); // Ajusta el ancho de la columna ID

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Swing16();
    }
}
