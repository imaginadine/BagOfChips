package cartes;

import chips.Couleur;
import paquetDeChips.Manche;

public class QtCarte extends Carte {

	//constructeur
	
	public QtCarte(int nbPoints, String cat, String arg) {
		super(nbPoints, cat, arg);
	}
	
	/*
	 * méthode pour savoir si une carte est réussie
	 *
	 */
	@Override
	public boolean estReussie(Manche manche) {
		boolean reussi = true;
		
		//on met les arguments dans un tableau
		String[] tabArg;
		tabArg = this.getArg().split(";");
		
		//on prend deux par deux les cases du tableau
		for (int i = 0; i< tabArg.length -1; i=i+2) {
			Couleur couleur = Couleur.stringToCouleur(tabArg[i]);
			int nb = Integer.parseInt(tabArg[i+1]);
		
			//condition : s'il y a au moins tel nombre de chips de ces couleurs, c'est réussi
			if (manche.getNbChips(true, couleur) < nb) {
				reussi = false;
			}
		}
		return reussi;
	}
	
	@Override
	public String toString() {
		String res = super.toString();
		
		//on met les arguments dans un tableau
		String[] tabArg;
		tabArg = this.getArg().split(";");
		
		for (int i = 0; i< tabArg.length -1; i=i+2) {
			Couleur couleur = Couleur.stringToCouleur(tabArg[i]);
			int nb = Integer.parseInt(tabArg[i+1]);
		
			res += " - il y a au moins " + nb + " chips de couleur " + couleur + "\n";
		}
		
		return res;
	}
}
