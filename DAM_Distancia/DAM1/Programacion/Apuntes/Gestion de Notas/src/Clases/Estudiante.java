/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Clases;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author xdGHOSTbx
 */
public class Estudiante {
  private String nombre;
  private int id;
  private HashMap<String, ArrayList<Integer>> notas;

  public Estudiante(String nombre, int id) {
    this.nombre = nombre;
    this.id = id;
    this.notas = new HashMap<>();
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public HashMap<String, ArrayList<Integer>> getNotas() {
    return notas;
  }

  public void setNotas(HashMap<String, ArrayList<Integer>> notas) {
    this.notas = notas;
  }
  
  
  
  public void añadirNota(String materia, int nota){
    if(!notas.containsKey(materia)){
      notas.put(materia, new ArrayList<>());
    }
    notas.get(materia).add(nota);
  }
  
  public double calcularMedia(){
    int total = 0, contador = 0;
    for(ArrayList<Integer> listaNotas : notas.values()){
      for (int nota: listaNotas){
        total += nota;
        contador++;
      }
    }
    return contador > 0 ? (double) total / contador : 0;
  }
  
   public double calcularPromedioMateria(String materia) {
        if (notas.containsKey(materia)) {
            ArrayList<Integer> listaNotas = notas.get(materia);
            int totalNotas = 0;
            for (int nota : listaNotas) {
                totalNotas += nota;
            }
            return listaNotas.size() > 0 ? (double) totalNotas / listaNotas.size() : 0;
        }
        return 0;
    }
   
   @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", notas=" + notas +
                '}';
    }
}
