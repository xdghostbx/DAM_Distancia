package baseDatosAModelo.modelo;

public class Asignatura {
    private String nombreAsignatura;
    private double nota;

    public Asignatura(String nombreAsignatura, double nota) {
        this.nombreAsignatura = nombreAsignatura;
        this.nota = nota;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
