package paquetDeChips;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import joueurs.Joueur;

public class Partie {
	
	//attributs
	private List<Joueur> joueurs;
	private PaquetCartes paquetCartes;
	
	//constructeur
	public Partie(int nbJoueurs) {
		paquetCartes = new PaquetCartes();
		joueurs = new ArrayList<>();
		for (int i=0 ; i<nbJoueurs; i++) {
			Joueur j = new Joueur(paquetCartes, i+1);
			joueurs.add(j);
		}
	}
	
	//accesseurs
	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public PaquetCartes getPaquetCartes() {
		return paquetCartes;
	}
	
	//méthodes
	public void lancer(Scanner sc) {
		Manche m = new Manche(joueurs);
		//tant qu'un joueur n'a pas gagné (nb jetons < 4)
		while(this.aGagne()==null) {
			//affichage des joueurs (sans les cartes)
			for(Joueur j : joueurs) {
				System.out.println("Joueur " + j.getId() + "\nNombre de jetons : " + j.getNbJetons() + "\n");
			}
			//on fait une manche
			m.derouler(sc);
			
			//on reinitialise la manche
			m.reinitialiser();
			//on reinitialise le paquet
			paquetCartes.reinitialiser();
			//on redonne des cartes aux joueurs
			for(Joueur j : joueurs) {
				j.setMain(paquetCartes);
			}
		}
		//affichage final des joueurs
		for(Joueur j : joueurs) {
			System.out.println(j.toString() + "\n");
		}
		//affichage du joueur vainqueur
		Joueur v = this.aGagne();
		System.out.println("\n\nLe joueur vainqueur est le joueur " + v.getId() + "! Félicitations !!");
	}
	
	public Joueur aGagne() {
		Joueur v = null;
		for(Joueur j : joueurs) {
			if(j.getNbJetons()>=4) {
				v=j;
			}
		}
		return v;
	}
}
