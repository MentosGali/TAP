package Pre;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.*;

public class Swing17 extends JFrame {
    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel panel1, panel2, panel3;

    Swing17() {
        setTitle("Ejemplo JTabbePane");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        panel1 = new JPanel();
        panel1.add(new JLabel("Contenido de la pestaña 1"));
        panel1.add(new JButton("boton 1"));

        panel2 = new JPanel();
        panel2.add(new JLabel("contendiod pesatan 2"));
        panel2.add(new JTextField("campo de texto", 15));

        panel3 = new JPanel();
        panel3.add(new JLabel("contenido 3"));
        panel3.add(new JCheckBox("opc 1"));
        panel3.add(new JCheckBox("opc 2"));

        tabbedPane.addTab("pestaña 1", panel1);
        tabbedPane.addTab("pestaña 2", panel2);
        tabbedPane.addTab("pestaña 3", panel3);
        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Swing17();
    }
}
