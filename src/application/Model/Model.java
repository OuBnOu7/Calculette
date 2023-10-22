package application.Model;

import java.util.Stack;


public class Model {
	
	public String accu; // une mémoire qui contient le résultat du calcul en cours
	public Stack<Double> stack; // La pile déja implementé dans Java Util
	
	public Model() {
		this.stack = new Stack<>(); // Instanciation de l'attribut Pile
		this.accu = "0"; // Instantiation de l'accumulateur à 0
	}
	
	public Stack<Double> getStack(){ // Fonction qui retourne l'attribut pile du Modele
		return this.stack; 
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
	
	public void swap(){ // Fonction pour inverser les deux dernier elements de la pile
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			this.stack.push(a);
			this.stack.push(b);
			// on depile les 2 derniers elements et on repile dans l'order inverse
		}
		// Le processus ne marche qu'avec 2 elements minimum dans la pile
		else{System.out.println("There is less than 2 elements in the stack !");} 
	}
	
	public void clear(){ // Remettre la pile à 0 (Vide)
		this.stack.clear();
	}
	
	public void add(){ // L'addition des 2 dernier element de la pile
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			this.stack.push(a+b); // empiler le resultat 
			this.accu = String.valueOf(a+b); // Update l'accumulateur

		}
		// Le processus ne marche qu'avec deux elements dans la pile
		else{System.out.println("There is less than 2 elements in the stack !");}
		
	}
	
	public void substract(){ // De meme la soustraction des 2 dernier element de la pile
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			this.stack.push(a-b);
			this.accu = String.valueOf(a-b);
		}
		else{System.out.println("There is less than 2 elements in the stack !");}
		
	}
	
	public void multiply(){ // De meme la multiplication des 2 dernier element de la pile
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			this.stack.push(a*b);
			this.accu = String.valueOf(a*b);
		}
		else{System.out.println("There is less than 2 elements in the stack !");}
		
	}
	
	public void division(){ // De meme pour soustraction des 2 dernier element de la pile
		if(this.stack.size()>=2) {
			double a = this.stack.pop();
			double b = this.stack.pop();
			if(b==0) {System.out.println("Division Par 0 !"); } //Gerer le cas de division par 0
			else{this.stack.push(a/b);this.accu = String.valueOf(a/b);}
		}
		else{System.out.println("There is less than 2 elements in the stack !");}
	}
	
	public void show() { // Afficher tout les elements de la pile
	    for (Double element : this.stack) {
	        System.out.println(element);
	    }
	}
	
}