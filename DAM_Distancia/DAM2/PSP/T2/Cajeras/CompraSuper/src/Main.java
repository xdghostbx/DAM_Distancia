public class Main {
    public static void main(String[] args) throws Exception {



        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        long initialTime = System.currentTimeMillis();

        Cajera cajera1 = new Cajera("Cajera 1", cliente1, initialTime);
        Cajera cajera2 = new Cajera("Cajera 2", cliente2, initialTime);

        Cajero cajero1 = new Cajero("Cajero 1", cliente1, initialTime);

        /*
        // Procesar la compra de los clientes por las cajeras
        cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2, initialTime);
        */

        

        //se inicicializan los distintos hilos (Runnable)
        Thread hilo1 = new Thread(cajera1, "cajera 1");
        Thread hilo2 = new Thread(cajera2, "cajera 2");
        Thread hilo3 = new Thread(cajera2, "cajera 2");
        Thread hilo4 = new Thread(cajera2, "cajera 2");

        
        //se inicializan los distintos hilos (Thread)
        //Thread hilo3 = new Thread(cajero1, "cajero 1");
        //Thread hilo4 = new Cajero("Cajero 2", cliente2, initialTime);

        

        System.out.println(hilo1.getPriority());
        System.out.println(hilo2.getPriority());
        System.out.println(hilo3.getPriority());
        System.out.println(hilo4.getPriority());
        

        hilo1.start();
        hilo2.start();

        hilo3.start();
        hilo4.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
    }
}
