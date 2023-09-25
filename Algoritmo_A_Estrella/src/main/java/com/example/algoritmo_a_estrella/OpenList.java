package com.example.algoritmo_a_estrella;

public class OpenList
{
    private int nodo;
    private int padre;
    private double fn;
    private int linea;

    public OpenList(int nodo, int padre, double fn, int linea) {
        this.nodo = nodo;
        this.padre = padre;
        this.fn = fn;
        this.linea = linea;
    }

    public int getNodo() {
        return nodo;
    }

    public void setNodo(int nodo) {
        this.nodo = nodo;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public double getFn() {
        return fn;
    }

    public void setFn(Float fn) {
        this.fn = fn;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }
}
