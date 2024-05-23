/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_ejercicio1;

/**
 *
 * @author conde
 */
public class AguaMineral extends Bebida {
 
    //Atributos
    private String manatial;
 
    //Constructores
    public AguaMineral(String manatial, double cantidad, double precio, String marca) {
        super(cantidad, precio, marca);
        this.manatial = manatial;
    }
 
    //Metodos
    public String getManatial() {
        return manatial;
    }
 
    public void setManatial(String manatial) {
        this.manatial = manatial;
    }
 
    @Override
    public String toString() {
        return super.toString() + "manatial=" + manatial;
    }
 
}