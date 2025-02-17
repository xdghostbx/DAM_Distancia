public class Parking implements Runnable{
    private numPlazas;
    
    public Parking(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public void aparcar(){
        try {
            System.out.println(Thread.currentThread().getName()+" aparcado");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void salir(){
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" saliendo");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        aparcar();
        salir();
    }
}
