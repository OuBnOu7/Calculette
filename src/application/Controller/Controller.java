package application.Controller;

import application.Model.ModelInterface;
import application.Exception.LessThanTwoElement;
import application.Exception.DivisionByZeroException;
import application.Exception.LessThanOneElement;
import application.View.ViewInterface;

import java.util.Map;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller implements ControllerInterface {
    private final ViewInterface view;
    private final ModelInterface model;

    public Controller(ViewInterface view, ModelInterface model) {
        this.view = view;
        this.model = model;
    }

    public void setupButtonListeners() {
        Map<String, Button> buttonMap = view.getButtonMap();

        StringBuilder currentNumber = new StringBuilder();
        view.change("0");

        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button sourceButton = (Button) event.getSource();
                String buttonLabel = sourceButton.getText();

                try {
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
                            view.change(currentNumber.toString());
                            break;
                        case ",":
                            currentNumber.append(".");
                            view.change(currentNumber.toString());
                            break;
                        case "+":
                            model.add();
                            updateView();
                            break;
                        case "-":
                            model.substract();
                            updateView();
                            break;
                        case "/":
                            model.division();
                            updateView();
                            break;
                        case "*":
                            model.multiply();
                            updateView();
                            break;
                        case "C":
                            currentNumber.setLength(0);
                            model.clear();
                            view.change("0");
                            updateView();
                            break;
                        case "<>":
                        	//Checkez si rien est entré comme valeur
                            if (currentNumber.length() == 0) {
                                System.out.println("Vous Avez Rien Tapez !");
                                break;
                            }
                            
                            //Checker si plusieeurs virgule
                            String currentNumberStr = currentNumber.toString();
                            if (currentNumberStr.contains(".")) {
                                int dotCount = currentNumberStr.length() - currentNumberStr.replace(".", "").length();
                                if (dotCount > 1) {
                                    System.out.println("Vous Avez Tapez Plusieurs Virgules !");
                                    break;
                                }
                            }
                            //Parse to Double puis push dans la pile
                            try {
                                double result = Double.parseDouble(currentNumberStr);
                                currentNumber.setLength(0);
                                model.push(result);
                                updateView();
                            // Cas d'exception du parse en double    
                            } catch (NumberFormatException e) {
                                System.out.println("Format Invaldie !");
                            }
                            break;
                        case "+/-":
                            model.opposite();
                            updateView();
                            break;
                        case "AC":
                            currentNumber.setLength(0);
                            model.clear();
                            view.change("0");
                            updateView();
                            break;
                        case "INV":
                            model.swap();
                            updateView();
                            break;
                        default:
                            break;
                    }
                } catch (LessThanTwoElement e) {
                    view.alert("Less Than Two Elements Error", "Il Y A Moins de 2 Éléments Dans la Pile",
                            "Veuillez Ajouter Plus d'Éléments Avant de Continuer.");
                } catch (DivisionByZeroException e) {
                    view.alert("Division Error", "On Ne Peut Pas Diviser Par 0", "Veuillez Refaire Saisir Des Valeurs Correctes.");
                } catch (LessThanOneElement e) {
                	view.alert("Less Than One Element Error", "Il Y A Moins d'un Élément Dans la Pile", 
                            "Veuillez Ajouter Plus d'Éléments Avant de Continuer.");
                }
            }
        };

        for (Button button : buttonMap.values()) {
            button.setOnAction(buttonHandler);
        }
    }

    // Une méthode pour mettre à jour la vue après une opération
    public void updateView() {
        view.change(String.valueOf(model.getAccumulator()));
        view.change(model.getStack());
    }
}
