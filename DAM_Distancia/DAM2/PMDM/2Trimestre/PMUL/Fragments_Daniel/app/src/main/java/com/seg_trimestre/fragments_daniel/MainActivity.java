package com.seg_trimestre.fragments_daniel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

        //se añaden los botones
        Button calculadora = findViewById(R.id.button),
               web = findViewById(R.id.button2);
        //poner un fragment por defecto
        cambiarFragment(new CalculadoraFragent());

        calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarFragment(new CalculadoraFragent());
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarFragment(new WebViewFragment());
            }
        });

    }
    public void cambiarFragment(Fragment fragmento) {
        FragmentTransaction tr =
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_frame, fragmento);
        tr.commit();
    }
}