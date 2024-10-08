package Pre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Swing22 extends JFrame {
    private JMenuBar menubar = new JMenuBar();
    private JMenu archivo = new JMenu("archico");
    private JMenu ayuda = new JMenu("ayuda");
    private JMenuItem itemabri = new JMenuItem("abrir");

    Swing22() {
        setTitle("Ejemplo menus");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        itemabri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser choice = new JFileChooser();
                int opc = choice.showOpenDialog(null);

                if (opc == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = choice.getSelectedFile();
                } else if (opc == JFileChooser.CANCEL_OPTION) {
                    System.out.println("seleccion cancelada");
                }
            }
        });

        menubar.add(archivo);
        archivo.add(itemabri);

        menubar.add(ayuda);
        setJMenuBar(menubar);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Swing22();
    }
}
