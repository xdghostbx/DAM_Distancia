/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_ejercicio2;

/**
 *
 * @author conde
 */
public class Carta implements Comparable<Carta> {
  private static final String[] valores = {"as", "2", "3", "4", "5", "6", "7", 
                                           "sota", "caballo", "rey"};
  
  private static final String[] palos = {"oros", "copas", "espadas", "bastos"};
  
  private String valor;
  private String palo;
  
  public Carta() {
    this.valor = valores[(int)(Math.random() * 10)];
    this.palo = palos[(int)(Math.random() * 4)];
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public String getPalo() {
    return palo;
  }

  public void setPalo(String palo) {
    this.palo = palo;
  }

  @Override
  public String toString() {
    return valor + " de " + palo;
  }

  @Override
  public boolean equals(Object obj) {
    if (this.getClass() == obj.getClass()) {
      Carta carta = (Carta) obj;
      if ((this.valor).equals(carta.getValor()) && (this.palo).equals(carta.getPalo())) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public int compareTo(Carta c) {
    if (this.palo.equals(c.getPalo())) {
      return this.valor.compareTo(c.getValor());
    }
    return this.palo.compareTo(c.getPalo());
  }
}
