package com.tarea34;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Variables globales de la clase
    private EditText operando1;
    private EditText operando2;
    private Button borrar;
    private TextView resultado;
    private RadioButton sumar,restar,multiplicar,dividir;

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
        sumar = findViewById(R.id.rb_sumar);
        restar = findViewById(R.id.rb_restar);
        multiplicar = findViewById(R.id.rb_mult);
        dividir = findViewById(R.id.rb_div);
        borrar = findViewById(R.id.bt_clear);

        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);
        borrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        try {
            double num1 = Double.parseDouble(operando1.getText().toString());
            double num2 = Double.parseDouble(operando2.getText().toString());
            double total = 0;

            if (id == R.id.rb_sumar) {
                total = num1 + num2;
                resultado.setText(String.valueOf(total));
            } else if (id == R.id.rb_restar) {
                total = num1 - num2;
                resultado.setText(String.valueOf(total));
            } else if (id == R.id.rb_mult) {
                total = num1 * num2;
                resultado.setText(String.valueOf(total));
            } else if (id == R.id.rb_div) {
                if (num2 == 0) {
                    Toast.makeText(this, "Error: División por 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                total = num1 / num2;
                resultado.setText(String.valueOf(total));
            } else if (id == R.id.bt_clear){
                operando1.setText("");
                operando1.setHint("Operando 1");
                operando2.setText("");
                operando2.setHint("Operando 2");
                resultado.setText("Resultado");
            }else {
                Toast.makeText(this, "Error: Operación no válida", Toast.LENGTH_SHORT).show();
                return;
            }

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, ingresa números válidos", Toast.LENGTH_SHORT).show();
        }
    }
}