package juego.caza;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int[][] cuadricula;
    private Button[][] botones;
    private TextView contadorPuntos;
    private int contador;
    private int record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializar el contador
        contador = 0;
        record = 0;
        contadorPuntos = findViewById(R.id.contadorPuntos);
        actualizarContador();

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
                            v.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                            contador++;
                            generarNuevaPosicion();
                        } else {
                            v.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                            actualizarContador();
                            mostrarAlertaPerdido();
                            contador=0;
                        }
                    }
                });
            }
        }

        Button btJugar = findViewById(R.id.btJugar);
        btJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reiniciar los colores de los botones
                reiniciarColores();
                // Generar una nueva cuadrícula
                reiniciarJuego();
            }
        });
        // Generar una nueva cuadrícula
        cuadricula = Codigo.cuadricula(MainActivity.this);
        mostrarPosicionCorrecta();
    }

    private void mostrarAlertaPerdido() {
        new AlertDialog.Builder(this)
                .setTitle("Has perdido")
                .setMessage("Tienes "+contador+" puntos")
                .setPositiveButton(android.R.string.ok, (dialog, which) -> reiniciarColores())
                .setCancelable(false)
                .show();
    }

    private void reiniciarJuego() {
        contador = 0;
        actualizarContador();
        reiniciarColores();
        cuadricula = Codigo.cuadricula(MainActivity.this);
        mostrarPosicionCorrecta();
    }

    private void reiniciarColores() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                botones[i][j].setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            }
        }
    }

    private void actualizarContador(){
        if(contador > record){
            record = contador;
        }
        contadorPuntos.setText("Puntacion más alta: " + record);
    }

    private void mostrarPosicionCorrecta(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cuadricula[i][j] == 1) {
                    botones[i][j].setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
                }
            }
        }
    }

    private void generarNuevaPosicion(){
        cuadricula = Codigo.cuadricula(MainActivity.this);
        mostrarPosicionCorrecta();
    }
}