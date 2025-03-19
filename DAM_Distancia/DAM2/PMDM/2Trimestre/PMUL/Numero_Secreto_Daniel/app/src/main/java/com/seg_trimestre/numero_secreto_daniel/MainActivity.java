package com.seg_trimestre.numero_secreto_daniel;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView puntuacion, titulo, subtitulo;
    private EditText numero;
    private Button boton;
    private SharedPreferences sp;
    private int numeroAleatorio, puntosTotales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //iniciamos las distintas variables
        puntuacion = findViewById(R.id.tv_puntos);
        titulo = findViewById(R.id.tv_titulo);
        subtitulo = findViewById(R.id.tv_puntos);
        boton = findViewById(R.id.bt_comprobar);
        numero = findViewById(R.id.ed_numero);

        //Inicializar SharedPreferences
        sp = getSharedPreferences("NumeroSecreto", MODE_PRIVATE);
        puntosTotales = sp.getInt("puntuacion", 0);
        puntuacion.setText(String.valueOf(puntosTotales));

        //genera numero aleatorio al iniciar la app
        generarNumero();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarNumero();
            }
        });

    }

    public void generarNumero() {
        Random aleatorio = new Random();
        numeroAleatorio = aleatorio.nextInt(20)+1;
    }

    public void comprobarNumero() {
        String entrada = numero.getText().toString();
        if (entrada.isEmpty()){
            Toast.makeText(this, "Introduce un numero", Toast.LENGTH_SHORT).show();
            return;
        }
        int numeroIngresado = Integer.parseInt(entrada);
        if (numeroIngresado == numeroAleatorio) {
            Toast.makeText(this, "Has acertado", Toast.LENGTH_SHORT).show();
            generarNumero();
            aumentarPuntuacion();
            numero.setText("");
        } else if (numeroIngresado > numeroAleatorio ) {
            Toast.makeText(this, "El numero secreto es menor", Toast.LENGTH_SHORT).show();
            numero.setText("");
        } else if (numeroIngresado < numeroAleatorio) {
            Toast.makeText(this, "El numero secreto es mayor", Toast.LENGTH_SHORT).show();
            numero.setText("");
        }
    }

    public void aumentarPuntuacion () {
        puntosTotales++;
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("puntuacion", puntosTotales);
        editor.apply();

        puntuacion.setText(String.valueOf(puntosTotales));
    }
}