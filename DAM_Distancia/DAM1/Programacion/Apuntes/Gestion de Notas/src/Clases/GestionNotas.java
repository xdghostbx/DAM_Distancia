/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Clases;

import java.util.ArrayList;
import java.util.HashMap;

public class GestionNotas {
    private HashMap<Integer, Estudiante> estudiantes;

    // Constructor
    public GestionNotas() {
        this.estudiantes = new HashMap<>();
    }

    public HashMap<Integer, Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(HashMap<Integer, Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getId(), estudiante);
    }

    public void eliminarEstudiante(int id) {
        estudiantes.remove(id);
    }

    public Estudiante buscarPorNombre(String nombre) {
        for (Estudiante estudiante : estudiantes.values()) {
            if (estudiante.getNombre().equals(nombre)) {
                return estudiante;
            }
        }
        return null;
    }

    public void asignarNota(int id, String materia, int nota) {
        Estudiante estudiante = estudiantes.get(id);
        if (estudiante != null) {
            estudiante.añadirNota(materia, nota);
        }
    }

    public void notasEstudiante(int id) {
        Estudiante estudiante = estudiantes.get(id);
        if (estudiante != null) {
            System.out.println(estudiante.toString());
        } else {
            System.out.println("Estudiante no encontrado");
        }
    }

    public double calcularMediaMateria(String materia) {
        int total = 0, contador = 0;
        for (Estudiante estudiante : estudiantes.values()) {
            if (estudiante.getNotas().containsKey(materia)) {
                ArrayList<Integer> listaNotas = estudiante.getNotas().get(materia);
                for (int nota : listaNotas) {
                    total += nota;
                    contador++;
                }
            }
        }
        return contador > 0 ? (double) total / contador : 0;
    }

    public double calcularPromedioEstudiante(int id) {
        Estudiante estudiante = estudiantes.get(id);
        if (estudiante != null) {
            return estudiante.calcularMedia();
        }
        return 0;
    }
}
