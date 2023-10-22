package application;

import application.Controller.Controller;
import application.Model.Model;
import application.View.View;

public class Main{
	
	public static void main(String[] args) {
		View vue = new View();
		vue.affiche(args);
	}
}
