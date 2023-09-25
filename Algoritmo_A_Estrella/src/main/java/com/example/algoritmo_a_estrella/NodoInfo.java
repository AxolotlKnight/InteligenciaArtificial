package com.example.algoritmo_a_estrella;

import javafx.beans.property.SimpleStringProperty;

public class NodoInfo
{
    private final SimpleStringProperty nodo;
    private final SimpleStringProperty enlaces;
    private final SimpleStringProperty  fn;

    public NodoInfo(String nodo, String enlaces, String fn) {
        this.nodo = new SimpleStringProperty(nodo);
        this.enlaces = new SimpleStringProperty(enlaces);
        this.fn = new SimpleStringProperty(fn);
    }

    public String getNodo() {
        return nodo.get();
    }

    public String getEnlaces() {
        return enlaces.get();
    }

    public String getFn() {
        return fn.get();
    }

}
