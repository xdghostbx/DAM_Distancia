/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_ejercicio1;

/**
 *
 * @author conde
 */
public class BebidaAzucarada extends Bebida {
     
    private double porcentajeAzucar;
    private boolean promocion;
 
    public BebidaAzucarada(double porcentajeAzucar, boolean promocion, double cantidad, double precio, String marca) {
        super(cantidad, precio, marca);
        this.porcentajeAzucar = porcentajeAzucar;
        this.promocion = promocion;
    }
 
    public double getPorcentajeAzucar() {
        return porcentajeAzucar;
    }
 
    public void setPorcentajeAzucar(double porcentajeAzucar) {
        this.porcentajeAzucar = porcentajeAzucar;
    }
 
    public boolean isPromocion() {
        return promocion;
    }
 
    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }
     
    @Override
    public double getPrecio(){
        if(isPromocion()){
            return super.getPrecio()*0.9;
        }else{
            return super.getPrecio();
        }
    }
 
    @Override
    public String toString() {
        return super.toString() + "porcentajeAzucar=" + porcentajeAzucar + ", promocion=" + promocion ;
    }
     
}