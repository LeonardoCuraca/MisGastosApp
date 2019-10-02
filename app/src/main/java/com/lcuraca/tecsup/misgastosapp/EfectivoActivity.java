package com.lcuraca.tecsup.misgastosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lcuraca.tecsup.misgastosapp.models.Operation;
import com.lcuraca.tecsup.misgastosapp.repositories.Operationrepository;

import java.util.ArrayList;
import java.util.List;

public class EfectivoActivity extends AppCompatActivity {

    private ListView listView;
    List<String> EfectivoOperations = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_efectivo);

        getEfectivo(EfectivoOperations);


        listView = findViewById(R.id.listViewAhorros);
        ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,EfectivoOperations);
        listView.setAdapter(arrayadapter);
    }

    public void getEfectivo(List<String> listOp){
        List<Operation> opList = Operationrepository.getOperations();
        for(int i = 0; i < opList.size(); i++){
            if(String.valueOf(opList.get(i).getCuenta()).equals("Efectivo")){
                listOp.add(String.valueOf(opList.get(i).getTipo()));
                listOp.add(String.valueOf(opList.get(i).getMonto()));
            }
        }
    }
}
