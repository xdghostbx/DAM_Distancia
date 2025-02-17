package juego.buscaminas;

import android.content.Context;

import java.util.Random;

public class Codigo {
    public static int[][] cuadricula(Context contexto) {
        Random aleatorio = new Random();
        // Generamos un array
        int[][] cuadricula = new int[5][5];

        //Se inicia toda la cuadricula en 0
        for(int a = 0; a < 5; a++){
            for(int b = 0; b < 5; b++){
                cuadricula[a][b] = 0;
            }
        }
        // Con un bucle for ponemos 5 "minas"
        for (int a = 0; a < 3; a++) {
            int i = aleatorio.nextInt(5);
            int j = aleatorio.nextInt(5);
            // Comprueba si ya hay una mina en la posición
            while (cuadricula[i][j] == 1) {
                i = aleatorio.nextInt(5);
                j = aleatorio.nextInt(5);
            }
            cuadricula[i][j] = 1;
        }
        return cuadricula;
    }
}