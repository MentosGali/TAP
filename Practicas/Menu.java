package Practicas;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    final JTextField texto = new JTextField(20);
    JMenuBar mb = new JMenuBar();
    JMenu[] menu;
    JMenuItem[] items;

    public Menu() {
        setTitle("Programacion de menus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 300);

        menu = new JMenu[] { new JMenu("Archivo"), new JMenu("ayuda") };
        items = new JMenuItem[] {
                new JMenuItem("Abrir"),
                new JMenuItem("Contacto")
        };

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                texto.setText(((JMenuItem) e.getSource()).getText());
                JFileChooser choise = new JFileChooser();
                int opc = choise.showOpenDialog(null);
            }
        };

        for (int i = 0; i < items.length; i++) {
            items[i].addActionListener(al);
        }

        menu[0].add(items[0]);
        menu[1].add(items[1]);

        for (int i = 0; i < menu.length; i++) {
            mb.add(menu[i]);
        }

        setJMenuBar(mb);
        setLayout(new FlowLayout());
        add(texto);
        setVisible(true);
    }

    /* hacer un menu que tenga un menu con archivo abrir y ayuda */
    public static void main(String[] args) {
        new Menu();
    }
}
