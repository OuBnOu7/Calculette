package application.View;

import java.util.Stack;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.HashMap;
import java.util.Map;

import application.Controller.*;
import application.Model.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Iterator;

public class View extends Application implements ViewInterface {
    private Label[] resultFields = new Label[5];
    private Map<String, Button> buttonMap = new HashMap<>();
    
	public void affiche(String[] args) {
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

	    Border border = new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(9), new BorderWidths(0.5)));
	    
	    for (int i = 0; i < 5; i++) {
	        resultFields[i] = new Label("");
	        resultFields[i].setPrefSize(295, 40); // Définir la taille souhaitée
	        resultFields[i].setStyle("-fx-background-color: #E0E0E0; -fx-background-radius: 9px; -fx-font-size: 18; -fx-font-weight: 400; -fx-padding: 10px;");
	        resultFields[i].setTextFill(Color.web("black"));
	        resultFields[i].setBorder(border);
	        if (i == 4) {
	            // Pour la zone de texte la plus proche des boutons
	            resultFields[i].setStyle(resultFields[i].getStyle() + "-fx-background-color: #d7e7fc;"); // Couleur bleu azur
	        } else {
	            resultFields[i].setStyle(resultFields[i].getStyle() + "-fx-background-color: #E0E0E0;"); // Autres zones en gris
	        }
	        resultsBox.getChildren().add(resultFields[i]);
	    }
	    // Ajoutez une marge de 30 pixels entre les zones de texte et les boutons
	    VBox.setMargin(resultsBox, new Insets(0, 0, 20, 0));
	    
	    vbox.getChildren().add(resultsBox);

	    // Create the button grid at the bottom using a GridPane
	    GridPane buttonGrid = createButtonGrid();
	    vbox.getChildren().add(buttonGrid);

        Controller controller = new Controller(this, new Model());
        controller.setupButtonListeners();
	    
	    //Scene scene = new Scene(vbox, 400, 650, scene.setUserAgentStylesheet(scene.getUserAgentStylesheet("-fx-background-color: #000000;"))); // Ajustez la hauteur pour qu'elle soit plus grande
        Scene scene = new Scene(vbox, 400, 650);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
	    primaryStage.show();
	}

    
	public GridPane createButtonGrid() {
	    GridPane grid = new GridPane();
	    grid.setHgap(7);
	    grid.setVgap(11);
	    grid.setAlignment(Pos.CENTER);

	    String[][] buttonLabels = {
	        {"AC", "INV", "C", "/"},
	        {"7", "8", "9", "+"},
	        {"4", "5", "6", "-"},
	        {"1", "2", "3", "*"},
	        {",", "0", "<>", "+/-"}
	    };

	    for (int i = 0; i < 5; i++) {
	        for (int j = 0; j < 4; j++) {
	            if (buttonLabels[i][j].equals("")) {
	                j++;
	            }
	            Button button = new Button(buttonLabels[i][j]);
	            int colSpan = 1; // Default, a button with normal width
	            if (buttonLabels[i][j].equals("AC") || buttonLabels[i][j].equals("INV")) {
	                // Set the width of "AC" and "INV" buttons to match other buttons
	                button.setMinWidth(70);
	                button.setMaxWidth(70);
	            } else {
	                // Use standard width for other buttons
	                button.setMinWidth(70 * colSpan);
	                button.setMaxWidth(70 * colSpan);
	            }
	            button.setMinHeight(45); // Minimum height of 45 pixels
	            button.setMaxHeight(45); // Maximum height of 45 pixels
	            button.setStyle("-fx-font-size: 16px; -fx-alignment: CENTER;");
	            GridPane.setColumnSpan(button, colSpan); // Set the button's width
	            grid.add(button, j, i);

	            buttonMap.put(buttonLabels[i][j], button);

	            // Modify the style of the buttons
	            if (buttonLabels[i][j].equals("C")) {
	                button.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-size: 21px; -fx-alignment: CENTER;");
	            } else if (buttonLabels[i][j].equals("<>")) {
	                button.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 21px; -fx-alignment: CENTER;");
	            } else if (buttonLabels[i][j].matches("[+\\-*/,]")) {
	                button.setStyle("-fx-background-color: gray; -fx-text-fill: white; -fx-font-size: 18px; -fx-alignment: CENTER;");
	            }else if (buttonLabels[i][j].equals("AC")) {
                	button.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 21px; -fx-alignment: CENTER;");
                }  else if (buttonLabels[i][j].equals("+/-")) {
	                button.setStyle("-fx-background-color: gray; -fx-text-fill: white; -fx-font-size: 18px; -fx-alignment: CENTER;");
	            }
	        }
	    }
	    return grid;
	}


    
	@SuppressWarnings("exports")
	public Map<String, Button> getButtonMap() {
		return buttonMap;
	}
    
	
	public void alert(String title,String header,String text) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);

        alert.showAndWait();
	}
	
    @SuppressWarnings("exports")
    public void change(String x) {
    	this.resultFields[4].setText(x);
    } 

    public void change(Stack<Double> stack) {
            Iterator<Double> iterator = stack.iterator();
            for (int i = 0; i < 4; i++) {
                if (iterator.hasNext()) {
                    resultFields[i].setText(iterator.next().toString());
                	}
                else {
                	resultFields[i].setText("");
                }
                }
            }
    
    //retourne le button a partir de son nom
    @Override
    public Button getButton(String btn) {
        return buttonMap.get(btn);
    }

    
}
