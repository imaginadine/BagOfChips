package chips;

public enum Couleur {
	//couleurs possibles des chips
	JAUNE, ORANGE, ROUGE, VERT, VIOLET;
	
	public static Couleur stringToCouleur(String s) {
		Couleur c;
		switch (s) {
			case "jaune" :
				c = Couleur.JAUNE;
				break;
			case "orange" :
				c = Couleur.ORANGE;
				break;
			case "rouge" :
				c = Couleur.ROUGE;
				break;
			case "vert" : 
				c = Couleur.VERT;
				break;
			default :
				c = Couleur.VIOLET;
				break;
		}
		return c;
	}
}
