/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog07_tarea.clases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author
 */
public class Banco {

    final int MAX_CUENTAS = 100;
    ArrayList<CuentaBancaria> listaCuentas;
    int numCuentas;

    public Banco() {

        listaCuentas = new ArrayList();

    }

    //---------------------------------------------------------------        
    // MÉTODO abrirCuenta: Creación de una nueva cuenta bancaria
    //--------------------------------------------------------------- 
    public boolean abrirCuenta(CuentaBancaria cuenta) throws Exception {

        if (buscaCuenta(cuenta.obtenerCCC()) != null) {
            return false;
        }

        // Ingresamos el saldo inicial en la cuenta
        if (numCuentas < MAX_CUENTAS) {
            listaCuentas.add(cuenta);
            return true;
        }

        return false;
    }

    public CuentaBancaria buscaCuenta(String ccc) {

        Iterator<CuentaBancaria> it = listaCuentas.iterator();

        while (it.hasNext()) {
            if (it.next().obtenerCCC().equals(ccc)) {
                return it.next();
            }
        }
        return null;
    }

    //---------------------------------------------------------------        
    // MÉTODO listadoCuentas: Devuelve un array de cadenas con la información de cada cuenta.
    //---------------------------------------------------------------       
    public String[] listadoCuentas() throws Exception {
        String cuentas[] = new String[numCuentas];
        System.out.println("LISTADO DE CUENTAS DISPONIBLES");

        listaCuentas.forEach(cuenta -> {
            System.out.println(cuenta.devolverContenidoString());
        });
        return cuentas;
    }

    //---------------------------------------------------------------        
    // MÉTODO informacionCuenta: Devuelve String con información de una cuenta
    //---------------------------------------------------------------      
    public String informacionCuenta(String iban) {
        CuentaBancaria cuenta = buscaCuenta(CuentaBancaria.obtenerNumeroCuenta(iban));
        if (cuenta != null) {
            return cuenta.devolverContenidoString();
        }
        return null;
    }

    //---------------------------------------------------------------        
    // MÉTODO ingresoCuenta: Ingreso de una cantidad en una cuenta
    //---------------------------------------------------------------       
    public boolean ingresoCuenta(String iban, double cantidad) throws Exception {

        CuentaBancaria cuenta = buscaCuenta(CuentaBancaria.obtenerNumeroCuenta(iban));
        if (cuenta != null) {
            cuenta.ingresar(cantidad);
            return true;
        }
        return false;
    }

    public boolean retiradaCuenta(String iban, double cantidad) throws Exception {

        CuentaBancaria cuenta = buscaCuenta(CuentaBancaria.obtenerNumeroCuenta(iban));
        if (cuenta != null) {
            cuenta.retirar(cantidad);
            return true;
        }
        return false;
    }

    public double obtenerSaldo(String iban) throws Exception {

        CuentaBancaria cuenta = buscaCuenta(CuentaBancaria.obtenerNumeroCuenta(iban));
        if (cuenta != null) {
            return cuenta.obtenerSaldo();
        }
        return -1;
    }

    public boolean eliminarCuenta(String iban) throws Exception {

        Iterator<CuentaBancaria> it = listaCuentas.iterator();

        while (it.hasNext()) {
            CuentaBancaria cuenta = it.next();
            if (cuenta.obtenerCCC().equals(CuentaBancaria.obtenerNumeroCuenta(iban))) {
                if (cuenta.obtenerSaldo() == 0) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    /*
     Vuelca los objetos CuentaBancarias a un fichero binario
     */
    public String persisteAFichero(String nombreFich) {
        ObjectOutputStream salida = null;

        try {
            File fichero = new File(nombreFich);
            
            salida = new ObjectOutputStream(new FileOutputStream(fichero));
            System.out.println("Fichero abierto");

            Iterator<CuentaBancaria> it = listaCuentas.iterator();

            while (it.hasNext()) {
                CuentaBancaria cuenta = it.next();
                salida.writeObject(cuenta);
            }
        } catch (FileNotFoundException e) {
            return "El fichero indicado no existe";
        } catch (IOException e) {
            return e.getMessage();
        } finally {
            try {
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                return e.getMessage();
            }
        }
        return null;
    }

    public String cargaDesdeFichero(String nombreFich) {
        ObjectInputStream entrada = null;

        try {
            entrada = new ObjectInputStream(new FileInputStream(nombreFich));
            System.out.println("Fichero abierto");

            CuentaBancaria cuenta = (CuentaBancaria) entrada.readObject();

            try {
            while (cuenta != null) {
                listaCuentas.add(cuenta);
                cuenta = (CuentaBancaria) entrada.readObject();
            }
            } catch (EOFException e){
            
            }
        } catch (FileNotFoundException e) {
            return "El fichero indicado no existe";
        } catch (IOException | ClassNotFoundException  e) {
             return e.getMessage();
        }
        finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                return e.getMessage();
            }
        }
        return null;
    }

}
