package com.example.algoritmo_a_estrella;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import static com.example.algoritmo_a_estrella.HelloController.linea;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Linea
{
    Integer ID;
    Float ax;
    Float ay;
    Float bx;
    Float by;
    Integer PadreA;
    Integer PadreB;
    Float Longitud;
    AnchorPane anchorPane;
    Line lain;

    public Linea(Line linea, Integer ID, Float ax, Float ay, Float bx, Float by, Integer padreA, Integer padreB, Float longitud) {
        this.lain = linea;
        this.ID = ID;
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
        PadreA = padreA;
        PadreB = padreB;
        Longitud = longitud;
    }
    public Linea()
    {

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Float getAx() {
        return ax;
    }

    public void setAx(Float ax) {
        this.ax = ax;
    }

    public Float getAy() {
        return ay;
    }

    public void setAy(Float ay) {
        this.ay = ay;
    }

    public Float getBx() {
        return bx;
    }

    public void setBx(Float bx) {
        this.bx = bx;
    }

    public Float getBy() {
        return by;
    }

    public void setBy(Float by) {
        this.by = by;
    }

    public Integer getPadreA() {
        return PadreA;
    }

    public void setPadreA(Integer padreA) {
        PadreA = padreA;
    }

    public Integer getPadreB() {
        return PadreB;
    }

    public void setPadreB(Integer padreB) {
        PadreB = padreB;
    }

    public Float getLongitud() {
        return Longitud;
    }

    public void setLongitud(Float longitud) {
        Longitud = longitud;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public Line getLain() {
        return lain;
    }

    public void setLain(Line lain) {
        this.lain = lain;
    }

    public void Creacion(AnchorPane anchorPane){
        Line linea1 = new Line();
        setLain(linea1);
        linea1.setStrokeWidth(8);
        linea1.setStartX(ax);
        linea1.setStartY(ay);
        linea1.setEndX(bx);
        linea1.setEndY(by);
        anchorPane.getChildren().add(linea1);
        linea1.toBack();
        linea.add(linea1);
    }
    public void moverlinea(Nodo circulo1, double max, double may, MouseEvent mouseEvent, Boolean esPadreA, Boolean esPadreB, Circle circulo){
        Integer i = 0;
        //System.out.println("Id caso Antes: "+getID());
        for (Line p1 : linea) {
            // System.out.println("Id caso For: "+getID());
            if (p1.getStartX() == circulo.getLayoutX()&& p1.getStartY() == circulo.getLayoutY()) {
                p1.setStartX(mouseEvent.getSceneX() - max);
                p1.setStartY(mouseEvent.getSceneY() - may);
                Linea p2 = new Linea();
                p2.setID(i+1);
                p2.setAx((float) (mouseEvent.getSceneX() - max));
                p2.setAy((float) (mouseEvent.getSceneY() - may));
                p2.setBx((float) p1.getEndX());
                p2.setBy((float) p1.getEndY());

                p2.setLongitud((float) sqrt((pow(p2.getAx()-p2.getBx(),2)+(pow(p2.getAy()-p2.getBy(),2)))));
                HelloController.Linea.add(i,p2);
                System.out.println("Id caso 1: "+getID());

            } else if (p1.getEndX() == circulo.getLayoutX() && p1.getEndY() == circulo.getLayoutY()) {
                p1.setEndX(mouseEvent.getSceneX() - max);
                p1.setEndY(mouseEvent.getSceneY() - may);
                Linea line2 = new Linea();
                line2.setID(i+1);
                line2.setBx((float) (mouseEvent.getSceneX() - max));
                line2.setBy((float) (mouseEvent.getSceneY() - may));
                line2.setAx((float) p1.getStartX());
                line2.setAy((float) p1.getStartY());

                line2.setLongitud((float) sqrt((pow(line2.getAx()-line2.getBx(),2)+(pow(line2.getAy()-line2.getBy(),2)))));
                HelloController.Linea.set(i, line2);
                System.out.println("Id caso 2: "+getID());


            }

            i++;
        }

    }
}
