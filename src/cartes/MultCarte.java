package cartes;

import chips.Couleur;
import paquetDeChips.Manche;

public class MultCarte extends Carte {
	private Couleur couleur;
	
	//constructeur
	
	public MultCarte(int nbPoints, String cat, String arg) {
		super(nbPoints, cat, arg);
		
		//on prend la couleur qui est en argument
		couleur = Couleur.stringToCouleur(this.getArg());
	}
		
	/*
	* méthode pour savoir si une carte est réussie
	*
	*/
	@Override
	public boolean estReussie(Manche manche) {
		boolean reussi = false;
			
		//condition : s'il y a au moins une chips de la couleur
		int nbChips = manche.getNbChips(true, couleur);
		if (nbChips >= 1) {
			reussi = true;
		}
		//le nombre de points de la carte devient le nb de chips sorties * nbPoints
		this.setNbPoints(nbChips * this.getNbPoints());
		
		return reussi;
	}
	
	@Override
	public String toString() {
		return "Cette carte fait gagner " + getNbPoints() + " points par chips de couleur " + couleur + " sortie\n";
	}
}
