/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog07_tarea.clases;

//---------------------------------------------------------------        

import java.io.Serializable;
import prog07_tarea.interfaces.Imprimible;

//                      CLASE CuentaBancaria (abstracta)
//---------------------------------------------------------------            
public abstract class CuentaBancaria implements Imprimible, Serializable {

    //---------------------------------------------------------------        
    //                          ATRIBUTOS
    //---------------------------------------------------------------            
    // Atributos privados que almacenan el "estado" del objeto
    protected double saldo;
    protected Persona titular;
    private String ccc; //Realmente almacenará la cuenta sin ES del principio
    
    // Atributos estátticos públicos que almacenan constantes
    // relacionadas con características específicas de la clase
    public static final int MIN_LONG_TITULAR = 1;
    public static final int MAX_LONG_TITULAR = 40;


    //---------------------------------------------------------------        
    //             CONSTRUCTORES
    //---------------------------------------------------------------            
    // Constructores
    public CuentaBancaria(Persona titular, String ccc) throws Exception {
     
        
        if (CuentaBancaria.validarCuenta(ccc)) {
            this.ccc=ccc.substring(2, ccc.length()-1);

        }
        
        if (titular != null) {
            if (titular.getNombre().length() <= 20) {
                this.titular = new Persona(titular);
            } else {
                throw new Exception("Longitud excesiva.");
            }
        } else {
            throw new Exception("Cadena vacía.");
        }
    }


    //---------------------------------------------------------------        
    //             MÉTODOS DE INTERFAZ
    //---------------------------------------------------------------    
    // Métodos públicos para manipular los objetos de esta clase
    // Método obtenerSaldo
    // Para consultar el saldo actual de la cuenta
    public double obtenerSaldo() {
        return this.saldo;
    }

    // Método obtenerTitular
    public Persona obtenerTitular() {
        Persona resultado = new Persona(this.titular);
        return resultado;
    }

    // Método obtenerEntidad
    public String obtenerEntidad() {
        return this.ccc.substring(0, 4);
    }

    // Método obtenerOficina
    public String obtenerOficina() {
        return this.ccc.substring(4,8);
    }

    // Método obtenerCuenta
    public String obtenerCuenta() {
        return this.ccc.substring(10,19);
    }

    public String obtenerCCC(){
        return this.ccc;
    }

    // Método devolverContenidoString 
    @Override
    public String devolverContenidoString() {
        String contenido=titular.devolverContenidoString() + " Cuenta: " + ccc + " Saldo: " + saldo;
        return contenido;
    }

    public static boolean validarCuenta (String ccc){
        return ccc.matches("^ES[0-9]{20}$");  //Versión simple para validar un DNI.
    }
    
    
    public static String obtenerNumeroCuenta (String iban){
        return (iban.substring(2, iban.length()-1));
    }
    
    
    // Métodos abstactos (sin implementar)
    // -----------------------------------
    // Método ingresar
    // Para ingresar una cantidad en la cuenta
    public abstract void ingresar(double cantidad) throws Exception;

    // Método retirar
    // Para retirar una cantidad de la cuenta
    public abstract void retirar(double cantidad) throws Exception;

    
}
