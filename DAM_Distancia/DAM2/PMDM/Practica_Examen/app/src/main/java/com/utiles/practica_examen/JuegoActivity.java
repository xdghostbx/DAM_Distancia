package com.utiles.practica_examen;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class JuegoActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private TextView tvPuntuacion, tvTiempo, tvMax;
    private int puntuacion = 0, pMax = 0;
    private final int FILAS = 5;
    private final int COLUMNAS = 5;
    private final Random random = new Random();
    private final Handler handler = new Handler();
    private final int TIEMPO_DESAPARECER = 3000; // 3 segundos
    private boolean juegoEnCurso = true;
    private CountDownTimer timer;
    private SharedPreferences ap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        tableLayout = findViewById(R.id.tableLayout);
        tvPuntuacion = findViewById(R.id.tvPuntuacion);
        tvTiempo = findViewById(R.id.tvTiempo);

        ap = getSharedPreferences ("puntuacion", MODE_PRIVATE);
        pMax = ap.getInt("puntuacion", 0);

        tvMax = findViewById(R.id.tvMax);
        tvMax.setText("Puntuación máxima: " + pMax);


        generarTabla();
        generarBotonesAleatorios();
        iniciarTemporizador();
    }

    private void generarTabla() {
        for (int i = 0; i < FILAS; i++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            for (int j = 0; j < COLUMNAS; j++) {
                Button btn = new Button(this);
                btn.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT, 1.0f));

                btn.setText("");
                btn.setEnabled(false);
                row.addView(btn);
            }
            tableLayout.addView(row);
        }
    }

    private void generarBotonesAleatorios() {
        if (!juegoEnCurso) return; // No generar más botones si el juego terminó

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int fila = random.nextInt(FILAS);
                int columna = random.nextInt(COLUMNAS);
                TableRow row = (TableRow) tableLayout.getChildAt(fila);
                Button btn = (Button) row.getChildAt(columna);

                if (random.nextBoolean()) {
                    btn.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                    btn.setTag("verde");
                } else {
                    btn.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    btn.setTag("rojo");
                }

                btn.setEnabled(true);
                btn.setText("");

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!juegoEnCurso) return; // Evita que se pueda jugar después de terminar

                        if ("verde".equals(btn.getTag())) {
                            puntuacion += 10;
                        } else if ("rojo".equals(btn.getTag())) {
                            puntuacion -= 5;
                            finalizarJuego("¡Perdiste! Pulsaste un botón rojo.");
                            return;
                        }

                        tvPuntuacion.setText("Puntuación: " + puntuacion);

                        btn.setEnabled(false);
                        btn.setText("");
                        btn.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));

                    }
                });

                handler.postDelayed(() -> {
                    btn.setEnabled(false);
                    btn.setText("");
                    btn.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                }, TIEMPO_DESAPARECER);

                generarBotonesAleatorios(); // Generar un nuevo botón después de un tiempo
            }
        }, 500); // Cada medio segundo aparece un nuevo botón aleatorio
    }

    private void iniciarTemporizador() {
        timer = new CountDownTimer(60000, 1000) { // 60 segundos (60000 ms), actualización cada 1s
            @Override
            public void onTick(long millisUntilFinished) {
                tvTiempo.setText("Tiempo: " + (millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                finalizarJuego("¡Tiempo agotado! Puntuación final: " + puntuacion);
            }
        }.start();
    }

    private void finalizarJuego(String mensaje) {
        juegoEnCurso = false;
        handler.removeCallbacksAndMessages(null); // Detiene la generación de botones
        timer.cancel(); // Detiene el temporizador
        if (puntuacion > pMax) {
            pMax = puntuacion;
            SharedPreferences.Editor editor = ap.edit();
            editor.putInt("puntuacion", pMax);
            editor.apply();}

        Toast.makeText(JuegoActivity.this, mensaje, Toast.LENGTH_LONG).show();

        // Deshabilita todos los botones de la tabla
        for (int i = 0; i < FILAS; i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < COLUMNAS; j++) {
                Button btn = (Button) row.getChildAt(j);
                btn.setEnabled(false);
            }
        }
    }
}
