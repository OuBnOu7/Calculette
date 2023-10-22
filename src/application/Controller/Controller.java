package application.Controller;

import java.util.Stack;

import application.Model.Model;
import application.View.View;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {
	
    public View view;
    public Model model;
    
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        setupButtonListeners();
    }
    
        private void setupButtonListeners() {
            Map<String, Button> buttonMap = view.getButtonMap();

            // Create a single event handler for all buttons
            EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button sourceButton = (Button) event.getSource();
                    String buttonLabel = sourceButton.getText();

                    // Use a switch case to determine the action based on the button's label
                    switch (buttonLabel) {
                        case "7":
                            System.out.println("tets");
                            break;
                        case "8":
                            // Handle the action for button "8"
                            break;
                        // Add cases for other buttons
                        case "C":
                            // Handle the action for button "C"
                            break;
                        case "=":
                            // Handle the action for button "="
                            break;
                        default:
                            // Handle any other buttons or unknown labels
                            break;
                    }
                }
            };

            // Assign the event handler to all buttons
            for (Button button : buttonMap.values()) {
                button.setOnAction(buttonHandler);
            }
        }

    public void change(String x) {
    	
    } 

    public void change(Stack<Double> stack ) {
    	
    } 
  
    
}
