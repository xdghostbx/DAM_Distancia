package com.miempresa.holamundo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

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

        Button btSi = (Button)findViewById(R.id.btSi);
        Button bt1 = (Button)findViewById(R.id.b1);
        Button bt2 = (Button)findViewById(R.id.b2);
        Button bt3 = (Button)findViewById(R.id.b3);
        Button bt4 = (Button)findViewById(R.id.b4);
        Button bt5 = (Button)findViewById(R.id.b5);
        Button bt6 = (Button)findViewById(R.id.b6);
        Button bt7 = (Button)findViewById(R.id.b7);
        Button bt8 = (Button)findViewById(R.id.b8);
        Button bt9 = (Button)findViewById(R.id.b9);

        btSi.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Log.d("BUTTONS","EL usuario es tonto");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("¿Estás seguro?")
                    .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Acción al pulsar "Sí"
                            AlertDialog.Builder thanksBuilder = new AlertDialog.Builder(MainActivity.this);
                            thanksBuilder.setMessage("Gracias por aprobar a este alumno")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();
                                    }
                                });
                            AlertDialog thanksAlert = thanksBuilder.create();
                            thanksAlert.show();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Acción al pulsar "No"
                            dialog.dismiss();
                        }
                    });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                bt1.setVisibility(View.INVISIBLE);
                bt2.setVisibility(View.VISIBLE);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                bt2.setVisibility(View.INVISIBLE);
                bt3.setVisibility(View.VISIBLE);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                bt3.setVisibility(View.INVISIBLE);
                bt4.setVisibility(View.VISIBLE);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                bt4.setVisibility(View.INVISIBLE);
                bt5.setVisibility(View.VISIBLE);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                bt5.setVisibility(View.INVISIBLE);
                bt6.setVisibility(View.VISIBLE);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                bt6.setVisibility(View.INVISIBLE);
                bt7.setVisibility(View.VISIBLE);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                bt7.setVisibility(View.INVISIBLE);
                bt8.setVisibility(View.VISIBLE);
            }
        });
        bt8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                bt8.setVisibility(View.INVISIBLE);
                bt9.setVisibility(View.VISIBLE);
            }
        });
        bt9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                bt9.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.VISIBLE);
            }
        });
    }
}