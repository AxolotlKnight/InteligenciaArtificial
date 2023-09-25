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
    int id;
    float x1;
    float y1;
    float x2;
    float y2;
    int PadreA;
    int PadreB;
    float Longitud;
    AnchorPane anchorPane;
    Line lain;

    public Linea(Line linea, int ID, float ax, float ay, float bx, float by, int padreA, int padreB, float longitud) {
        this.lain = linea;
        this.id = ID;
        this.x1 = ax;
        this.y1 = ay;
        this.x2 = bx;
        this.y2 = by;
        PadreA = padreA;
        PadreB = padreB;
        Longitud = longitud;
    }
    public Linea()
    {

    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public float getAx() {
        return x1;
    }

    public void setAx(float ax) {
        this.x1 = ax;
    }

    public float getAy() {
        return y1;
    }

    public void setAy(Float ay) {
        this.y1 = ay;
    }

    public float getBx() {
        return x2;
    }

    public void setBx(float bx) {
        this.x2 = bx;
    }

    public float getBy() {
        return y2;
    }

    public void setBy(float by) {
        this.y2 = by;
    }

    public int getPadreA() {
        return PadreA;
    }

    public void setPadreA(int padreA) {
        PadreA = padreA;
    }

    public int getPadreB() {
        return PadreB;
    }

    public void setPadreB(int padreB) {
        PadreB = padreB;
    }

    public float getLongitud() {
        return Longitud;
    }

    public void setLongitud(float longitud) {
        Longitud = longitud;
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
        linea1.setStartX(x1);
        linea1.setStartY(y1);
        linea1.setEndX(x2);
        linea1.setEndY(y2);
        anchorPane.getChildren().add(linea1);
        linea1.toBack();
        linea.add(linea1);
    }
    public void moverlinea(Nodo circulo1, double max, double may, MouseEvent mouseEvent, Boolean esPadreA, Boolean esPadreB, Circle circulo){
        int i = 0;
        for (Line p1 : linea) {
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


            }

            i++;
        }

    }
}
