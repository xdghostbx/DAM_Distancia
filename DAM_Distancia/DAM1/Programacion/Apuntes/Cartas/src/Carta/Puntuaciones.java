/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Carta;
import java.util.Random;
/**
 *
 * @author xdGHOSTbx
 */
public class Puntuaciones {
  private static Random rand = new Random();
  private static final String[] palos = {"oros","bastos","espadas","copas"};
  private static final String[] numeros = {"as","dos","tres","cuatro","cinco","seis","siete","sota",
                             "caballo","rey",};
  
  public static Carta generarCarta(){
    String palo = palos[rand.nextInt(palos.length)];
    String numero = numeros[rand.nextInt(numeros.length)];
    Carta carta = new Carta(palo, numero);
    return carta;
  }
}
