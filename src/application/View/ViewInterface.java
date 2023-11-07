package application.View;

import java.util.Map;
import java.util.Stack;

import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public interface ViewInterface {
    void affiche(String[] args);
    void start(Stage primaryStage);
    GridPane createButtonGrid();
    Map<String, Button> getButtonMap();
    public void alert(String title,String header,String text);
    Button getButton(String btn);
    void change(String x);
    void change(Stack<Double> stack);
}
