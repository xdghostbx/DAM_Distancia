package baseDatosAModelo.Escritura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import baseDatosAModelo.modelo.Alumno;
import baseDatosAModelo.modelo.Asignatura;

public class EscribirArchivo {
    public static void escribir(ArrayList<Alumno> alumnos, String archivo) {
        if (alumnos != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) { // Modo de escritura
                for (Alumno alumno : alumnos) {
                    writer.write("DNI: " + alumno.getDni());
                    writer.newLine();
                    for (Asignatura asignatura : alumno.getAsignaturas()) {
                        writer.write("Asignatura: " + asignatura.getNombreAsignatura() + ", Nota: " + asignatura.getNota());
                        writer.newLine();
                    }
                    writer.newLine();
                }
                System.out.println("Se ha escrito correctamente en el archivo");
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error al escribir en el archivo");
                e.printStackTrace();
            }
        }
    }
}