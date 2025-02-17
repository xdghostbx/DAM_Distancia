package trabajo;

public class Persona {
    public boolean jefePresente = false;

    public synchronized void llegarJefe() {
        jefePresente = true;
        System.out.println("{"+Thread.currentThread().getName()+"}"+" HE LLEGADO");
        notifyAll(); 
    }

    public synchronized void salirJefe() {
        jefePresente = false;
        System.out.println("{"+Thread.currentThread().getName()+"}"+" Ahora vuelvo...");
    }

    public synchronized void esperarJefe() throws InterruptedException {
        if(jefePresente){
            System.out.println("{"+Thread.currentThread().getName()+"}"+" hola jefe, me pongo a trabajar...");
        }
        while (!jefePresente) {
            System.out.println("{"+Thread.currentThread().getName()+"}"+" ZZZZ");
            wait();
            System.out.println("{"+Thread.currentThread().getName()+"(desperezandose..)}"+" eh, a trabajar");
        }
        
        
    }
}
