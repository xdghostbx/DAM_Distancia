package com.juego.simondice;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btAmarillo, btAzul, btRojo, btVerde, btJugar;

    ArrayList<Integer> patrones = new ArrayList<>();
    ArrayList<Integer> jugador = new ArrayList<>();
    Map<Button, Integer> originalColors = new HashMap<>();

    private MediaPlayer mpAmarillo, mpAzul, mpRojo, mpVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar botones
        btAmarillo = findViewById(R.id.btAmarillo);
        btAzul = findViewById(R.id.btAzul);
        btRojo = findViewById(R.id.btRojo);
        btVerde = findViewById(R.id.btVerde);
        btJugar = findViewById(R.id.btJugar);

        try {
            // Inicializar MediaPlayer para cada botón
            mpAmarillo = MediaPlayer.create(this, R.raw.key01);
            mpAzul = MediaPlayer.create(this, R.raw.key04);
            mpRojo = MediaPlayer.create(this, R.raw.key07);
            mpVerde = MediaPlayer.create(this, R.raw.key10);

            // Guardar los colores originales de los botones
            originalColors.put(btAmarillo, ((ColorDrawable) btAmarillo.getBackground()).getColor());
            originalColors.put(btAzul, ((ColorDrawable) btAzul.getBackground()).getColor());
            originalColors.put(btRojo, ((ColorDrawable) btRojo.getBackground()).getColor());
            originalColors.put(btVerde, ((ColorDrawable) btVerde.getBackground()).getColor());

            // Configurar listeners
            btAmarillo.setOnClickListener(this::onColorButtonClick);
            btAzul.setOnClickListener(this::onColorButtonClick);
            btRojo.setOnClickListener(this::onColorButtonClick);
            btVerde.setOnClickListener(this::onColorButtonClick);
            btJugar.setOnClickListener(this::onPlayButtonClick);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al inicializar la aplicación", Toast.LENGTH_SHORT).show();
        }
    }

    private void onColorButtonClick(View view) {
        Button button = (Button) view;
        int numeroBoton = getNumeros(button.getId());
        jugador.add(numeroBoton);

        sonido(numeroBoton);

        // Cambiar temporalmente el color del botón al hacer clic
        int highlightColor = getHighlightColor(numeroBoton);
        int originalColor = originalColors.get(button);
        button.setBackgroundColor(highlightColor);

        // Restaurar el color original después de 500ms
        new Handler().postDelayed(() -> button.setBackgroundColor(originalColor), 500);

        verificarSecuencia();
    }

    private void onPlayButtonClick(View view) {
        patrones.clear(); // Vaciar el ArrayList para evitar posibles conflictos
        jugador.clear();
        Toast.makeText(this, "¡Juego iniciado!", Toast.LENGTH_SHORT).show();
        generarNumeros();
        playSecuencia();
    }

    private void generarNumeros(){
        Random a = new Random();
        patrones.add(a.nextInt(4));
    }

    private int getNumeros(int buttonId) {
        if (buttonId == R.id.btAmarillo) {
            return 0;
        } else if (buttonId == R.id.btAzul) {
            return 1;
        } else if (buttonId == R.id.btRojo) {
            return 2;
        } else if (buttonId == R.id.btVerde) {
            return 3;
        } else {
            return -1;
        }
    }

    private void verificarSecuencia() {
        for (int i = 0; i < jugador.size(); i++) {
            if (!jugador.get(i).equals(patrones.get(i))) {
                Toast.makeText(this, "¡Secuencia incorrecta!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        if (jugador.size() == patrones.size()) {
            Toast.makeText(this, "¡Secuencia correcta!", Toast.LENGTH_SHORT).show();
            jugador.clear();
            new Handler().postDelayed(() -> {
                generarNumeros();
                playSecuencia();
            }, 1000); // Retraso de 1 segundo antes de la siguiente secuencia
        }
    }

    private void playSecuencia() {
        Handler handler = new Handler();
        for (int i = 0; i < patrones.size(); i++) {
            int delay = i * 1000; // 1 segundo de retraso entre cada botón
            int colorIndex = patrones.get(i);
            handler.postDelayed(() -> {
                Button button = getButtonByIndex(colorIndex);
                if (button != null) {
                    int highlightColor = getHighlightColor(colorIndex);
                    button.setBackgroundColor(highlightColor);
                    sonido(colorIndex); // Reproducir sonido correspondiente
                    handler.postDelayed(() -> button.setBackgroundColor(originalColors.get(button)), 500); // Mantener el color cambiado por 500ms
                }
            }, delay);
        }
    }

    private void sonido(int index) {
        Handler handler = new Handler();
        int delay = 1000;
        try {
            switch (index) {
                case 0:
                    if (mpAmarillo != null) mpAmarillo.start();
                    handler.postDelayed(() ->mpAmarillo.pause(), 500);
                    mpAmarillo.seekTo(0);
                    break;
                case 1:
                    if (mpAzul != null) mpAzul.start();
                    handler.postDelayed(() ->mpAzul.pause(), 500);
                    mpAzul.seekTo(0);
                    break;
                case 2:
                    if (mpRojo != null) mpRojo.start();
                    handler.postDelayed(() ->mpRojo.pause(), 500);
                    mpRojo.seekTo(0);
                    break;
                case 3:
                    if (mpVerde != null) mpVerde.start();
                    handler.postDelayed(() ->mpVerde.pause(), 500);
                    mpVerde.seekTo(0);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al reproducir sonido", Toast.LENGTH_SHORT).show();
        }
    }

    private int getHighlightColor(int index) {
        switch (index) {
            case 0:
                return Color.YELLOW;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.RED;
            case 3:
                return Color.GREEN;
            default:
                return Color.WHITE;
        }
    }

    private Button getButtonByIndex(int index) {
        switch (index) {
            case 0:
                return btAmarillo;
            case 1:
                return btAzul;
            case 2:
                return btRojo;
            case 3:
                return btVerde;
            default:
                return null;
        }
    }
}