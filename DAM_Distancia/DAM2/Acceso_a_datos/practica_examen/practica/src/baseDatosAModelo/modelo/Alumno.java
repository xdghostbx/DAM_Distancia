package baseDatosAModelo.modelo;

import java.util.ArrayList;

public class Alumno {
    private String dni;
    private ArrayList<Asignatura> asignaturas;

    public Alumno(String dni) {
        this.dni = dni;
        this.asignaturas = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public void addAsignatura(Asignatura asignatura) {
        this.asignaturas.add(asignatura);
    }
}