package joueurs;

import java.util.List;

import cartes.Carte;
import paquetDeChips.Manche;
import paquetDeChips.PaquetCartes;

public class Joueur {
	//attributs
	
	private List<Carte> main; //les cartes que le joueur a en main
	private int nbJetons; //le nb de jetons roi de la chips que le joueur a gagnés
	private int id;
	
	//constructeur
	
	public Joueur(PaquetCartes paquetC, int id) {
		//le joueur commence avec 0 jeton
		nbJetons = 0;
		//le joueur commence avec 6 cartes tirées aléatoirement du paquet
		main = paquetC.tirer();
		this.id = id;
	}
	
	//accesseurs

	public List<Carte> getMain() {
		return main;
	}

	public void setMain(PaquetCartes paquetC) {
		this.main = paquetC.tirer();
	}

	public int getNbJetons() {
		return nbJetons;
	}

	public void setNbJetons(int nbJetons) {
		this.nbJetons = nbJetons;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//méthodes
	
	@Override
	public String toString() {
		String res = "Joueur " + id + " : \n";
		res += "\tNombre de jetons : " + this.nbJetons + "\n";
		res += "\tCartes : \n";
		for (int i=0; i<this.main.size(); i++) {
			res += "\t" + (i+1) + ") " +  main.get(i).toString();
		}
		return res;
	}
	
	public int calculerScore(Manche manche) {
		int score = 0;
		//pour chaque carte dans la main
		for (Carte c : main) {
			if(c.estReussie(manche)) {
				if(c.isEstPositif()) {
					//si l'objectif de la carte est réussi et qu'elle est placée à droite, le joueur gagne les points de la carte
					score += c.getNbPoints();
				} else {
					//si l'objectif de la carte est réussi et qu'elle est placée à gauche, le joueur perd les points de la carte
					score -= c.getNbPoints();
				}
			}
		}
		return score;
	}
}
