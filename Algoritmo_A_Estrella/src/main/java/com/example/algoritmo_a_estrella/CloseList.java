package com.example.algoritmo_a_estrella;

public class CloseList
{
    private Integer nodo;
    private Integer padre;
    private Integer lineaID;

    public CloseList(Integer nodo, Integer padre, Integer lineaID) {
        this.nodo = nodo;
        this.padre = padre;
        this.lineaID = lineaID;
    }

    public Integer getNodo() {
        return nodo;
    }

    public void setNodo(int nodo) {
        this.nodo = nodo;
    }

    public Integer getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public Integer getLineaID() {
        return lineaID;
    }

    public void setLineaID(Integer lineaID) {
        this.lineaID = lineaID;
    }
}
