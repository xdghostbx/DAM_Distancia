package juego.buscaminas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int[][] cuadricula;
    private Button[][] botones;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar los botones en el GridLayout
        botones = new Button[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "bt" + (i * 5 + j + 1);
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                botones[i][j] = findViewById(resID);
                final int finalI = i;
                final int finalJ = j;
                botones[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            if (cuadricula[finalI][finalJ] == 1) {
                                v.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                                mostrarAlertaPerdido();
                            } else{
                                contador++;
                                v.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                                comprobarArea(finalI, finalJ);
                                if (contador == 22){
                                    mostrarAlertaGanado();
                                }
                            }
                        }
                });
            }
        }
        reiniciarColores();
        Button btJugar = findViewById(R.id.btJugar);
        btJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reiniciar los colores de los botones
                reiniciarColores();
                // Generar una nueva cuadrícula
                cuadricula = Codigo.cuadricula(MainActivity.this);
            }
        });

        Button btTutorial = findViewById(R.id.btTutorial);
        btTutorial.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v){
              tutorial();
          }
        });
    }

    private void mostrarAlertaPerdido() {
        new AlertDialog.Builder(this)
                .setTitle("Boum!!!")
                .setMessage("Has tocado una mina.")
                .setPositiveButton(android.R.string.ok, (dialog, which) -> reiniciarColores())
                .setCancelable(false)
                .show();
    }

    private void mostrarAlertaGanado() {
        new AlertDialog.Builder(this)
                .setTitle("¡Enhorabuena!")
                .setMessage("Has ganado.")
                .setPositiveButton(android.R.string.ok, (dialog, which) -> reiniciarColores())
                .setCancelable(false)
                .show();
    }

    private void tutorial(){
        new AlertDialog.Builder(this)
                .setTitle("Buscaminas")
                .setMessage("El objetivo del juego es no tocar las minas."+"\nColores:"+"\n    -Verde: " +
                        "No hay mina en radio 1 desde \n    la casilla."+"\n    -Naranja: Hay mina en radio 1 " +
                        "desde \n    la casilla."+"\n    -Naranja Oscuro: Hay 2 minas en radio \n    1 desde la casilla"+
                        "\n    -Rojo: Has tocado una mina.")
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {})
                .setCancelable(false)
                .show();
    }

    private void reiniciarColores() {
        contador = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                botones[i][j].setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            }
        }
        // Generar una nueva cuadrícula
        cuadricula = Codigo.cuadricula(MainActivity.this);
    }

    private void comprobarArea(int fila, int columna){
        int filas = 5;
        int columnas = 5;
        int conteo = 0;

        int filaInicio = fila - 1;
        int filaFin = fila + 1;
        int columnaInicio = columna - 1;
        int columnaFin = columna + 1;

        if (fila == 0) {
            filaInicio = 0;
        }
        if (fila == filas - 1) {
            filaFin = filas - 1;
        }
        if (columna == 0) {
            columnaInicio = 0;
        }
        if (columna == columnas - 1) {
            columnaFin = columnas - 1;
        }

        for (int i = filaInicio; i <= filaFin; i++) {
            for (int j = columnaInicio; j <= columnaFin; j++) {
                if (cuadricula[i][j] == 1) {
                    conteo++;
                    if (conteo >=2){
                        botones[fila][columna].setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                        return;
                    }
                }
            }
        }
        if (conteo == 1){
            botones[fila][columna].setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        }
    }
}