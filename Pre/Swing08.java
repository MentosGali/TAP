package Pre;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Swing08 {
    
public static void main(String[] args) {
    JFrame frame = new JFrame();
frame.setSize(300,200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new FlowLayout());
frame.setLocationRelativeTo(null);


    JLabel etiqueta = new JLabel("Texto de inicio");
    JButton buttonCambiar = new JButton("Cambiar texto");
    JButton buttonOriginal = new JButton("Volver al original");

buttonCambiar.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
    etiqueta.setText("Texto modificado");
}
});

buttonOriginal.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        etiqueta.setText("Texto de inicion con boton");
    }
});
 

frame.add(etiqueta);
frame.add(buttonCambiar);
frame.add(buttonOriginal);

frame.setVisible(true);
//frame.pack();
}



}
