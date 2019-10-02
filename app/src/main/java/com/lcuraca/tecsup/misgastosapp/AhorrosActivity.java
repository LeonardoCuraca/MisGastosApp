package com.lcuraca.tecsup.misgastosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lcuraca.tecsup.misgastosapp.models.Operation;
import com.lcuraca.tecsup.misgastosapp.repositories.Operationrepository;

import java.util.ArrayList;
import java.util.List;

public class AhorrosActivity extends AppCompatActivity {

    private TextView totalAhorros;
    private ListView listView;
    List<String> AhorrosOperations = new ArrayList<String>();
    double total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorros);

        getAhorros(AhorrosOperations);


        listView = findViewById(R.id.listViewAhorros);
        ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,AhorrosOperations);
        listView.setAdapter(arrayadapter);

        totalAhorros = findViewById(R.id.totalAhorros);
        totalAhorros.setText(String.valueOf(total));

    }

    public void getAhorros(List<String> listOp){
        List<Operation> opList = Operationrepository.getOperations();
        for(int i = 0; i < opList.size(); i++){
            Operation op = opList.get(i);
            if(String.valueOf(op.getCuenta()).equals("Ahorros")){
                listOp.add(String.valueOf(op.getTipo()));
                listOp.add(String.valueOf(op.getMonto()));
            }
        }
        listOp.add(String.valueOf(total));
    }

}
