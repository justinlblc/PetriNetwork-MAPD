package petriElement;

public class ArcEntrant {
	
	private int weight;
	private Place place;
	private Transition transition;
	
	// Créer une instance d'ArcEntrant en initialisant son poids et la place vers laquelle elle pointe 
	public ArcEntrant(int n, Place p, Transition t) {
		this.weight=n;
		this.place=p;
		this.transition = t;
	}
	
	public Transition getTransition() {
		return transition;
	}
	
	public Place getPlace() {
		return place;
	}
	// Ajoute le poids de l'arc au nombre de jeton de la place associée
	public void add() {
		this.place.addToken(this.weight);
	}
}
