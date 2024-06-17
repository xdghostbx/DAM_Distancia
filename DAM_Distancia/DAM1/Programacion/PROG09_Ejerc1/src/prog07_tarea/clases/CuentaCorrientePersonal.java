/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog07_tarea.clases;

//---------------------------------------------------------------        


//                      CLASE CuentaCorrientePersonal
//--------------------------------------------------------------- 
public class CuentaCorrientePersonal extends CuentaCorriente {

    //---------------------------------------------------------------        
    //                          ATRIBUTOS
    //---------------------------------------------------------------            
    // Atributos privados que almacenan el "estado" del objeto
    protected double comisionMantenimiento;

    // Atributos estátticos públicos que almacenan constantes
    // relacionadas con características específicas de la clase
    public static final double MIN_COMISION_MANTENIMIENTO = 0.00;
    public static final double MAX_COMISION_MANTENIMIENTO = 30.00;

    //---------------------------------------------------------------        
    //             CONSTRUCTORES
    //---------------------------------------------------------------            
    // Constructores
    public CuentaCorrientePersonal(Persona titular, String ccc, double comisionMantenimiento) throws Exception {
        super(titular, ccc);
        establecerComisionMantenimiento(comisionMantenimiento);
    }

    //---------------------------------------------------------------        
    //             MÉTODOS DE INTERFAZ
    //---------------------------------------------------------------    
    // Métodos públicos para manipular los objetos de esta clase
    // Método obtenerComisionMantenimiento
    // Para consultar el interés de la cuenta de ahorro
    public double obtenerComisionMantenimiento() {
        return this.comisionMantenimiento;
    }

    // Método establecerComisionMantenimiento
    // Para establecer el interés de la cuenta de ahorro
    public final void establecerComisionMantenimiento(double comisionMantenimiento) throws Exception {
        if (comisionMantenimiento < CuentaCorrientePersonal.MIN_COMISION_MANTENIMIENTO
                || comisionMantenimiento > CuentaCorrientePersonal.MAX_COMISION_MANTENIMIENTO) {
            throw new Exception("Comisión de mantenimiento de cuenta corriente personal no válida.");
        } else {
            this.comisionMantenimiento = comisionMantenimiento;
        }
    }

    // Implementación de métodos abstractos 
    // -------------------------------------
    // Método ingresar
    // Para ingresar una cantidad en la cuenta
    @Override
    public void ingresar(double cantidad) throws Exception {
        if (cantidad > 0) {
            saldo += cantidad;
        } else {
            throw new Exception("Cantidad no válida.");
        }
    }

    // Método retirar
    // Para retirar una cantidad de la cuenta
    @Override
    public void retirar(double cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("Cantidad no válida.");
        }
        if (saldo >= cantidad) { // Si el saldo permite retirar esa cantidad
            saldo -= cantidad;  // Se retira esa cantidad (no se pueden tener descubiertos)
        } else {
            throw new Exception("Saldo insuficiente.");
        }
    }

    // Implementación de los métodos de la interfaz Imprimible
    // -------------------------------------------------------
    // Método devolverContenidoString 
    @Override
    public String devolverContenidoString() {
        String contenido = super.devolverContenidoString() + " Comisión de Mantenimiento: " + comisionMantenimiento;
        return contenido;
    }

}
