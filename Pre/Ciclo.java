package Pre;

import java.util.Random;

import javax.swing.JOptionPane;

public class Ciclo {
    static int intentos=10;

public static int leerNumero(){
  return Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));
}


static void adivinaNumero(){
    int fallos=0;
    Random numeRandom  = new Random();
    int numero= numeRandom.nextInt(1,100);
Boolean cond=false;
    while (fallos<=intentos) {
        int num = leerNumero();
        if( num== numero){
System.out.println("adivinaste el numero: "+ numero);
cond=true;
        }else{
            if (num<numero) {
                System.out.println("El numero debe ser mayor a: " + num);
            }else{
                System.out.println("El numero debe ser menor a: " +num);
            }
            fallos++;
        }
    }
    if(cond==false) System.out.println("El numero era: "+  numero);
}


public static void main(String[] args) {
    adivinaNumero();
}


}
