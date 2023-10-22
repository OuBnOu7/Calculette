package application;

import application.Controller.Controller;
import application.Model.Model;
import application.View.View;

public class Main{
	
	public static void main(String[] args) {
		View vue = new View();
		Model modele = new Model();
		Controller control = new Controller(vue,modele);
		vue.affiche(args);
		


		
	}
}
