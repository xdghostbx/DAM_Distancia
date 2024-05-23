/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Concesionario;
import baseDatos.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author xdGHOSTbx
 */
public class Main {

  
  public static void main(String[] args) throws IOException, InterruptedException {
    concesionario concesionario = new concesionario();
    Consultas consultas = new Consultas();
    Scanner entrada = new Scanner (System.in);
    //concesionario.recuperarCoches();
    consultas.crearTablaSiNoExiste();
    int opcion = 0;
 
    do{
      menu();
      opcion = entrada.nextInt();
      entrada.nextLine();
      switch (opcion){
      case 1:
        System.out.println("Ingrese la matricula");
        String matricula = entrada.nextLine();

        System.out.println("Ingrese la marca");
        String marca = entrada.nextLine();

        System.out.println("Ingrese la descripcion");
        String descripcion = entrada.nextLine();

        System.out.println("Ingrese los kilometros");
        double kms = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Ingrese un precio");
        double precio = entrada.nextDouble();
        entrada.nextLine();


        Vehiculo vehiculo = new Vehiculo (matricula,marca,descripcion,kms,precio);
        concesionario.agregarVehiculo(vehiculo);
        break;
      case 2:
        System.out.println("Lista de vehiculos");
        concesionario.mostrarVehiculos();
        break;
      case 3:
        System.out.println("Introduce una matricula a buscar en el sistema");
        matricula = entrada.nextLine();
        Vehiculo encontrado = concesionario.buscaVehiculo(matricula);
        if(encontrado != null){
          System.out.println("Vehiculo encontrado");
          System.out.println(encontrado);
        }else
            System.out.println("No existen coches con esa matricula");
        break;
      case 4:
        int numero = concesionario.contarVehiculos();
        System.out.println("Hay "+numero+" de vehiculos guardados en el sistema");
        break;
      case 5:
        System.out.println("Se están guardando los datos...");
        TimeUnit.SECONDS.sleep(5);//un sleep para que de la sensacion que está trabajando
        System.out.println("Datos guardados con exito!");
        concesionario.guardarCoches();
        concesionario.generarListado();
        consultas.actualizarDesdeTxt();
        System.out.println("Saliendo...");
        break;
      default:
          System.out.println("Introduce una opcion validad");
          break;
    }
    }while(opcion != 5);
  }
  public static void menu(){
    System.out.println("Menú Concesionario");
    System.out.println("1. Agregar vehiculo");
    System.out.println("2. Mostrar vehiculos");
    System.out.println("3. Buscar vehiculos por matricula");
    System.out.println("4. Contar vehiculos");
    System.out.println("5. Salir y guardar al documento");
    System.out.println("Escoja una opcion"); 
  }
}
