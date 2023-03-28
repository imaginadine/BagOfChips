package cartes;

import chips.Couleur;
import paquetDeChips.Manche;

public class LastCarte extends Carte {
	private Couleur couleur;
	
	//constructeur
	
	public LastCarte(int nbPoints, String cat, String arg) {
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
			
		//condition : si la dernière chips est de la couleur
		if (manche.getDerniere().getCouleur().equals(couleur)) {
			reussi = true;
		}
		return reussi;
	}
	
	@Override
	public String toString() {
		String res = super.toString();
		res += "la dernière chips tirée est de couleur " + couleur + "\n";
		return res;
	}	
	
}
