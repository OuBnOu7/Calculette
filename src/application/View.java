package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends Application {
    private TextField[] resultFields = new TextField[5];
    private String currentInput = "";
    private double[] results = new double[5];
    private String operator = "";

    private Controller controller;
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public static void main(String[] args) {
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
        for (int i = 0; i < 5; i++) {
            resultFields[i] = new TextField();
            resultFields[i].setEditable(false);
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

                final int row = i;
                final int col = j;

                button.setOnAction(e -> handleButtonClick(buttonLabels[row][col]));
            }
        }

        return grid;
    }

    private void handleButtonClick(String value) {
    }
}
