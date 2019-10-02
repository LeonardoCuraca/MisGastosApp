package com.lcuraca.tecsup.misgastosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private LinearLayout LLAhorro, LLCredito, LLEfectivo;
    private EditText ETAhorro, ETCredito, ETEfectivo;
    private ProgressBar progressBar;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(30);

        LLAhorro = findViewById(R.id.linear_ahorro);
        LLCredito = findViewById(R.id.linear_credito);
        LLEfectivo = findViewById(R.id.linear_efectivo);

        LLAhorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ahorrosView();
            }
        });

        LLCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creditoView();
            }
        });

        LLEfectivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efectivoView();
            }
        });

        floatingActionButton = findViewById(R.id.newOperation_floatingButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newOperation();
            }
        });

    }

    private void ahorrosView(){
        Intent intent = new Intent(this, AhorrosActivity.class);
        startActivity(intent);
    }

    private void creditoView(){
        Intent intent = new Intent(this, CreditoActivity.class);
        startActivity(intent);
    }

    private void efectivoView(){
        Intent intent = new Intent(this, EfectivoActivity.class);
        startActivity(intent);
    }

    private void newOperation(){
        Intent intent = new Intent(this, NewOperationActivity.class);
        startActivity(intent);
    }

}
