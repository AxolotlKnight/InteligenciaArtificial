package com.example.algoritmo_a_estrella;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Optional;

import static com.example.algoritmo_a_estrella.HelloController.*;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Nodo
{
    Circle nodo;
    int id;
    double x, y;
    Text text = new Text();
    double heuristica;

    public Nodo(Circle nodo, int id, double x, double y, double heuristica) {
        this.nodo = nodo;
        this.id = id;
        this.x = x;
        this.y = y;
        this.heuristica = heuristica;
    }

    public Nodo()
    {

    }

    public Circle getNodo() {
        return nodo;
    }

    public void setNodo(Circle nodo) {
        this.nodo = nodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(double heuristica) {
        this.heuristica = heuristica;
    }

    Button boton = new Button();
    Boton boton1 = new Boton(id);

    public void dibujar(AnchorPane anchorPane, Nodo nodo, MouseEvent e)
    {
        if(e.getButton() == MouseButton.PRIMARY)
        {
            getNodo().setRadius(20);
            getNodo().setFill(Color.WHITE);
            getNodo().setStroke(Color.BLACK);
            getNodo().setLayoutX(e.getX());
            getNodo().setLayoutY(e.getY());
            text.setText(String.valueOf(id));
            text.setLayoutX(getNodo().getLayoutX());
            text.setLayoutY(getNodo().getLayoutY());
            boton1.crear(boton);
            anchorPane.getChildren().add(boton);
            anchorPane.getChildren().add(getNodo());
            anchorPane.getChildren().add(text);
            num++;
            CrearLinea(boton,anchorPane);

        }
        Arrastrar(getNodo(),nodo);
    }

    public static double mousex;
    public static double mousey;


    public void Arrastrar(Node node, Nodo nodo){

        node.setOnMouseClicked(mouseEvent -> {
            mousex = mouseEvent.getX();
            mousey = mouseEvent.getY();
        });
        node.setOnMouseDragged(mouseEvent -> {
                    if(mouseEvent.getButton() == MouseButton.SECONDARY)
                    {
                        if (canmove) {
                            if (lineas > 0) {
                                lineac.moverlinea(nodo, mousex, mousey, mouseEvent, esNodo1, esNodo2, getNodo());
                            }
                            getNodo().setLayoutX(mouseEvent.getSceneX() - mousex);
                            getNodo().setLayoutY(mouseEvent.getSceneY() - mousey);
                            text.setLayoutX(getNodo().getLayoutX());
                            text.setLayoutY(getNodo().getLayoutY());
                            boton.setLayoutX(mouseEvent.getSceneX() - mousex - 8);
                            boton.setLayoutY(mouseEvent.getSceneY() - mousey + 5);
                            setX((float) (mouseEvent.getSceneX() - mousex));
                            setY((float) (mouseEvent.getSceneX() - mousey));
                            //Actualizar coordenadas en el Tableview
                            Nodo nodo1 = new Nodo();
                            nodo1.setId(Integer.valueOf(text.getText()));
                            nodo1.setX((float) (mouseEvent.getSceneX()));
                            nodo1.setY((float) (mouseEvent.getSceneY()));
                            Node.set(Integer.parseInt(text.getText()) - 1, nodo1);

                        }
                    }
                    }
        );
    }

    Line linea = new Line();
    Boolean esNodo1 = false;
    Boolean esNodo2 = false;
    public static double mouseLinex;
    public static double mouseLiney;
    public void CrearLinea(Node node, AnchorPane anchorPane) {

        node.setOnMouseClicked(e -> {
            mouseLinex = e.getX();
            mouseLiney = e.getY();
            if (selectNodo == 0) {
                System.out.println("Linea creada");
                nx1 = (float) getNodo().getLayoutX();
                ny1 = (float) getNodo().getLayoutY();
                System.out.println(nx1);
                System.out.println(ny1);
                nodo1 = getId();
                esNodo1 = true;
                esNodo2 = false;
                selectNodo++;
            } else {
                System.out.println("Linea 2 conectada");
                nx2 = (float) getNodo().getLayoutX();
                ny2 = (float) getNodo().getLayoutY();
                nodo2 = getId();
                esNodo2 = true;
                esNodo1 = false;
                Float longitud = (float) sqrt((pow(nx2 - nx1, 2) + (pow(ny2 - ny1, 2))));
                lineac = new Linea(linea, lineaId, nx1, ny1, nx2, ny2, nodo1, nodo2, longitud);
                lineac.Creacion(anchorPane);
                Linea.add(lineac);
                lineas++;
                lineaId++;
                selectNodo = 0;
            }
        });
    }
}
