package com.holamundo;

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

public class MainActivity extends AppCompatActivity {

    //Variables globales de la clase
    private EditText operando1;
    private EditText operando2;
    private Button sumar;
    private TextView resultado;

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

        //Inicializamos las variables globales en cuanto inicia la app
        operando1 = findViewById(R.id.TX_1);
        operando2 = findViewById(R.id.TN_2);
        resultado = findViewById(R.id.resultado);
    }

    //metodo para realizar la suma "no programable"
    public void realizarSuma (View view) {
        try{
            int num1 = Integer.parseInt(operando1.getText().toString());
            int num2 = Integer.parseInt(operando2.getText().toString());
            int suma = num1 + num2;
            resultado.setText(String.valueOf(suma));
        }catch(NumberFormatException e){
            Toast.makeText(this, "Introduce un numero", Toast.LENGTH_SHORT).show();
        }

    }
}