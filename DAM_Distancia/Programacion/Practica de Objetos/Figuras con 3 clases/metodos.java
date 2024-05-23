/*
 metodos para la validacion de datos por ejemplo, en este caso me limito a validar si es un cuadrado y cuanto vale el area
 */
package pruebas;

/**
 *
 * @author xdGHOSTbx
 */
public class metodos {
    
    public static boolean isCuadrado(float base, float altura){
        return altura == base;
    }
    
    public static float getArea(float base, float altura){
        return (base * altura);
    }
   
}