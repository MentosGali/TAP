package U3;


class YieldThread extends Thread {    private String threadName;
    public YieldThread(String name) {
        this.threadName = name;    }
    public void run() {
        for (int i = 0; i < 5; i++) {            System.out.println(threadName + " en ejecución...");
            Thread.yield(); // Este hilo cede su turno            // y sugiere al planificador de hilos dar oportunidad a otros hilos.
        }        System.out.println(threadName + " ha terminado.");
    }}

public class Hilo04_yield {
    public static void main(String[] args) {        YieldThread hilo1 = new YieldThread("Hilo 1");
        YieldThread hilo2 = new YieldThread("Hilo 2");
        hilo1.start();        hilo2.start();
    }}