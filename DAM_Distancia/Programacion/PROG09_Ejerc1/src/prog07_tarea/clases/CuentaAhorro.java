/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog07_tarea.clases;

import java.io.Serializable;
import java.util.Hashtable;


//---------------------------------------------------------------        
//                      CLASE CuentaAhorro
//--------------------------------------------------------------- 
public class CuentaAhorro extends CuentaBancaria {

    //---------------------------------------------------------------        
    //                          ATRIBUTOS
    //---------------------------------------------------------------            
    // Atributos privados que almacenan el "estado" del objeto
    protected double tipoInteres;
    
    // Atributos estátticos públicos que almacenan constantes
    // relacionadas con características específicas de la clase
    public static final double MIN_TIPO_INTERES=  0.50;
    public static final double MAX_TIPO_INTERES=  8.50;    
    
    
    
    //---------------------------------------------------------------        
    //             CONSTRUCTORES
    //---------------------------------------------------------------            
    
    // Constructores
    public CuentaAhorro (Persona titular, String ccc, double tipoInteres) throws Exception {
        // Llamada al constructor de la superclase
        super (titular, ccc);
        
        // Establecimiento de atributos específicos
        establecerTipoInteres (tipoInteres);
    }    
 
    //---------------------------------------------------------------        
    //             MÉTODOS DE INTERFAZ
    //---------------------------------------------------------------    
    // Métodos públicos para manipular los objetos de esta clase
    
    // Método obtenerTipoInteres
    // Para consultar el interés de la cuenta de ahorro
    public double obtenerTipoInteres () {
        return this.tipoInteres;
    }    
    
    // Método establecerTipoInteres
    // Para establecer el interés de la cuenta de ahorro
    public final void establecerTipoInteres (double tipoInteres) throws Exception {
        if (tipoInteres<CuentaAhorro.MIN_TIPO_INTERES || tipoInteres>CuentaAhorro.MAX_TIPO_INTERES) 
            throw new Exception ("Tipo de interés de cuenta de ahorro no válido.");
        else 
            this.tipoInteres= tipoInteres;
    }
    
    // Implementación de métodos abstractos 
    // -------------------------------------
    
    // Método ingresar
    // Para ingresar una cantidad en la cuenta
    @Override
    public void ingresar (double cantidad) throws Exception {
        if (cantidad >0) {
            saldo += cantidad;
        }
        else {
            throw new Exception ("Cantidad no válida.");
        }
    }
    
    // Método retirar
    // Para retirar una cantidad de la cuenta
    @Override
    public void retirar (double cantidad) throws Exception {
        if (cantidad<0) {
            throw new Exception ("Cantidad no válida.");        
        }
        if (saldo>= cantidad) { // Si el saldo permite retirar esa cantidad
            saldo -= cantidad;  // Se retira esa cantidad (no se pueden tener descubiertos)
        }
        else {
            throw new Exception ("Saldo insuficiente.");        
        }
    }    
    
    // Método devolverContenidoString 
    @Override
    public String devolverContenidoString() {
        String contenido=super.devolverContenidoString() + " Tipo de Interés: " + tipoInteres;
        return contenido;
    }
}

