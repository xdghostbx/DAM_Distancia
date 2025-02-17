package juego.lluvia;

import android.content.Context;

import java.util.Random;

public class Cuadricula {
    public static int[][] cuadricula(Context contexto) {
        Random aleatorio = new Random();
        // Generamos un array
        int[][] cuadricula = new int[5][5];
        //generamos una posicion aleatoria para que sea de color verde
        int i = aleatorio.nextInt(5);
        int j = aleatorio.nextInt(5);
        cuadricula[i][j] = 1;
        return cuadricula;
    }
}
