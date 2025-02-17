public class Cajera implements Runnable{
    private String nombre;
    private static int cuenta = 0;

    private Cliente cliente;
    private long initialTime;

    public Cajera(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public synchronized void procesarCompra(Cliente cliente, long timeStamp){
        boolean disponible = true;
        if (disponible) {
            disponible = false;

            System.out.println("La cajera " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " -> Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        }

        System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
        cuenta++;

        System.out.println("El valor de cuenta es de "+cuenta);

        disponible = true;
        notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run(){ 
        synchronized(this){
            procesarCompra(cliente, initialTime);
        } 
        
        Thread.yield();
    }
}
