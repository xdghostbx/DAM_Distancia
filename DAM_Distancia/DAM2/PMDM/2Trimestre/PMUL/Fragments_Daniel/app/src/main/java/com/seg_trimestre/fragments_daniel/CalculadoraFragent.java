package com.seg_trimestre.fragments_daniel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraFragent extends Fragment {

    public CalculadoraFragent() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculadora, container, false);

        //se agregan las variables
        EditText op1 = view.findViewById(R.id.et_operando1), op2 = view.findViewById(R.id.et_operando2);
        Button operar = view.findViewById(R.id.bt_operar);
        TextView resultado = view.findViewById(R.id.tv_resultado);
        //botones radio
        RadioButton suma = view.findViewById(R.id.rb_sumar),
                    resta = view.findViewById(R.id.rb_restar),
                    multiplicar = view.findViewById(R.id.rb_mult),
                    dividir = view.findViewById(R.id.rb_div);

        operar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int numero1 = Integer.parseInt(op1.getText().toString());
                    int numero2 = Integer.parseInt(op2.getText().toString());

                    if (suma.isChecked()){
                        resultado.setText(""+(numero1+numero2));
                    }
                    if (resta.isChecked()){
                        resultado.setText(""+(numero1-numero2));
                    }
                    if (multiplicar.isChecked()) {
                        resultado.setText(""+(numero1*numero2));
                    }
                    if (dividir.isChecked()){
                        if(numero2 == 0) {
                            Toast.makeText(getActivity(), "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                        }else {
                            resultado.setText(""+(numero1/numero2));
                        }
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(),"Introduce numeros validos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}