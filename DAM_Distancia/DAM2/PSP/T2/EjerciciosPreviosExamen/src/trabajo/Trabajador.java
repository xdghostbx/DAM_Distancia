package trabajo;

public class Trabajador extends Thread{
    private Persona persona;  

    public Trabajador(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 10000));  
            System.out.println("{"+Thread.currentThread().getName()+"}"+ " ha llegado");

            persona.esperarJefe(); 

            Thread.sleep((long) (Math.random() * 10000)); 
            System.out.println("{"+Thread.currentThread().getName()+"}"+ " he terminado, me voy a casa");
        } catch (InterruptedException e) {
            System.out.println("Error con el trabajador");
        }
    }
}
