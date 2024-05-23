/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Principal;

/**
En esta clase definimos el instituto con el array apra almacenar los alumnos
Tambien tenemos los metodos para agregar nuevos alumnos y mostrar los alumnos existentes
 */
public class Instituto {
    private Alumno[] alumno;
    private int indice;

    public Instituto() { 
        this.alumno = new Alumno[10];
        this.indice = 0;
    }
    
    //agregamos un metodo para agregar nuevos alumnos
    public int agregarAlumno(Alumno nuevoAlumno){
        if (indice == 10){
            return -1; //alcanzado el numero maximo de alumnos
        }
        
        for (int i = 0; i < indice; i++) {
            if (alumno[i].getDNI().equalsIgnoreCase(nuevoAlumno.getDNI())) {
                return -2; // DNI ya existe, devuelve -2
            }
        }
        
        alumno[indice] = nuevoAlumno;
        indice++;
        return 0; //alumno ingresado con exito
    }
    
    public void mostrarAlumnos(){
        System.out.println("Los alumnos de la clase son:");
        for (int i = 0; i<indice;i++){
            System.out.println("Alumno " + (i + 1) + ":");
            System.out.print("Nombre: " + alumno[i].getNombre()+", ");
            System.out.print("Apellidos: " + alumno[i].getApellidos()+", ");
            System.out.print("Direccion: " + alumno[i].getDireccion()+", ");
            System.out.print("DNI: "+ alumno[i].getDNI()+", ");
            System.out.println("Nota: "+ alumno[i].getNota()+" ");
            System.out.println();
        }
    }
    
    public Alumno buscarAlumno(String buscaDNI){
        for (int i = 0; i < indice; i++) {
            if (alumno[i].getDNI().equalsIgnoreCase(buscaDNI)) {
                return alumno[i]; // DNI ya existe, devuelve -2
            }
        }
        return null;
    }
}
