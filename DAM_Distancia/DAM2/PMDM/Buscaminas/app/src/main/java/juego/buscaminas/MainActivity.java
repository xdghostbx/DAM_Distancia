package juego.buscaminas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int[][] cuadricula;
    private Button[][] botones;

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
                        } else {
                            v.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
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
                cuadricula = Codigo.cuadricula(MainActivity.this);
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

    private void reiniciarColores() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                botones[i][j].setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            }
        }
        // Generar una nueva cuadrícula
        cuadricula = Codigo.cuadricula(MainActivity.this);
    }
}