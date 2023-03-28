package paquetDeChips;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import cartes.Carte;
import chips.Chips;
import chips.Couleur;
import joueurs.Joueur;

public class Manche {
	private List<Chips> tousChips; //ensemble des chips
	private Chips derniere; //la dernière chips tirée
	private List<Joueur> joueurs; // les joueurs
	
	public Manche(List<Joueur> joueurs) {
		int i;
		tousChips = new ArrayList<>();
		//création de chaque chips qu'on met dans l'ensemble
		//7 chips jaunes
		for (i=0;i<7;i++) {
			Chips chips = new Chips(Couleur.JAUNE);
			tousChips.add(chips);
		}
		//6 chips oranges
		for (i=0;i<6;i++) {
			Chips chips = new Chips(Couleur.ORANGE);
			tousChips.add(chips);
		}
		//5 chips rouges
		for (i=0;i<5;i++) {
			Chips chips = new Chips(Couleur.ROUGE);
			tousChips.add(chips);
		}
		//4 chips vertes
		for (i=0;i<4;i++) {
			Chips chips = new Chips(Couleur.VERT);
			tousChips.add(chips);
		}
		//3 chips violettes
		for (i=0;i<3;i++) {
			Chips chips = new Chips(Couleur.VIOLET);
			tousChips.add(chips);
		}
		
		this.joueurs = joueurs;
	}
	
	//accesseurs
	
	public List<Chips> getTousChips() {
		return tousChips;
	}

	public Chips getDerniere() {
		return this.derniere;
	}
	
	public void setDerniere(Chips chips) {
		this.derniere = chips;
	}
	
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	
	//méthodes
	
	/**
	 * horsPaquet : true si on souhaite compter les chips qui sont hors du paquet, false sinon
	 * couleur : la couleur du chips que l'on souhaite compter
	 * compter le nombre de chips hors ou dedans paquet d'une couleur (ex : tous les chips rouges dans le paquet)
	 */
	public int getNbChips(boolean horsPaquet, Couleur couleur) {
		int nbChips = 0;
		for (Chips chips : tousChips) {
			if(chips.getCouleur() == couleur) {
				if(horsPaquet && chips.isHorsPaquet()) {
					nbChips++;
				} else if(!horsPaquet && !chips.isHorsPaquet()) {
					nbChips++;
				}
			}
		}
		return nbChips;
	}
	
	/**
	 * affiche les couleurs des chips tirées
	 * @return un string avec les couleurs
	 */
	public String afficheChipsTirees() {
		String s = "\n\nLes chips tirées sont de couleur : ";

		for (Chips chips : tousChips) {
			if(chips.isHorsPaquet()) {
				s += chips.getCouleur() + " ";
			}
		}
		s += "\n";
		
		return s;
	}

	public void etape1(Scanner sc) {
		//tirer 5 chips
		
		int nb=0;
		while (nb<5) {
			Random rand = new Random();
			int nbAlea = rand.nextInt(tousChips.size());
			Chips c = tousChips.get(nbAlea);
			if(!c.isHorsPaquet()) {
				c.setHorsPaquet(true);
				nb++;
			}
		}
		
		//pour chaque joueur, doit éliminer 2 cartes
		for(int i=0;i<this.joueurs.size();i++) {
			Joueur j = this.joueurs.get(i);
			
			//afficher les chips
			System.out.println(this.afficheChipsTirees());
			
			//affichage du joueur
			System.out.println("Tour du joueur " + j.getId());
			
			//afficher la main
			System.out.println(j.toString());
			
			System.out.println("Entrer le numéro de la première carte que vous souhaitez éliminer");
			int num = sc.nextInt();
			//vérifier que num est entre 1 et 6
			while(num<1 || num>6) {
				System.out.println("Le numéro de la carte doit être compris entre 1 et 6. Entrer-le à nouveau");
				num = sc.nextInt();
			}
			
			//supprimer la carte
			j.getMain().remove(num-1);
			
			//répéter l'opération
			System.out.println(j.toString());
			
			System.out.println("Entrer le numéro de la deuxième carte que vous souhaitez éliminer");
			num = sc.nextInt();
			//vérifier que num est entre 1 et 5
			while(num<1 || num>5) {
				System.out.println("Le numéro de la carte doit être compris entre 1 et 5. Entrer-le à nouveau");
				num = sc.nextInt();
			}
			
			j.getMain().remove(num-1);
		}
		
	}
	
	public void etape2(Scanner sc) {
		//tirer 4 chips
		
		int nb=0;
		while (nb<4) {
			Random rand = new Random();
			int nbAlea = rand.nextInt(tousChips.size());
			Chips c = tousChips.get(nbAlea);
			if(!c.isHorsPaquet()) {
				c.setHorsPaquet(true);
				nb++;
			}
		}

		//chaque joueur élimine 1 carte
		for(int i=0;i<this.joueurs.size();i++) {
			Joueur j = this.joueurs.get(i);
			
			//afficher les chips
			System.out.println(this.afficheChipsTirees());
			
			//affichage du joueur
			System.out.println("Tour du joueur " + j.getId());
			
			//afficher la main
			System.out.println(j.toString());
			
			System.out.println("Entrer le numéro de la carte que vous souhaitez éliminer");
			int num = sc.nextInt();
			//vérifier que num est entre 1 et 4
			while(num<1 || num>4) {
				System.out.println("Le numéro de la carte doit être compris entre 1 et 4. Entrer-le à nouveau");
				num = sc.nextInt();
			}
			
			//supprimer la carte
			j.getMain().remove(num-1);
		}
	}
	
	public void etape3(Scanner sc) {
		//tirer 3 chips
		int nb=0;
		while (nb<3) {
			Random rand = new Random();
			int nbAlea = rand.nextInt(tousChips.size());
			Chips c = tousChips.get(nbAlea);
			if(!c.isHorsPaquet()) {
				c.setHorsPaquet(true);
				nb++;
			}
		}
		
		//chaque joueur choisit deux cartes à mettre dans le positif
		for(int i=0;i<this.joueurs.size();i++) {
			Joueur j = this.joueurs.get(i);
			
			//afficher les chips
			System.out.println(this.afficheChipsTirees());
			
			//affichage du joueur
			System.out.println("Tour du joueur " + j.getId());
			
			//afficher la main
			System.out.println(j.toString());
			
			//choisir la première carte à droite
			System.out.println("Entrer le numéro de la première carte que vous placez à droite (= objectif réalisé)");
			int num = sc.nextInt();
			//vérifier que num est entre 1 et 3
			while(num<1 || num>3) {
				System.out.println("Le numéro de la carte doit être compris entre 1 et 3. Entrer-le à nouveau");
				num = sc.nextInt();
			}
			
			//mettre la carte en positif
			j.getMain().get(num-1).setEstPositif(true);
			
			//choisir la deuxième carte à droite
			System.out.println("Entrer le numéro de la deuxième carte que vous placez à droite (= objectif réalisé)");
			int num2 = sc.nextInt();
			//vérifier que num est entre 1 et 3 et différent de num
			while(num2<1 || num2>3 || num2 == num) {
				System.out.println("Le numéro de la carte doit être compris entre 1 et 3 et être différent de la première carte choisie. Entrer-le à nouveau");
				num2 = sc.nextInt();
			}
			
			//mettre la carte en positif
			j.getMain().get(num2-1).setEstPositif(true);
			
			//mettre l'autre carte en négatif
			for (int k = 0; k<j.getMain().size();k++) {
				Carte c = j.getMain().get(k);
				if(!c.isEstPositif()) {
					c.setEstPositif(false);
					System.out.println("La carte : \n" + c.toString() + "a été placée à gauche.");
				}
			}
		}		
	}
	
	public void etape4() {
		//tirage 2 chips
		int nb=0;
		while (nb<2) {
			Random rand = new Random();
			int nbAlea = rand.nextInt(tousChips.size());
			Chips c = tousChips.get(nbAlea);
			if(!c.isHorsPaquet()) {
				c.setHorsPaquet(true);
				nb++;
				System.out.println("Chips tirée : " + c.getCouleur());
				//on indique quelle est la dernière chips
				if(nb==2) {
					derniere = c;
				}
			}
		}

		//afficher les chips
		System.out.println(this.afficheChipsTirees());
		
		//pour chaque joueur, on calcule le score
		int score;
		int[] scores = new int[this.joueurs.size()];
		for(int i=0;i<this.joueurs.size();i++) {
			Joueur j = this.joueurs.get(i);
			score = j.calculerScore(this);
			System.out.println("Le score du joueur " + j.getId() + " est : " + score + " points");
			scores[i] = score;
		}		
		
		//trouver le premier, deuxième joueur et troisième joueur
		int premier = Manche.maxTab(scores);
		int scPremier = scores[premier];
		scores[premier] = -1000;
		int deuxieme = Manche.maxTab(scores);
		int scDeuxieme = scores[deuxieme];
		scores[deuxieme] = -1000;
		int troisieme = 0;
		if(this.joueurs.size()>2) {
			troisieme = Manche.maxTab(scores);
		}
		
		//on donne des jetons aux joueurs
		//si partie à 2 joueurs
		if(this.joueurs.size()<=2) {
			//si égalité
			if(scPremier == scDeuxieme) {
				this.joueurs.get(premier).setNbJetons(this.joueurs.get(premier).getNbJetons()+1); //1 jeton pour le premier
				this.joueurs.get(deuxieme).setNbJetons(this.joueurs.get(deuxieme).getNbJetons()+1);  //et 1 pour l'autre premier
			} else {
				this.joueurs.get(premier).setNbJetons(this.joueurs.get(premier).getNbJetons()+1); //1 jeton pour le premier
			}
		//sinon
		}else {
			//si égalité entre premiers
			if(scPremier == scDeuxieme) {
				this.joueurs.get(premier).setNbJetons(this.joueurs.get(premier).getNbJetons()+2); //2 jetons pour le premier
				this.joueurs.get(deuxieme).setNbJetons(this.joueurs.get(deuxieme).getNbJetons()+2);  //2 pour l'autre premier et 0 pour les autres
				//si égalité entre deuxièmes
			} else if(scores[troisieme] == scDeuxieme){
				this.joueurs.get(premier).setNbJetons(this.joueurs.get(premier).getNbJetons()+2); //2 jetons pour le premier
				this.joueurs.get(deuxieme).setNbJetons(this.joueurs.get(deuxieme).getNbJetons()+1);//1 jeton pour le deuxième
				this.joueurs.get(troisieme).setNbJetons(this.joueurs.get(troisieme).getNbJetons()+1); //et 1 jeton pour l'autre deuxième
			} else {
				this.joueurs.get(premier).setNbJetons(this.joueurs.get(premier).getNbJetons()+2); //2 jetons pour le premier
				this.joueurs.get(deuxieme).setNbJetons(this.joueurs.get(deuxieme).getNbJetons()+1);  //et 1 pour le 2eme
			}
		}
	}
	
	/**
	 * déroule une manche avec ses 4 étapes
	 */
	public void derouler(Scanner sc) {
		this.etape1(sc);
		this.etape2(sc);
		this.etape3(sc);
		this.etape4();	
	}
	
	public void reinitialiser() {
		Manche m = new Manche(this.joueurs);
		tousChips = m.getTousChips();
		derniere = null;
	}
	
	/**
	 * 
	 * @param scores tableau d'entiers
	 * @return le plus grand du tableau
	 */
	public static int maxTab(int[] scores) {
		int max = 0;
		for (int i=0; i<scores.length;i++) {
			if(scores[i] > scores[max]) {
				max = i;
			}
		}
		return max;
	}
}
