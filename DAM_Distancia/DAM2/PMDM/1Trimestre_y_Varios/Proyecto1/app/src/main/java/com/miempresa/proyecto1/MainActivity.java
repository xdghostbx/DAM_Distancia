package com.miempresa.proyecto1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button boton2 = (Button) findViewById(R.id.button_send2);
        boton2.setOnClickListener(new ReceptorBoton());
    }

    public void enviarMensaje(View v){

        EditText texto = (EditText) findViewById(R.id.edit_message);
        Toast.makeText(this, texto.getText(), Toast.LENGTH_SHORT).show();
    }
    //boton de forma no programatica
    public void onClick(View v){

    }

    public class ReceptorBoton implements View.OnClickListener {
        @Override
        public void onClick(View v){

        }
    }
}