/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Concesionario;

import baseDatos.Consultas;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author xdGHOSTbx
 */
public class concesionario {
  private List<Vehiculo> vehiculos;
  
  public concesionario(){
    this.vehiculos = new ArrayList<>();
  }
  
  public void agregarVehiculo (Vehiculo vehiculo){
    vehiculos.add(vehiculo);
  }
  
  public  List<Vehiculo> getVehiculos(){
    return vehiculos;
  }
  
  public void mostrarVehiculos(){
    for (Vehiculo vehiculo : vehiculos){
      System.out.println(vehiculo);
    }
  }
  
  public Vehiculo buscaVehiculo(String matricula){
    for (Vehiculo vehiculo : vehiculos){
      if (vehiculo.getMatricula().equalsIgnoreCase(matricula)){
        return vehiculo;
      }
    }
    return null;
  }
  
  public int contarVehiculos(){
    return vehiculos.size();
  }
  /**
    * Guarda las cuentas en un fichero binario
    */
  public void guardarCoches() throws IOException{
        
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datosConcesionario.dat"))) {

        // Guardo cada coche
        for (Vehiculo vehiculo : vehiculos) {
            oos.writeObject(vehiculo);
        }

    } catch (FileNotFoundException ex) {
        System.out.println(ex.getMessage());
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }    
  }
  /**
   * Recupero las cuentas del fichero binario
   */
  public void recuperarCoches(){
        
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datosConcesionario.dat"))) {

        // Cuando me quede sin cuentas, salta la excepcion EOFException
        while(true){
            Vehiculo vehiculo = (Vehiculo)ois.readObject();
            agregarVehiculo(vehiculo);
        }

    } catch (FileNotFoundException ex) {
        System.out.println("No hay fichero");
    } catch (EOFException ex) {
        System.out.println("Coches añadidos del fichero");
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
        System.out.println(ex.getMessage());
    } 
        
  }
  
  /**
     * Genera un txt con la informacion de las cuentas
     */
    public void generarListado(){
        
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("ListadoVehiculos.txt"));) {
           
            String linea;
            // Recorro cada cuenta
            for (Vehiculo vehiculo : vehiculos) {
                linea = vehiculo.getMatricula()+", "+vehiculo.getMarca()+", "+vehiculo.getDescripcion()+", "+vehiculo.getKms()+", "+ vehiculo.getPrecio()+  "\r\n";
                bw.write(linea);
            }
            //bw.write("Num cuentas: " + vehiculos.size());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo"+ex.getMessage());
        }
        
    }
}
