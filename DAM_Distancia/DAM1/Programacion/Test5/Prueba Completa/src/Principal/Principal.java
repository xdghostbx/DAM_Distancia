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
public class Principal {
    
    private static Alumno alumno;
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        float nota = 0;
        do{
            opcion = entrada.nextInt();
            Menu(entrada, opcion, nota);
            
        }while (opcion != 4);
        
        
    }
    
    public static void Menu(Scanner entrada, int opcion, float nota){
        System.out.println("Selecciona una de las opciones siguientes: \n"
                + "1.-Introducir nuevo Alumno\n"
                + "2.-Calcular nota media\n"
                + "3.-Ver datos del Alumno\n"
                + "4.-Salir");
        
        switch (opcion){
            case 1:
                nuevoAlumno(entrada);
                break;
            case 2:
                
                break;
            case 3:
                mostrarDatos();
                break;
            case 4:
                notaMedia(nota);
                if (true) System.out.println("El alumno está aprobado con una nota de "+nota);
                break;
            default:
                
                break;
        }
    }
    
    public static void nuevoAlumno(Scanner entrada){
        System.out.println("Introduce el nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Introduce los apellidos:");
        String apellidos = entrada.nextLine();
        System.out.println("Introduce la ciudad donde vive: ");
        String ciudad = entrada.nextLine();
        System.out.println("Introduce su pais:");
        String pais = entrada.nextLine();
        System.out.println("Introduce su DNI:");
        String DNI = entrada.nextLine();
        System.out.println("Inroduce su e-mail:");
        String mail = entrada.nextLine();
        float nota1 = 0, nota2 =0, nota3=0, nota4=0, nota5=0;
        for(int i=1; i<=5;i++){
            System.out.println("Introduce la nota numero "+i+":");
            switch (i) {
                case 1:
                    nota1 = entrada.nextFloat();
                    entrada.nextLine();
                    break; 
                case 2:
                    nota2 = entrada.nextFloat();
                    entrada.nextLine();
                    break;
                case 3:
                    nota3 = entrada.nextFloat();
                    entrada.nextLine();
                    break;
                case 4:
                    nota4 = entrada.nextFloat();
                    entrada.nextLine();
                    break;
                case 5:
                    nota5 = entrada.nextFloat();
                    entrada.nextLine();
                    break;
                default:
                    break;
            }
        }
        alumno = new Alumno (nombre, apellidos, ciudad, pais, DNI, mail, nota1, nota2, nota3, nota4, nota5);
        System.out.println("Alumno cargado con exito");
    }
    
    public static void mostrarDatos() {
        System.out.println("Datos del alumno:");
            System.out.print("Nombre: " + alumno.getNombre()+", ");
            System.out.print("Apellidos: " + alumno.getApellidos()+", ");
            System.out.print("DNI: " + alumno.getDNI()+", ");
            System.out.print("Ciudad: "+ alumno.getCiudad()+", ");
            System.out.println("Pais: "+ alumno.getPais()+" ");
            System.out.println(); 
    }
    
    public static boolean notaMedia(float nota){
        nota = (alumno.getNota1() + alumno.getNota2() + alumno.getNota3() + alumno.getNota4() + alumno.getNota5())/5;
        return nota >= 5;
    }
}
