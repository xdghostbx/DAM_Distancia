package com.tarea33;

import com.tarea33.R;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Variables globales de la clase
    private EditText operando1;
    private EditText operando2;
    private Button sumar;
    private Button restar;
    private Button multiplicar;
    private Button dividir;
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
        sumar = findViewById(R.id.BT_sumar);
        restar = findViewById(R.id.BT_restar);
        multiplicar = findViewById(R.id.BT_multiplicar);
        dividir = findViewById(R.id.BT_dividir);

        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        try {
            double num1 = Double.parseDouble(operando1.getText().toString());
            double num2 = Double.parseDouble(operando2.getText().toString());
            double total = 0;

            if (id == R.id.BT_sumar) {
                total = num1 + num2;
            } else if (id == R.id.BT_restar) {
                total = num1 - num2;
            } else if (id == R.id.BT_multiplicar) {
                total = num1 * num2;
            } else if (id == R.id.BT_dividir) {
                if (num2 == 0) {
                    Toast.makeText(this, "Error: División por 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                total = num1 / num2;
            } else {
                Toast.makeText(this, "Error: Operación no válida", Toast.LENGTH_SHORT).show();
                return;
            }
            resultado.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, ingresa números válidos", Toast.LENGTH_SHORT).show();
        }

    }


}


