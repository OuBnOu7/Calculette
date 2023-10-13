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

    }
    }
    }
