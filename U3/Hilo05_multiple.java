    package U3;

    class RecursoCompartido {

        public synchronized void esperarNotificacion() {
            try {
                System.out.println(Thread.currentThread().getName() + " está esperando la notificación...");
                wait(); // El hilo espera hasta recibir una notificación
                System.out.println(Thread.currentThread().getName() + " ha sido notificado y continúa.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void enviarNotificacion() {
            System.out.println(Thread.currentThread().getName() + " está notificando a todos los hilos...");
            notifyAll(); // Notifica a todos los hilos que están esperando
        }
    }

    class HiloEsperando implements Runnable {
        private final RecursoCompartido recurso;

        public HiloEsperando(RecursoCompartido recurso) {
            this.recurso = recurso;
        }

        @Override
        public void run() {
            recurso.esperarNotificacion();
        }
    }

    class HiloNotificador implements Runnable {
        private final RecursoCompartido recurso;

        public HiloNotificador(RecursoCompartido recurso) {
            this.recurso = recurso;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000); // Espera un momento antes de notificar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            recurso.enviarNotificacion();
        }
    }

    class HiloCediendo implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " en ejecución... cediendo el turno.");
                try {
                    Thread.sleep(1000); // Añade una pequeña pausa para observar la ejecución
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield(); // Cede el turno para que otros hilos tengan oportunidad de ejecutarse
            }
            System.out.println(Thread.currentThread().getName() + " ha terminado.");
        }
    }

    // Clase principal
    public class Hilo05_multiple {
        public static void main(String[] args) {
            System.out.println("\n\n");
            RecursoCompartido recurso = new RecursoCompartido();
            Thread hiloEsperando1 = new Thread(new HiloEsperando(recurso), "Hilo Esperando 1");
            Thread hiloEsperando2 = new Thread(new HiloEsperando(recurso), "Hilo Esperando 2");
            Thread hiloNotificador = new Thread(new HiloNotificador(recurso), "Hilo Notificador");
            Thread hiloCediendo = new Thread(new HiloCediendo(), "Hilo Cediendo");

            hiloEsperando1.start();
            hiloEsperando2.start();
            hiloNotificador.start(); // Inicia el hilo notificador antes de esperar a los hilos
            hiloCediendo.start();

            try {
                hiloEsperando1.join(); // Espera a que Hilo Esperando 1 termine antes de continuar
                hiloEsperando2.join(); // Espera a que Hilo Esperando 2 termine antes de continuar
                hiloNotificador.join(); // Espera a que Hilo Notificador termine antes de continuar
                hiloCediendo.join(); // Espera a que Hilo Cediendo termine antes de finalizar el programa
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ejecución del programa finalizada.");
        }
    }
