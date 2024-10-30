package Hilos;

class CuentaBancaria {
    private int saldo = 0;

    // Método para depositar dinero
    public synchronized void depositar(int monto) {
        saldo += monto;
        System.out.println("Depositado: " + monto + ", Saldo actual: " + saldo);
        notify(); // Notifica a cualquier hilo en espera de que el saldo ha cambiado
    }

    // Método para retirar dinero
    public synchronized void retirar(int monto) {
        while (saldo < monto) { // Mientras no haya saldo suficiente, espera
            try {
                System.out.println("Saldo insuficiente para retirar " + monto + ". Esperando...");
                wait(); // Espera hasta que haya saldo suficiente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        saldo -= monto;
        System.out.println("Retirado: " + monto + ", Saldo actual: " + saldo);
    }
}

public class Banco {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();

        // Hilo de depósito
        new Thread(() -> {
            cuenta.depositar(100);
            cuenta.depositar(200);
        }).start();

        // Hilo de retiro
        new Thread(() -> {
            cuenta.retirar(150);
        }).start();
    }
}
