package U2;

import javax.swing.*;import java.awt.*;
import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;
public class CirculoCreciente extends JComponent {
    private int diametro = 50;

    public CirculoCreciente() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                diametro += 10;           repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - diametro) / 2;
        int y = (getHeight() - diametro) / 2;
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diametro, diametro);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }//tamaño para calcular con pack
}
