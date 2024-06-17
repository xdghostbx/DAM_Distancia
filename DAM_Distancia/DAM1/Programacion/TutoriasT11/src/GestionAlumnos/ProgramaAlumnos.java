/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package GestionAlumnos;
import  Operaciones.*;
import java.util.Scanner;


/**
 *
 * @author xdGHOSTbx
 */
public class ProgramaAlumnos {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    OperacionesDB operaciones = new OperacionesDB();
    Scanner entrada = new Scanner (System.in);
    
    while (true) {
            System.out.println("1. Añadir Alumno");
            System.out.println("2. Consultar Alumno");
            System.out.println("3. Borrar Alumno");
            System.out.println("4. Modificar Alumno");
            System.out.println("5. Listar Alumnos");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce DNI: ");
                    String dni = entrada.nextLine();
                    System.out.print("Introduce nombre: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Introduce apellidos: ");
                    String apellidos = entrada.nextLine();
                    System.out.print("Introduce edad: ");
                    int edad = entrada.nextInt();
                    Alumno alumno = new Alumno(dni, nombre, apellidos, edad);
                    operaciones.añadirAlumno(alumno);
                    break;
                case 2:
                    System.out.print("Introduce DNI del alumno a consultar: ");
                    dni = entrada.nextLine();
                    operaciones.consultaAlumno(dni);
                    break;
                case 3:
                    System.out.print("Introduce DNI del alumno a borrar: ");
                    dni = entrada.nextLine();
                    operaciones.eliminarAlumno(dni);
                    break;
                case 4:
                    System.out.print("Introduce DNI del alumno a modificar: ");
                    dni = entrada.nextLine();
                    System.out.print("Introduce nuevo nombre: ");
                    nombre = entrada.nextLine();
                    System.out.print("Introduce nuevos apellidos: ");
                    apellidos = entrada.nextLine();
                    System.out.print("Introduce nueva edad: ");
                    edad = entrada.nextInt();
                    alumno = new Alumno(dni, nombre, apellidos, edad);
                    operaciones.modificaAlumno(alumno);
                    break;
                case 5:
                    operaciones.listaAlumnos();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige otra opción.");
                    break;
            }
    }
  }
  
}
