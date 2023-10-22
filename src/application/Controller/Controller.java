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
    }
    
        public void setupButtonListeners() {
            Map<String, Button> buttonMap = view.getButtonMap();

            StringBuilder currentNumber = new StringBuilder();
            view.change("0"); // afficher le 0

            // Create a single event handler for all buttons
            EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button sourceButton = (Button) event.getSource();
                    String buttonLabel = sourceButton.getText();

                    // Use a switch case to determine the action based on the button's label
                    switch (buttonLabel) {
                        case "0":
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                        	currentNumber.append(buttonLabel);
                        	System.out.println(buttonLabel);
                        	view.change(currentNumber.toString());
                            break;
                        case "+":
                        	model.add();
                        	view.change(model.accu);
                        	change(model.getStack());
                        	break;
                        case "-":   
                        	model.substract();
                        	view.change(model.accu);
                        	change(model.getStack());
                        	break;
                        case "/":  
                        	model.division();
                        	view.change(model.accu);
                        	change(model.getStack());
                        	break;
                        case "*":  
                        	model.multiply();
                        	view.change(model.accu);
                        	change(model.getStack());
                        	break;
                        case "C":
                        	currentNumber.setLength(0);
                        	model.accu = "0";
                        	view.change("0");
                            break;
                        case "<>":
                        	if(currentNumber.length() == 0) {
                        		System.out.println("Vous Avez Rien Tapez !");
                        		break;
                        	}
                        	double result = Double.parseDouble(currentNumber.toString());
                        	currentNumber.setLength(0);
                        	model.accu = currentNumber.toString();
                        	model.push(result);
                        	System.out.println(result);
                        	change(model.getStack());
                            
                            break;
                        default:
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
        Stack<Double> resultStack = new Stack<>(); 
        
        int numElementsToRetrieve = Math.min(4, stack.size());

        for (int i = 0; i < numElementsToRetrieve; i++) {
            resultStack.push(stack.get(stack.size() - 1 - i));
        }
	        
        this.view.change(resultStack);
	} 
}