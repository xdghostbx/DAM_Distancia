package com.utiles.cambiodeunidades;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerBaseUnit;
    private EditText editTextInputValue;
    private RadioGroup radioGroupInitialUnit, radioGroupTargetUnit;
    private TextView textViewResult;

    private String[] gramUnits = {"Kg", "g", "mg"};
    private String[] literUnits = {"L", "mL", "cL"};
    private String[] cupUnits = {"Tazas", "Cucharadas", "Cucharaditas"};
    private String[] ounceUnits = {"Oz", "Lb"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBaseUnit = findViewById(R.id.spinner_base_unit);
        editTextInputValue = findViewById(R.id.editText_input_value);
        radioGroupInitialUnit = findViewById(R.id.radioGroup_initial_unit);
        radioGroupTargetUnit = findViewById(R.id.radioGroup_target_unit);
        textViewResult = findViewById(R.id.textView_result);

        updateRadioButtons(gramUnits);

        spinnerBaseUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: updateRadioButtons(gramUnits); break;
                    case 1: updateRadioButtons(literUnits); break;
                    case 2: updateRadioButtons(cupUnits); break;
                    case 3: updateRadioButtons(ounceUnits); break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        findViewById(R.id.button_convert).setOnClickListener(v -> convert());
        findViewById(R.id.button_reset).setOnClickListener(v -> reset());
    }

    private void updateRadioButtons(String[] units) {
        radioGroupInitialUnit.removeAllViews();
        radioGroupTargetUnit.removeAllViews();

        for (String unit : units) {
            RadioButton initialButton = new RadioButton(this);
            initialButton.setText(unit);
            initialButton.setTextSize(14);
            radioGroupInitialUnit.addView(initialButton);

            RadioButton targetButton = new RadioButton(this);
            targetButton.setText(unit);
            targetButton.setTextSize(14);
            radioGroupTargetUnit.addView(targetButton);
        }
    }

    private void convert() {
        String input = editTextInputValue.getText().toString();
        if (input.isEmpty()) {
            textViewResult.setText("Introduce un valor válido.");
            return;
        }

        double value = Double.parseDouble(input);
        int initialId = radioGroupInitialUnit.getCheckedRadioButtonId();
        int targetId = radioGroupTargetUnit.getCheckedRadioButtonId();

        if (initialId == -1 || targetId == -1) {
            textViewResult.setText("Selecciona las unidades.");
            return;
        }

        String initialUnit = ((RadioButton) findViewById(initialId)).getText().toString();
        String targetUnit = ((RadioButton) findViewById(targetId)).getText().toString();

        double result = performConversion(value, initialUnit, targetUnit);
        textViewResult.setText(String.format("%.2f %s", result, targetUnit));
    }

    private double performConversion(double value, String initialUnit, String targetUnit) {
        // Ejemplo simplificado para gram->mg o similar.
        if (initialUnit.equals(targetUnit)) return value;
        // Aquí se añadirían conversiones específicas.
        return value * 2; // Ejemplo genérico.
    }

    private void reset() {
        editTextInputValue.setText("");
        textViewResult.setText("");
        radioGroupInitialUnit.clearCheck();
        radioGroupTargetUnit.clearCheck();
    }
}

