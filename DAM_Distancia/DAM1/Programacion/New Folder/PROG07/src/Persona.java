


// Creamos la clase persona que implementa la interfaz imprimible

public class Persona implements Imprimible {
    //declaramos atributos de la clase
    private String nombre;
    private String apelidos;
    private String DNI;

    //getter y setter
    public Persona(String nombre, String apelidos, String DNI) {
        this.nombre = nombre;
        this.apelidos = apelidos;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    /*  Sobreescribimos el método devolverInfoString() para devolver una 
     *  representación en forma de cadena
     */
    @Override
    public String devolverInfoString() {
        return "nombre=" + nombre + ", apelidos=" + apelidos + ", DNI=" + DNI;
    }

    
    
}
