package application;

import java.util.Stack;

public class Controller {
	
    public View view;
    public Model model;
    
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.setController(this);
    }

    
    public void handleButtonClick(String value) {
        if (value.equals("=")) {
        	System.out.println("=");
        } else if (value.equals("C")) {
        	System.out.println("C");
        } else {
        	System.out.println("else");
        }
    }
    
    public void change(String x) {
    	this.model.accu = x ;
    } 

    public void change(Stack<Double> stack ) {
    	this.model.stack= stack ;
    } 
    
}
