package com.lcuraca.tecsup.misgastosapp.models;

public class Operation {

    private String cuenta;
    private String tipo;
    private double monto;

    public Operation(){

    }

    public Operation(String cuenta, String tipo, double monto) {
        this.cuenta = cuenta;
        this.tipo = tipo;
        this.monto = monto;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
