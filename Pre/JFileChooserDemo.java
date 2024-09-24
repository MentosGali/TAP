package Pre;

import javax.swing.JFileChooser;

public class JFileChooserDemo {
    public static void main(String[] args) {
        JFileChooser choise = new JFileChooser();
        int opc = choise.showOpenDialog(null);
    }
}
