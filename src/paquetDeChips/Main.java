package paquetDeChips;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		//texte de début
		System.out.println("Bienvenue dans PAQUET DE CHIPS !\n");
		
		//demander le nb de joueurs
		System.out.println("Combien y a-t-il de joueurs ?");
		Scanner sc = new Scanner(System.in);
		int nbJoueurs = sc.nextInt();
		//entre 1 et 5
		while (nbJoueurs<1 || nbJoueurs >5) {
			System.out.println("Le nombre de joueurs doit être compris entre 2 et 5. Merci de ressaisir ce nombre :");
			nbJoueurs = sc.nextInt();
		}
		
		//demander le nb de robots
	
		
		//on crée une partie
		Partie p = new Partie(nbJoueurs);
		p.lancer(sc);
		
		sc.close();
	}
	
}
