package application.Model;

import java.util.Stack;

import application.Exception.DivisionByZeroException;
import application.Exception.LessThanOneElement;
import application.Exception.LessThanTwoElement;

public interface ModelInterface {
	
	
	public Stack<Double> getStack();
	String getAccumulator();
	void push(double x);
	double pop();
	void drop() throws LessThanOneElement;
	void swap() throws LessThanTwoElement;
	void clear();
	void add() throws LessThanTwoElement;
	void substract() throws LessThanTwoElement;
	void multiply() throws LessThanTwoElement; 
	void division() throws DivisionByZeroException,LessThanTwoElement;
	public void opposite() throws LessThanOneElement;
	void show();
}
