package application.Controller;

import java.util.Stack;

public interface ControllerInterface {
    void setupButtonListeners();
    void change(String x); 
    void change(Stack<Double> stack);
}
