package com.example.algoritmo_a_estrella;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class HelloController implements Initializable
{
    public Button btn_draw;
    @FXML
    private TableView<OpenList> tableViewAbierta;
    public TableColumn<NodoInfo,String> nodoAbierta;
    public TableColumn<NodoInfo,String> padreAbierta;
    public TableColumn<NodoInfo,String> fnAbierta;
    @FXML
    private TableView<CloseList> tableViewCerrada;
    public TableColumn<NodoInfo,String> nodoCerrada;
    public TableColumn<NodoInfo,String> padreCerrada;
    public AnchorPane panel;
    public TableView<Nodo> NodoH;
    public TableColumn<NodoHeuristica, String> nodoColumn;
    public TableColumn<NodoHeuristica, String> heuristicaColumn;
    public TextField nodoFinalTextField;
    public TextField nodoInicioTextField;


    public static ObservableList<Nodo> Node;
    public static Linea lineac = new Linea();
    public static boolean canmove = true;
    public static int lineaId = 0;
    public static int lineas = 0;
    public static int selectNodo = 0;
    public static Integer nodo1 = 0;
    public static Integer nodo2 = 0;
    public static Float nx1 = 0f;
    public static Float ny1 = 0f;
    public static Float nx2 = 0f;
    public static Float ny2 = 0f;
    public static List<Line> linea = new ArrayList<>();
    public static ObservableList<Linea> Linea;
    public static double lyx;
    public static double lyy;
    public static int num = 0;
    public static ObservableList<OpenList> openLists;
    public static ObservableList<CloseList> closeLists;

    public static boolean selectedNodo = false;

    public void onClickButtonDibujar(ActionEvent actionEvent)
    {
        selectedNodo = true;

        Scene scene = this.btn_draw.getScene();
        scene.setOnMousePressed(evento -> {
            if(evento.getButton() == MouseButton.PRIMARY)
            {
                Nodo nodo;
                Circle circle = new Circle();
                lyx = evento.getX();
                lyy = evento.getY();
                nodo = new Nodo(circle, num+1, evento.getX(), evento.getY(),0f);
                nodo.dibujar(panel,nodo,evento);
                Node.add(nodo);
                NodoH.setItems(Node);
            }
            else
            {
                for(Nodo nodo: Node)
                {
                    if(nodo.getNodo().getBoundsInParent().contains(evento.getX(),evento.getY()));
                    {
                        nodo.Arrastrar(nodo.getNodo(),nodo);
                    }

                }
            }
        });


    }

    public void onClickButtonMover(ActionEvent actionEvent)
    {
        int i = 0;

    }

    public static int LAID = 0;

    public void OnCalcular(ActionEvent actionEvent) {
        if(!closeLists.isEmpty())
        {
            for(Linea linea : Linea)
            {
                for(CloseList lista : closeLists)
                {
                    if(Objects.equals(linea.getID(), lista.getLineaID()))
                    {
                        System.out.println(lista.getLineaID());
                        linea.getLain().setStroke(Color.BLACK);
                    }
                }
            }
            for(Nodo nodo : Node){
                for (CloseList lista : closeLists){
                    if(Objects.equals(nodo.getId(), lista.getNodo())){

                        nodo.getNodo().setFill(Color.WHITE);
                    }
                }
            }
        }
        closeLists.clear();
        openLists.clear();
        tableViewCerrada.getItems().clear();
        tableViewAbierta.getItems().clear();
        canmove =false;
        int i = 0;
        int fin = Integer.parseInt(nodoFinalTextField.getText());
        Nodo nodoCal = Node.get(Integer.parseInt(nodoFinalTextField.getText())-1);
        double x2 = nodoCal.getX();
        double y2 = nodoCal.getY();
        for(Nodo circulo: Node){
            double euristica = 0.0;
            Node.get(i);
            euristica = sqrt((pow(x2-Node.get(i).getX(),2)+(pow(y2-Node.get(i).getY(),2))));
            Node.get(i).setHeuristica(euristica);
            Node.set(i,circulo);
            i++;
        }

        do {
            if (openLists.isEmpty()) {
                int Nodo = Integer.parseInt(nodoInicioTextField.getText());
                float Valor = 0f;
                OpenList paquito = new OpenList(Nodo, Nodo, Valor, null);
                openLists.add(paquito);
                tableViewAbierta.setItems(openLists);
                Integer padre = null;
                CloseList camaron = new CloseList(Nodo, padre, null);
                closeLists.add(camaron);
                tableViewCerrada.setItems(closeLists);
                LAID = Nodo;
            } else ObtenerListaabiertaa(LAID);
        } while (LAID != fin);
        for(Linea linea : Linea)
        {
            for(CloseList lista : closeLists)
            {
                if(Objects.equals(linea.getID(), lista.getLineaID()))
                {
                    System.out.println(lista.getLineaID());
                    linea.getLain().setStroke(Color.BLUE);
                }
            }
        }

        for(Nodo nodo : Node){
            for (CloseList lista : closeLists){
                if(Objects.equals(nodo.getId(), lista.getNodo())){

                    nodo.getNodo().setFill(Color.GREEN);
                }
            }
        }


    }

    public void ObtenerListaabiertaa(Integer ID){
        int i = 0;
        double menor = 10000f;
        for(Linea linea : Linea) {
            if (Objects.equals(ID, linea.getPadreA()) || Objects.equals(ID, linea.getPadreB()))
            {
                int padre = ID;
                int nodo = 0;
                if (linea.PadreA == ID)
                    nodo = linea.PadreB;
                else if (linea.PadreB == ID)
                    nodo = linea.PadreA;
                double valor = linea.Longitud + Node.get(nodo - 1).heuristica;
                int idlinea = linea.getID();
                OpenList paquito = new OpenList(nodo, padre, valor, idlinea);
                openLists.add(paquito);
                if (valor < menor) {
                    menor = valor;
                }
            }
            i++;
        }

        int nodo =0;
        for(OpenList list : openLists) {
            if(list.getFn()==menor) {
                nodo = list.getNodo();
                int padre = list.getPadre();
                int lineaID = list.getLinea();
                CloseList camaron = new CloseList(nodo,padre, lineaID);
                closeLists.add(camaron);
                tableViewCerrada.setItems(closeLists);
            }
        }
        LAID = nodo;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Node = FXCollections.observableArrayList();
        Linea = FXCollections.observableArrayList();
        openLists = FXCollections.observableArrayList();
        closeLists = FXCollections.observableArrayList();
        this.nodoColumn.setCellValueFactory(new PropertyValueFactory("id"));
        this.heuristicaColumn.setCellValueFactory(new PropertyValueFactory("heuristica"));
        this.nodoAbierta.setCellValueFactory(new PropertyValueFactory("nodo"));
        this.padreAbierta.setCellValueFactory(new PropertyValueFactory("padre"));
        this.fnAbierta.setCellValueFactory(new PropertyValueFactory("fn"));
        this.nodoCerrada.setCellValueFactory(new PropertyValueFactory("nodo"));
        this.padreCerrada.setCellValueFactory(new PropertyValueFactory("padre"));
    }

}