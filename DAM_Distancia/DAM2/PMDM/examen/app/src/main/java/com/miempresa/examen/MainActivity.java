package com.miempresa.examen;

import static com.miempresa.examen.R.*;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private String datos;
    private String edad;
    private Button enviar;

    private EditText nombre,apellidos,mail,contra;
    private CheckBox condiones;
    private RadioGroup grup;
    private RadioButton anios,anios2,anios3;

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

        enviar = findViewById(R.id.bt_enviar);

        nombre = findViewById(id.et_nombre);
        apellidos = findViewById(id.et_apellidos);
        mail = findViewById(id.et_mail);
        contra = findViewById(id.et_psw);

        condiones = findViewById(id.cb_condiciones);

        grup = findViewById(id.rg_grupo);
        anios = findViewById(id.rb_edad);
        anios2 = findViewById(id.rb_edad2);
        anios3 = findViewById(id.rb_edad3);

        grup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == id.rb_edad){
                    edad = anios.getText().toString();
                }else if (i == id.rb_edad2){
                    edad = anios2.getText().toString();
                }else {
                    edad = anios3.getText().toString();
                }
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nombre.getText().toString();
                String ape = apellidos.getText().toString();
                String emilio = mail.getText().toString();
                String co = contra.getText().toString();

                if (condiones.isChecked()){
                    datos = name+" "+ape+" "+emilio+" "+co+" "+edad;
                    Toast.makeText(view.getContext(),datos, Toast.LENGTH_LONG).show();
                    nombre.setTextColor(getResources().getColor(color.red));
                }else{
                    Toast.makeText(view.getContext(),"Debes aceptar las condiciones",Toast.LENGTH_SHORT).show();
                    contra.setText("");
                }
            }
        });


    }



}