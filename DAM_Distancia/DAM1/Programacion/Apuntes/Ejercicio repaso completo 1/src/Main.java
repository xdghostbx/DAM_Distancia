/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * Un cine de un pueblo pequeño nos propone hacer una aplicación para controlar 
 * las personas de una cola de un cine en los grandes estrenos de películas.

Un conjunto de personas esperaran la cola para sacar una entrada, tendremos que 
* calcular la entrada según la edad de la persona (mínimo 5 años).

La edad de las personas se generan aleatoriamente entre 5 y 60 años. 
* Os recomiendo realizar un método en el main para generar Personas en la cola.

Al final, deberemos mostrar la cantidad total recaudada. El número de personas 
* de la cola se elige al azar entre 0 y 50.

Te recomiendo usar un mensaje de traza para saber si la recaudacion es correcta 
* según la edad (opcional).

Recuerda que al final la lista debe quedar vacía, una vez que una persona paga su 
* entrada ya no está en la cola.

Aquí os dejo la lista de precios:
Edad	Precio
Entre 5 y 10 años 	1 €
Entre 11 y 17 años 	2.5 €
Mayor de 18 años 	3.5 €
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Random aleatorio = new Random();
    ArrayList<Integer> conjunto = new ArrayList<>();
    ArrayList<Double> precio = new ArrayList<>();
    //generamos un numero aleatorio de personas
    int numPersonas = aleatorio.nextInt(50);
     double total = 0;
     int cinco = 0, once = 0, diez = 0;
    int edades;
    //generamos un rango aleatorio de edades y las cargamos en la lista
    for (int i = 0; i<numPersonas;i++){
      edades = aleatorio.nextInt(60-5)+5;
      conjunto.add(edades);
    }
    //se vuelve a recorrer el array, esta vez comparando las edades
    for (int i = numPersonas-1; i>=0;i--){
      if(conjunto.get(i) >= 5 && conjunto.get(i)<=10){
        precio.add(1.00);
        cinco++;
      }else if(conjunto.get(i) >= 11 && conjunto.get(i)<=17){
        precio.add(2.50);
        once++;
      }else
         precio.add(3.50); diez++;
      
      conjunto.remove(i);
    }
    
    for(int i = 0; i<numPersonas;i++){
      total += precio.get(i);
    }
    
    System.out.println("El precio total es "+ total);
    System.out.println("Las personas en la lista son: " + conjunto.size());
    System.out.println("El numero de personas original era "+numPersonas);
    System.out.println(cinco+" personas pagaron 1€");
    System.out.println(once+ " personas pagaron 2.5€");
    System.out.println(diez+" personas pagaron 3.5€");
  }
  
}
