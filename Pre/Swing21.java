package Pre;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing21 extends JFrame {
    final JTextField texto = new JTextField(20);
    JMenuBar mb = new JMenuBar();
    JMenu[] menu;
    JMenuItem[] items;

    public Swing21() {
        setTitle("Programacion de menus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 300);

        menu = new JMenu[] { new JMenu("Archivo"), new JMenu("ayuda") };
        items = new JMenuItem[] {
                new JMenuItem("Fundamentos de programacion"),
                new JMenuItem("Programacion orientada a objetos"),
                new JMenuItem("Estructura de Datos"),
                new JMenuItem("Topicos avanzados de programacion"),
                new JMenuItem("Programacion Logica y Funcional"),
                new JMenuItem("Fundamentos de Telecomunicaciones"),
                new JMenuItem("Administracino de Bases de datos"),
                new JMenuItem("Administracion de redes")
        };

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                texto.setText(((JMenuItem) e.getSource()).getText());
            }
        };

        for (int i = 0; i < items.length; i++) {
            items[i].addActionListener(al);
            menu[i % 2].add(items[i]);
        }

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
        new Swing21();
    }
}