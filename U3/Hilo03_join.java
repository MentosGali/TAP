package U3;

class SimpleThread extends Thread {    private String threadName;
    public SimpleThread(String name) {
        this.threadName = name;    }
    public void run() {
        System.out.println(threadName + " ha comenzado.");        for (int i = 0; i < 3; i++) {
            System.out.println(threadName + " en ejecución...");        }
        System.out.println(threadName + " ha terminado.");    }
}
public class Hilo03_join {
    public static void main(String[] args) {        SimpleThread hilo1 = new SimpleThread("Hilo 1");
        SimpleThread hilo2 = new SimpleThread("Hilo 2");
        hilo1.start();
        try {
       hilo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hilo2.start();    }
}
