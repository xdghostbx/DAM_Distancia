/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Eurocoin;
import java.util.*;
/**
 *
 * @author xdGHOSTbx
 */
public class Eurocoin {
  private static Random rand = new Random();
  private static final String[] valores = {"1 centimo","2 centimos","5 centimos",
                                           "10 centimos","25 centimos","50 centimos",
                                           "1 euro", "2 euros"};
  
  private static final String[] posicion ={"cara","cruz"};
  
  public static Moneda generarMoneda(){
    String valor = valores[rand.nextInt(valores.length)];
    String posiciones = posicion[rand.nextInt(posicion.length)];
    Moneda moneda = new Moneda(valor,posiciones);
    return moneda;
  }
}
