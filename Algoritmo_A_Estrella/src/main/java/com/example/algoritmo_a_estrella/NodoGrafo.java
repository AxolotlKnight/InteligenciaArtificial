package com.example.algoritmo_a_estrella;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.HashSet;
import java.util.Set;

public class NodoGrafo
{
    private String caracter;
    private Circle circle;
    private Set<NodoGrafo> enlaces = new HashSet<>();
    private NodoGrafo padre;
    private double gn; // Costo real desde el nodo inicial
    private double hn; // Heurística (distancia estimada al nodo final)
    private double fn; // fn = gn + hn

    public NodoGrafo(String caracter, double x, double y) {
        this.caracter = caracter;
        this.circle = new Circle(x, y, 20, Color.BLUE);
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Set<NodoGrafo> getEnlaces() {
        return enlaces;
    }

    public void setEnlaces(Set<NodoGrafo> enlaces) {
        this.enlaces = enlaces;
    }

    public NodoGrafo getPadre() {
        return padre;
    }

    public void setPadre(NodoGrafo padre) {
        this.padre = padre;
    }

    public double getGn() {
        return gn;
    }

    public void setGn(double gn) {
        this.gn = gn;
    }

    public double getHn() {
        return hn;
    }

    public void setHn(double hn) {
        this.hn = hn;
    }

    public double getFn() {
        return fn;
    }

    public void setFn(double fn) {
        this.fn = fn;
    }

    public void calcularFn() {
        fn = gn + hn;
    }
}
