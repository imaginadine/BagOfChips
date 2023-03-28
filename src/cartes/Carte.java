package cartes;

import paquetDeChips.Manche;

public abstract class Carte {
	//attributs
	
	private int nbPoints; //points attribués si la carte est réussie
	private String cat; //catégorie de la carte
	private String arg; //arguments nécessaires pour avoir la condition complète
	private boolean estPositif; //true si la carte est placée à droite, false si à gauche, null sinon
	
	//constructeur
	
	public Carte(int nbPoints, String cat, String arg) {
		this.nbPoints = nbPoints;
		this.cat = cat;
		this.arg = arg;
	}
	
	//accesseurs
	
	public int getNbPoints() {
		return nbPoints;
	}
	
	public void setNbPoints(int nb) {
		this.nbPoints = nb;
	}
	
	public String getCat() {
		return cat;
	}

	public boolean isEstPositif() {
		return estPositif;
	}

	public void setEstPositif(boolean estPositif) {
		this.estPositif = estPositif;
	}
	
	public String getArg() {
		return arg;
	}
	
	//méthode abstraite
	
	public abstract boolean estReussie(Manche manche);
	
	//méthodes
	@Override
	public String toString() {
		return "Cette carte fait gagner " + nbPoints + " points si cette condition est vraie une fois que tous les chips sont sortis : \n";
	}
}
