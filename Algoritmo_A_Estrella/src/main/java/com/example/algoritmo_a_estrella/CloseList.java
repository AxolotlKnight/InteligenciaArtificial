package com.example.algoritmo_a_estrella;

public class CloseList
{
    private int nodo;
    private int padre;
    private int lineaID;

    public CloseList(int nodo, int padre, int lineaID) {
        this.nodo = nodo;
        this.padre = padre;
        this.lineaID = lineaID;
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

    public int getLineaID() {
        return lineaID;
    }

    public void setLineaID(int lineaID) {
        this.lineaID = lineaID;
    }
}
