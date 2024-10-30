package Hilos;

class Tienda {
    public synchronized void esperar() {
        try {
            System.out.println(Thread.currentThread().getName() + " está esperando en la fila...");
            wait(); // El cliente espera a ser atendido
            System.out.println(Thread.currentThread().getName() + " está siendo atendido.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void atender() {
        System.out.println("El vendedor está atendiendo a un cliente...");
        notify(); // Notifica a un cliente en espera
    }
}

public class EjemploSincronizacion {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        // Clientes esperando
        Thread cliente1 = new Thread(() -> tienda.esperar(), "Cliente 1");
        Thread cliente2 = new Thread(() -> tienda.esperar(), "Cliente 2");

        // El vendedor atiende después de un tiempo
        Thread vendedor = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simula un retraso en la atención
                tienda.atender(); // Atiende a uno de los clientes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Vendedor");

        cliente1.start();
        cliente2.start();
        vendedor.start();
    }
}
