package application.Model;

import java.util.Stack;
import application.Exception.*;


public class Model implements ModelInterface{
	
	public String accu; // une mémoire qui contient le résultat du calcul en cours
	public Stack<Double> stack; // La pile déja implementé dans Java Util
	
	public Model() {
		this.stack = new Stack<>(); // Instanciation de l'attribut Pile
		this.accu = "0"; // Instantiation de l'accumulateur à 0
	}
	
	public Stack<Double> getStack(){ // Fonction qui retourne l'attribut pile du Modele
		return this.stack; 
	}
	
	public String getAccumulator() {
		return this.accu;
	}
	
	public void push(double x){ // Fonction pour empiler un nombre x
		this.stack.push(x);
	}
	
	public double pop(){ // une Fonction pour depiler et retourner la valeur depilé
		if(!this.stack.empty()) {return this.stack.pop();}
		else {System.out.println("Stack is empty !"); return 0;}
	}
	
	public void drop(){ // Fonction pour supprimer le dernier element de la pile
		this.stack.pop();
	}
	
	public void swap()  throws LessThanTwoElement{ // Fonction pour inverser les deux dernier elements de la pile
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			this.stack.push(a);
			this.stack.push(b);
			// on depile les 2 derniers elements et on repile dans l'order inverse
		}
		// Le processus ne marche qu'avec 2 elements minimum dans la pile
		else{throw new LessThanTwoElement("La Pile Contient Moins Que Deux Elements.") ;}
	}
	
	public void clear(){ // Remettre la pile à 0 (Vide)
		this.stack.clear();
	}
	
	public void add() throws LessThanTwoElement{ // L'addition des 2 dernier element de la pile
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			this.stack.push(a+b); // empiler le resultat 
			this.accu = String.valueOf(a+b); // Update l'accumulateur

		}
		// Le processus ne marche qu'avec deux elements dans la pile
		else{throw new LessThanTwoElement("La Pile Contient Moins Que Deux Elements.") ;}
		
	}
	
	public void substract() throws LessThanTwoElement{ // De meme la soustraction des 2 dernier element de la pile
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			this.stack.push(a-b);
			this.accu = String.valueOf(a-b);
		}
		else{throw new LessThanTwoElement("La Pile Contient Moins Que Deux Elements.") ;}
		
	}
	
	public void multiply() throws LessThanTwoElement{ // De meme la multiplication des 2 dernier element de la pile
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			this.stack.push(a*b);
			this.accu = String.valueOf(a*b);
		}
		else{throw new LessThanTwoElement("La Pile Contient Moins Que Deux Elements.") ;}
		
	}
	
	public void division() throws DivisionByZeroException,LessThanTwoElement { // De meme pour soustraction des 2 dernier element de la pile
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			if(b==0) { throw new DivisionByZeroException("Division by zero is not allowed.") ; } //Gerer le cas de division par 0
			else{this.stack.push(a/b);this.accu = String.valueOf(a/b);}
		}
		else{throw new LessThanTwoElement("La Pile Contient Moins Que Deux Elements.") ;}
	}
	
	public void opposite() throws LessThanOneElement{ // TRansforme le dernier element dans le stack en opposé
		if(this.stack.size()>=1) {
			double a = this.stack.pop();
			this.stack.push(-a);this.accu = String.valueOf(-a);
		}
		else{throw new LessThanOneElement("La Pile est vide.");}
	}
	
	public void show() { // Afficher tout les elements de la pile
	    for (Double element : this.stack) {
	        System.out.println(element);
	    }
	}
	
}