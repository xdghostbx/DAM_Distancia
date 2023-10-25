/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package fechas;

/**
 *
 * @author xdGHOSTbx
 */
public class Fecha {
    public enum enuMes{
        enero,febrero,marzo,abril,mayo,junio,julio,agosto,septiembre,octubre,noviembre,diciembre
    }
    
    private int dia;
    private enuMes mes;
    private int anho;
    
    public Fecha (enuMes mes){
        this.mes = mes;
        this.dia = 0;
        this.anho = 0;
    }
    
    public Fecha (int dia, enuMes mes, int anho){
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }
    
    public int getDia(){
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public enuMes getMes(){
        return mes;
    }
    public void setMes(enuMes mes) {
        this.mes = mes;
    }
    public int getAnho(){
        return anho;
    }
    public void setAnho(int anho) {
        this.anho = anho;
    }
    
    public boolean isSummer(){
        return (mes == enuMes.junio || mes == enuMes.julio || mes == enuMes.agosto);
    }
    
    public String toString(){
        return dia + " de " + mes + " del " + anho;
    }
    
    void imprimirDatos1(){
        System.out.println("Primera fecha, inicializada con el primer constructor: ");
        System.out.println("La fecha es: " + toString());
        if (isSummer() == true ){
            System.out.println("Es verano");
        } else {
            System.out.println("No es verano");
        }
    }
    void imprimirDatos2(){
        System.out.println("Segunda fecha, inicializada con el segundo constructor: ");
        System.out.println("La fecha 2 contiene el año "+getAnho());
        System.out.println("La fecha es: " + toString());
        if (isSummer() == true ){
            System.out.println("Es verano");
        } else {
            System.out.println("No es verano");
        }
    }
}
