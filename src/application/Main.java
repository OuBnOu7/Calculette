package application;

public class Main{
	
	public static void main(String[] args) {
		View vue = new View();
		Model modele = new Model();
		Controller control = new Controller(vue,modele);
		vue.demarrer(args);
		


		
	}
}
