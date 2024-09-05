package Pre;

import javax.swing.*;

public class Swing02 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HolaMundo en Swing");
        frame.setSize(500, 300);
        //when close the window, the program exits
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}