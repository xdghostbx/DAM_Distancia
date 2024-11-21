package trabajo;

public class Jefe implements Runnable {
    private Persona persona;  
    public Jefe(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep((long) (Math.random() * 10000));  
                persona.llegarJefe();  
                Thread.sleep(5000); 
                persona.salirJefe();  
            } catch (InterruptedException e) {
                System.out.println("Error con el jefe");
            }
        }
        
    }
}
