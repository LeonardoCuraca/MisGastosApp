package com.lcuraca.tecsup.misgastosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.lcuraca.tecsup.misgastosapp.models.Operation;
import com.lcuraca.tecsup.misgastosapp.repositories.Operationrepository;

public class NewOperationActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private EditText ETmonto;
    private Button button;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);

        String[] arraySpinner = new String[] {
                "Tarjeta de Crédito", "Ahorros", "Efectivo"
        };
        spinner = findViewById(R.id.spinner_cuenta);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        radioGroup = findViewById(R.id.RadioGroup);
        button = findViewById(R.id.button_registrar);
        ETmonto = findViewById(R.id.ET_monto);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }

    public void radioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.CheckBox_Ingreso:
                if(checked){
                    Toast.makeText(getApplicationContext(), "It seems like you feel LinearLayout easy", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.CheckBox_Egreso:
                if(checked){
                    Toast.makeText(getApplicationContext(), "It seems like you feel LinearLayout easy", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void registrar(){

        double monto = Double.parseDouble(ETmonto.getText().toString());
        String spinnerValue = (String) spinner.getSelectedItem();


        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String radioButtonValue = (String) radioButton.getText();

        Operation operation = new Operation();
        operation.setCuenta(spinnerValue);
        operation.setTipo(radioButtonValue);
        operation.setMonto(monto);

        Operationrepository.add(operation);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
