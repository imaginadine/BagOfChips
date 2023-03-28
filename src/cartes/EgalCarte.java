package cartes;

import chips.Couleur;
import paquetDeChips.Manche;

public class EgalCarte extends Carte {
	private Couleur couleur1;
	private Couleur couleur2;
	
	//constructeur
	
	public EgalCarte(int nbPoints, String cat, String arg) {
		super(nbPoints, cat, arg);
		
		//on met les arguments dans un tableau
		String[] tabArg;
		tabArg = this.getArg().split(";");
			
		//on prend les deux couleurs qui sont en argument
		couleur1 = Couleur.stringToCouleur(tabArg[0]);
		couleur2 = Couleur.stringToCouleur(tabArg[1]);
	}
		
	/*
	* méthode pour savoir si une carte est réussie
	*
	*/
	@Override
	public boolean estReussie(Manche manche) {
		boolean reussi = false;
			
		//condition : s'il y autant de chips d'une couleur que de l'autre
		if (manche.getNbChips(true, couleur1) == manche.getNbChips(true, couleur2)) {
			reussi = true;
		}
		return reussi;
	}
	
	@Override
	public String toString() {
		String res = super.toString();
		res += "il y a autant de chips de couleur " + couleur1 + " que de chips de couleur " + couleur2 + "\n";
		return res;
	}
}
