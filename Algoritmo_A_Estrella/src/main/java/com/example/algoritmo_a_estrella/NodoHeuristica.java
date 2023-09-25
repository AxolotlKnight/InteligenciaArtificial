package com.example.algoritmo_a_estrella;

import javafx.beans.property.SimpleStringProperty;

public class NodoHeuristica
{
    private final SimpleStringProperty nodo;
    private final SimpleStringProperty heuristica;
    private final SimpleStringProperty paquito;

    public NodoHeuristica(String nodo, String heuristica, String paquito) {
        this.nodo = new SimpleStringProperty(nodo);
        this.heuristica = new SimpleStringProperty(heuristica);
        this.paquito = new SimpleStringProperty(paquito);
    }

    public String getNodo()
    {
        return nodo.get();
    }

    public String getHeuristica()
    {
        return heuristica.get();
    }
    public String getPaquito()
    {
        return paquito.get();
    }
}
