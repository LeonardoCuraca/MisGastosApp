package com.lcuraca.tecsup.misgastosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lcuraca.tecsup.misgastosapp.models.Operation;
import com.lcuraca.tecsup.misgastosapp.repositories.Operationrepository;

import java.util.ArrayList;
import java.util.List;

public class CreditoActivity extends AppCompatActivity {

    private ListView listView;
    List<String> CreditoOperations = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credito);

        getCredito(CreditoOperations);


        listView = findViewById(R.id.listViewAhorros);
        ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,CreditoOperations);
        listView.setAdapter(arrayadapter);
    }

    public void getCredito(List<String> listOp){
        List<Operation> opList = Operationrepository.getOperations();
        for(int i = 0; i < opList.size(); i++){
            if(String.valueOf(opList.get(i).getCuenta()).equals("Tarjeta de Crédito")){
                listOp.add(String.valueOf(opList.get(i).getTipo()));
                listOp.add(String.valueOf(opList.get(i).getMonto()));
            }
        }
    }
}
