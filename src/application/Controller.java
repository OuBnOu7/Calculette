package application;

public class Controller {
	
    private View view;
    private Model model;
    
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.setController(this);
    }


    public void handleButtonClick(String value) {
        if (value.matches("[0-9]")) {
            view.setCurrentInput(view.getCurrentInput() + value);
        } else if (value.equals("C")) {
            view.setCurrentInput("");
            view.setOperator("");
            view.clearDisplay();
        } else if (value.equals("=")) {
            if (!view.getCurrentInput().isEmpty() && !view.getOperator().isEmpty()) {
                double num2 = Double.parseDouble(view.getCurrentInput());
                double result = model.calculate(view.getFirstOperand(), num2, view.getOperator());
                view.setResult(result);
                view.setCurrentInput("");
                view.setOperator("");
            }
        } else {
            if (!view.getCurrentInput().isEmpty()) {
                view.setOperator(value);
                view.setFirstOperand(Double.parseDouble(view.getCurrentInput()));
                view.setCurrentInput("");
            }
        }
    }
}
