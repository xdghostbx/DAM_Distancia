package Tarea_opcional.tareaOpcional;

public class Persona {
    private String nombre;
    private String contraseña;
    private int numConexiones;
    private boolean conectado;

    public Persona(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.numConexiones = 0;
        this.conectado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getNumConexiones() {
        return numConexiones;
    }

    public void incrementarConexiones() {
        this.numConexiones++;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                "tiene numero de Conexiones: " + numConexiones +
                '}';
    }
}
