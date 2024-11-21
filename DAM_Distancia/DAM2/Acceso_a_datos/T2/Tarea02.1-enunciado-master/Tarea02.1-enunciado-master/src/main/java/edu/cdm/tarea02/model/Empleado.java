
package edu.cdm.tarea02.model;



import java.math.BigDecimal;

import java.time.LocalDate;

/**
 *
 * @author maria
 */
public class Empleado {

    private int empleadoId;
    private String nombre;
    private String puesto;

    private Empleado jefe;
    private LocalDate fechaContratacion;
    private BigDecimal salario;
    private BigDecimal comision;
    private Departamento departamento;

    public Empleado( String nombre, String puesto, Empleado jefe, LocalDate fechaContratacion, BigDecimal salario, BigDecimal comision, Departamento departamento) {
      
        this.nombre = nombre;
        this.puesto = puesto;
        this.jefe = jefe;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        this.comision = comision;
        this.departamento = departamento;
    }

    public Empleado() {
     
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Empleado getJefe() {
        return jefe;
    }

    public void setJefe(Empleado jefe) {
        this.jefe = jefe;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" + "empleadoId=" + empleadoId + ", nombre=" + nombre + ", puesto=" + puesto + ", jefe=" + jefe.getEmpleadoId() + ", fechaContratacion=" + fechaContratacion + ", salario=" + salario + ", comision=" + comision + ", departamento=" + departamento.getDeptno() + '}';
    }
    
    
    

}
