/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author xdGHOSTbx
 */
public class Protectora {
  private ArrayList<Animales> animales;

  public Protectora() {
    animales = new ArrayList<>();
  }
  
  public void agregarAnimal(Animales animal) {
        animales.add(animal);
    }
  
  public void mostrarAnimales() {
        for (Animales Animal : animales) {
            System.out.println(Animal.toString());
            if (Animal instanceof Gato) {
                Gato gato = (Gato) Animal;
                System.out.println("Color: " + gato.getColor());
            }
        }
  }
}
