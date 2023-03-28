package chips;

public class Chips {
	private boolean horsPaquet;
	private Couleur couleur;
	
	//constructeur
	
	public Chips(Couleur couleur) {
		this.couleur = couleur;
		//une chips est toujours dans le paquet au début
		horsPaquet = false;
	}
	
	//accesseurs
	
	public boolean isHorsPaquet() {
		return this.horsPaquet;
	}
	
	public void setHorsPaquet(boolean estHorsPaquet) {
		this.horsPaquet = estHorsPaquet;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
}
