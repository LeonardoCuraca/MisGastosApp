package com.lcuraca.tecsup.misgastosapp.repositories;

import com.lcuraca.tecsup.misgastosapp.models.Operation;

import java.util.ArrayList;
import java.util.List;

public class Operationrepository {
    public static List<Operation> operations;

    static {
        operations = new ArrayList<>();
        operations.add( new Operation("Ahorros", "Ingreso", 1250.00) );
    }

    public static void add(Operation operation){
        operations.add(0, operation);
    }

    public static List<Operation> getOperations(){
        return operations;
    }
}
