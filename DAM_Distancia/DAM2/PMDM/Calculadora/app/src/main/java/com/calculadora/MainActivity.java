package com.calculadora;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Variables globales
    private Button sumar, restar, multiplicar, dividir, porcentaje, borrar,
            clear, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero,
            coma, igual;

    private final Button mas = findViewById(R.id.bt_suma);
    private final Button menos = findViewById(R.id.bt_restar);

    private TextView pantalla;
    private RadioButton verde, rojo, azul;
    private RadioGroup radioGroup;

    private double operando1 = 0; // Guardar el primer operando
    private String operador = ""; // Guardar el operador seleccionado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarVariables();
        aplicarListeners();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int j = azul.getId();
                if (i == verde.getId()){
                    pantalla.setBackgroundColor(getResources().getColor(R.color.green));
                    alerta(MainActivity.this,j);
                }else if (i == rojo.getId()){
                    pantalla.setBackgroundColor(getResources().getColor(R.color.red));
                    alerta(MainActivity.this,j);
                }else if (i == azul.getId()){
                    pantalla.setBackgroundColor(getResources().getColor(R.color.blue));
                    alerta(MainActivity.this,j);
                }

            }

        });

    }

    public void alerta(Context a, int j){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Que haces cambiando de color, eres tonto??");
        builder.setMessage("Tienes pensado contestar o que??");
        builder.setPositiveButton("Si soy", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(a, "Ya sabía yo que no eras el más listo de tu casa", Toast.LENGTH_LONG).show();

            }
        });
        builder.show();
    }
    public void iniciarVariables() {
        // Inicialización de las variables
        pantalla = findViewById(R.id.tv_resultado);
        sumar = findViewById(R.id.bt_suma);
        restar = findViewById(R.id.bt_restar);
        multiplicar = findViewById(R.id.bt_multiplicar);
        dividir = findViewById(R.id.bt_dividir);
        porcentaje = findViewById(R.id.bt_porcentaje);
        borrar = findViewById(R.id.bt_borrar);
        clear = findViewById(R.id.bt_clear);
        uno = findViewById(R.id.bt_1);
        dos = (Button)findViewById(R.id.bt_2);
        tres = (Button)findViewById(R.id.bt_3);
        cuatro =(Button) findViewById(R.id.bt_4);
        cinco = (Button)findViewById(R.id.bt_5);
        seis = (Button)findViewById(R.id.bt_6);
        siete =(Button) findViewById(R.id.bt_7);
        ocho =(Button) findViewById(R.id.bt_8);
        nueve =(Button) findViewById(R.id.bt_9);
        cero = (Button)findViewById(R.id.bt_0);
        coma = (Button)findViewById(R.id.bt_decimal);
        igual = (Button)findViewById(R.id.bt_igual);

        radioGroup = findViewById(R.id.rg_colores);
        verde = findViewById(R.id.rb_verde);
        rojo = findViewById(R.id.rb_rojo);
        azul = findViewById(R.id.rb_azul);
    }

    public void aplicarListeners() {
        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);
        borrar.setOnClickListener(this);
        clear.setOnClickListener(this);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        cero.setOnClickListener(this);
        coma.setOnClickListener(this);
        igual.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch(id){
            case R.id.bt_suma:
                break;
        }

        if (id == R.id.bt_0 || id == R.id.bt_1 || id == R.id.bt_2 ||
                id == R.id.bt_3 || id == R.id.bt_4 || id == R.id.bt_5 ||
                id == R.id.bt_6 || id == R.id.bt_7 || id == R.id.bt_8 ||
                id == R.id.bt_9 || id == R.id.bt_decimal) {
            if(pantalla.getText().toString().equals("0")){
                pantalla.setText("");
            }
            pantalla.append(((Button) view).getText());
        } else if (id == R.id.bt_suma || id == R.id.bt_restar ||
                id == R.id.bt_multiplicar || id == R.id.bt_dividir) {

            if (!pantalla.getText().toString().isEmpty()) {
                operando1 = Double.parseDouble(pantalla.getText().toString());

                // Asignar operador
                if (id == R.id.bt_suma) operador = "+";
                else if (id == R.id.bt_restar) operador = "-";
                else if (id == R.id.bt_multiplicar) operador = "*";
                else if (id == R.id.bt_dividir) operador = "/";

                pantalla.setText(""); // Limpiar pantalla para el siguiente número
            }
        } else if (id == R.id.bt_borrar) {
            String textoActual = pantalla.getText().toString();
            if (!textoActual.isEmpty()) {
                textoActual = textoActual.substring(0, textoActual.length() - 1);
                pantalla.setText(textoActual);
            }
        } else if (id == R.id.bt_clear) {
            pantalla.setText("0");
            operando1 = 0;
            operador = "";
        } else if (id == R.id.bt_igual) {
            if (!pantalla.getText().toString().isEmpty()) {
                double operando2 = Double.parseDouble(pantalla.getText().toString());
                double resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = operando1 + operando2;
                        break;
                    case "-":
                        resultado = operando1 - operando2;
                        break;
                    case "*":
                        resultado = operando1 * operando2;
                        break;
                    case "/":
                        if (operando2 != 0) {
                            resultado = operando1 / operando2;
                        } else {
                            Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_LONG).show();
                            return;
                        }
                        break;
                }

                pantalla.setText(String.valueOf(resultado));
                operando1 = resultado; // Permitir encadenar operaciones
                operador = "";
            }
        }
    }


}
