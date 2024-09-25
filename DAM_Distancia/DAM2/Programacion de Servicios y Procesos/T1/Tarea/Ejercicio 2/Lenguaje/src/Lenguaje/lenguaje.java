package Lenguaje;

import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/*
 Primera parte: implementa una aplicación que escriba en un fichero indicado por el usuario conjuntos de letras generadas de forma aleatoria (sin sentido real). Escribiendo cada conjunto de letras en una línea distinta. El número de conjuntos de letras a generar por el proceso, también será dado por el usuario en el momento de su ejecución. Esta aplicación se llamará "lenguaje" y como ejemplo, podrá ser invocada así:
 */
public class lenguaje {
    public static void main(String[] args) throws Exception {
        //creamos un array con las letras del abecedario
        char letras [] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        //creamos una instancia de random para generar numeros aleatorios que irán de la mano con las letras
        Random random = new Random();
        Scanner entrada = new Scanner(System.in);

        //el usuario introduce el numero de conjuntos a introducir
        int numeroConjuntos = Integer.parseInt(args[0]);
        String nombreFichero = args[1];
        
        try(BufferedWriter bw = new BufferedWriter(
            new FileWriter(nombreFichero)
        )){
            for(int i = 0; i < numeroConjuntos; i++){
                int numLetras = random.nextInt(10) + 1;
                for(int j = 0; j < numLetras; j++){
                    int letraAleatoria = random.nextInt(26);
                    bw.write(letras[letraAleatoria]);
                }
                bw.newLine();
            }
        }
        entrada.close();
    }
}
