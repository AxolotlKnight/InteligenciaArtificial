package com.example.algoritmo_a_estrella;

import javafx.scene.control.Button;

import static com.example.algoritmo_a_estrella.HelloController.lyx;
import static com.example.algoritmo_a_estrella.HelloController.lyy;

public class Boton
{
    Integer padre;

    public Boton(Integer padre) {
        this.padre = padre;
    }

    public Integer getPadre() {
        return padre;
    }

    public void setPadre(Integer padre) {
        this.padre = padre;
    }
    public void crear(Button boton){
        boton.setLayoutX(lyx+10);
        boton.setLayoutY(lyy+ 25);
        boton.setText("+");
        boton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 25px; " +
                        "-fx-min-height: 25px; " +
                        "-fx-max-width: 25px; " +
                        "-fx-max-height: 25px;"
        );

    }
}
