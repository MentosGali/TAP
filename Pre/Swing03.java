package Pre;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Swing03 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HolaMundo en Swing");
        frame.setSize(400, 300);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}
