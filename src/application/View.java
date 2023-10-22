package application;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class View extends Application {
    private Label[] resultFields = new Label[5];
    private String currentInput = "";
    private double[] results = new double[5];
    private String operator = "";
    private Map<String, Button> buttonMap = new HashMap<>();
    
	public static void demarrer(String[] args) {
		launch(args);
	}

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Calculator");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        // Create a VBox for result areas at the top
        VBox resultsBox = new VBox();
        resultsBox.setSpacing(10);  // Add spacing between result areas
        resultsBox.setPadding(new Insets(10, 10, 10, 10));  // Add padding
        resultsBox.setAlignment(Pos.CENTER);

        Border border = new Border(new BorderStroke(Color.RED,BorderStrokeStyle.SOLID, null, new BorderWidths(2)));
        for (int i = 0; i < 5; i++) {
            resultFields[i] = new Label("");
            resultFields[i].setBorder(border);
            resultsBox.getChildren().add(resultFields[i]);
        }
        vbox.getChildren().add(resultsBox);

        // Create the button grid at the bottom using a GridPane
        GridPane buttonGrid = createButtonGrid();
        vbox.getChildren().add(buttonGrid);

        Scene scene = new Scene(vbox, 400, 600); // Adjust the height to make it taller
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createButtonGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        String[][] buttonLabels = {
            {"7", "8", "9", "+"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "*"},
            {"C", "0", "=", "/"}
        };
    
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button button = new Button(buttonLabels[i][j]);
                button.setMinSize(50, 50);
                grid.add(button, j, i);

                buttonMap.put(buttonLabels[i][j], button);
            }
        }

        return grid;
    }
    
	public Map<String, Button> getButtonMap() {
		return buttonMap;
	}
    
    public Button getButton(String btn) {
        return buttonMap.get(btn);
    }

    public void change(String x) {
    	this.resultFields[4].setText(x);
    } 
    public void change(Stack<Double> stack ) {
    	
    } 
   
    public void affiche() {
    }
}
