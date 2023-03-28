package cartes;

import chips.Couleur;
import paquetDeChips.Manche;

public class ZeroCarte extends Carte {
	private Couleur couleur;
	
	//constructeur
	
	public ZeroCarte(int nbPoints, String cat, String arg) {
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
			
		//condition : si le nb de chips de cette couleur est nul
		if (manche.getNbChips(true, couleur) == 0) {
			reussi = true;
		}
		return reussi;
	}
	
	@Override
	public String toString() {
		String res = super.toString();
		res += "il n'y a pas de chips de couleur " + couleur + "\n";
		return res;
	}	
}
