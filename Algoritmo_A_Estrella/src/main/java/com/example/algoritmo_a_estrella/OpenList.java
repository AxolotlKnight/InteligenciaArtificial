package com.example.algoritmo_a_estrella;

public class OpenList
{
    private Integer nodo;
    private Integer padre;
    private double fn;
    private Integer linea;

    public OpenList(Integer nodo, Integer padre, double fn, Integer linea) {
        this.nodo = nodo;
        this.padre = padre;
        this.fn = fn;
        this.linea = linea;
    }

    public Integer getNodo() {
        return nodo;
    }

    public void setNodo(Integer nodo) {
        this.nodo = nodo;
    }

    public Integer getPadre() {
        return padre;
    }

    public void setPadre(Integer padre) {
        this.padre = padre;
    }

    public double getFn() {
        return fn;
    }

    public void setFn(Float fn) {
        this.fn = fn;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }
}
