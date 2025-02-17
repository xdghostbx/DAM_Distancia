/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author USER
 */

import java.io.IOException;
import java.lang.Process;
import java.lang.Runtime;

/**
 * Segunda parte: implementa una aplicación, llamada 'colaborar', que lance 
 * al menos 10 instancias de la aplicación "lenguaje". Haciendo que todas 
 * ellas, colaboren en generar un gran fichero de palabras. Cada instancia 
 * generará un número creciente de palabras de 10, 20, 30, … 
 * Por supuesto, cada proceso seguirá escribiendo su palabra en una línea 
 * independiente de las otras. Es decir, si lanzamos 10 instancias de 
 * "lenguaje", al final, debemos tener en el fichero 10 + 20 + 30 + … + 100 = 550 líneas.
 */
public class Colaborar {
    
    public static void main(String[] args) throws IOException {
        Process proceso;
        int numeroPalabras = 10;
        String nombreTXT = "D:/Documentos_Ciclo/DAM_Distancia/DAM_Distancia/DAM2/PSP/T1/Tarea/Ejercicio 2/Colaborar/src/palabras.txt";
        String[] comando = {"java","-jar","C:/Users/USER/Desktop/Letras/Letras/myJar.jar",String.valueOf(numeroPalabras),nombreTXT};
        try{
            for(int i = 0; i < 10; i++){
                proceso = Runtime.getRuntime().exec(comando);
                numeroPalabras += 10;
                comando[3] = String.valueOf(numeroPalabras);
            }
            System.out.println("Se ha escrito el documento correctamente");
        }catch(SecurityException ex){
            System.out.println("Ha ocurrido un error");
        }catch(Exception Ex){
            System.out.println("Error");
        }
    }
    
}
