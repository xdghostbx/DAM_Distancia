/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package fechas;

/**
 *
 * @author xdGHOSTbx
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fecha objFecha1 = new Fecha(Fecha.enuMes.septiembre);
            objFecha1.setDia (20);
            objFecha1.setAnho (2023);
      
        Fecha objFecha2 = new Fecha(Fecha.enuMes.junio);
            objFecha2.setDia (21);
            objFecha2.setAnho (2022);
        
        objFecha1.imprimirDatos1();
        objFecha2.imprimirDatos2();
             
    }
    
}
