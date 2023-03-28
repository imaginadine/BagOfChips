package paquetDeChips;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import cartes.Carte;
import cartes.CompCarte;
import cartes.EgalCarte;
import cartes.LastCarte;
import cartes.MultCarte;
import cartes.QtCarte;
import cartes.ZeroCarte;

//crée le paquet de cartes
public class PaquetCartes {
	private List<Carte> paquet;
	
	public PaquetCartes() {
		paquet = new ArrayList<Carte>();
		
		//lecture du fichier cartes.ods
		File lesCartes = new File("cartes.csv");
		Scanner sc = null;
		try {
			sc = new Scanner(lesCartes);
		} catch (FileNotFoundException e) {
			System.err.println("Fichier " + lesCartes.getName() + " non trouvé");
		}
		
		//on passe la première ligne
		sc.nextLine();
		//tant que le fichier a des lignes
		while(sc.hasNextLine()) {
			String ligne = sc.nextLine();
			String[] tab = ligne.split(":");
			int nbPoints = Integer.parseInt(tab[1]);
			String cat = tab[2];
			String arg = tab[3];
			Carte carte;
			
			//on crée la carte en fonction de la catégorie
			switch(cat) {
				case "qt" :
					carte = new QtCarte(nbPoints, cat, arg);
					break;
				case "comp" :
					carte = new CompCarte(nbPoints, cat, arg);
					break;
				case "egal" :
					carte = new EgalCarte(nbPoints, cat, arg);
					break;
				case "mult" :
					carte = new MultCarte(nbPoints, cat, arg);
					break;
				case "last" :
					carte = new LastCarte(nbPoints, cat, arg);
					break;
				default :
					carte = new ZeroCarte(nbPoints, cat, arg);
					break;
			}
			
			//on l'ajoute au paquet
			paquet.add(carte);
			
		}
		
		//fermeture du fichier
		sc.close();
	}
	
	@Override
	public String toString() {
		String res = "Les cartes du paquet sont : \n\n";
		for (Carte carte : paquet) {
			res += carte.toString() + "\n";
		}
		return res;
	}
	
	/**
	 * tire 6 cartes aléatoirement du paquet
	 * @return les 6 cartes
	 */
	public List<Carte> tirer() {
		List<Carte> main = new ArrayList<>();
		for (int i=0;i<6;i++) {
			//on tire un nb aléatoire entre 0 et le nb de cartes du paquet -1
			Random rand = new Random();
			//on tire cette carte
			int nbAlea = rand.nextInt(this.paquet.size());
			Carte carte = this.paquet.get(nbAlea);
			main.add(carte); //on l'ajoute à la main du joueur
			this.paquet.remove(nbAlea); //on l'enlève du paquet
		}
		return main;
	}
	
	/**
	 * réinitialise le paquet de cartes avec les cartes du fichier
	 */
	public void reinitialiser() {
		PaquetCartes paquet2 = new PaquetCartes();
		paquet.clear();
		paquet = paquet2.paquet;
	}
}
