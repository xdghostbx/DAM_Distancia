/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Principal;

import java.util.Scanner;

/**
 *
 * @author xdGHOSTbx
 */
public class Main {

    /**
     * queremos cargalos los datos de alumno, por lo tanto menu
     *      nuevo alumno
     *      buscar alumnos por dni
     *      mostrar alumnos
     *      
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Instituto instituto = new Instituto();
        int opcion = 0;
        do{
            System.out.println("MENU Instituto");
            System.out.println("Introduce una de las siguientes opciones");
            System.out.println("1.- Agregar nuevo alumno");
            System.out.println("2.- Ver alumnos listados");
            System.out.println("3.- Buscar alumno");
            System.out.println("4.- Salir");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch(opcion){
                case 1:
                    int resultado = newAlumno(entrada, instituto);
                    if (resultado == 0){
                        System.out.println("Alumno agregado correctamente...");
                    }else if (resultado == 1){
                        System.out.println("Se ha alcanzado el numero maximo de alumnos...");
                    }else if (resultado == 2){
                        System.out.println("El DNI introducido ya existe en el sistema...");
                    }
                    break;
                case 2:
                    instituto.mostrarAlumnos();
                    break;
                case 3:
                    buscaDNI(entrada, instituto);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Introduce una opcion correcta...");
                    break;
            }
        }while(opcion!=4);
    }
    
    public static int newAlumno(Scanner entrada, Instituto instituto){
        String nombre, apellidos, direccion, DNI;
        double nota;
        
        System.out.println("Introduce el nombre del Alumno:");
        nombre = entrada.nextLine();
        System.out.println("Introduce los apellidos del Alumno:");
        apellidos = entrada.nextLine();
        System.out.println("Introduce su direccion:");
        direccion = entrada.nextLine();
        System.out.println("Introduce su DNI:");
        DNI = entrada.nextLine();
        System.out.println("Introduce su nota media");
        nota = entrada.nextDouble();
        
        Alumno nuevoAlumno;
        nuevoAlumno = new Alumno (nombre, apellidos, direccion, DNI, nota);
        return instituto.agregarAlumno (nuevoAlumno);
    }
    
    public static void buscaDNI(Scanner entrada, Instituto instituto){
        String buscaDNI;
        System.out.println("Introduce el DNI:");
        buscaDNI = entrada.nextLine();
        Alumno coincide = instituto.buscarAlumno(buscaDNI);
        if (coincide != null){
            System.out.println("Alumno encontrado: ");
            System.out.print("Nombre: " + coincide.getNombre()+", ");
            System.out.print("Apellidos: " + coincide.getApellidos()+", ");
            System.out.print("Direccion: " + coincide.getDireccion()+", ");
            System.out.print("Nota media: " + coincide.getNota()+", ");
            System.out.println();
        }else
            System.out.println("No existen alumnos con ese DNI");
    }
}
