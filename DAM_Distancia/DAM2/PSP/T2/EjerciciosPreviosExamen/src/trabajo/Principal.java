package trabajo;

public class Principal {
    public static void main(String[] args) {
        Persona persona = new Persona();  
        
        Thread jefe = new Thread(new Jefe(persona), "Jefe");
        Thread trabajador1 = new Thread(new Trabajador(persona), "Marcos");
        Thread trabajador2 = new Thread(new Trabajador(persona), "Ana");
        Thread trabajador3 = new Thread(new Trabajador(persona), "Lucia");
        Thread trabajador4 = new Thread(new Trabajador(persona), "Pedro");

        jefe.start();
        trabajador1.start();
        trabajador2.start();
        trabajador3.start();
        trabajador4.start();

    }
}
