module com.example.algoritmo_a_estrella {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.algoritmo_a_estrella to javafx.fxml;
    exports com.example.algoritmo_a_estrella;
}