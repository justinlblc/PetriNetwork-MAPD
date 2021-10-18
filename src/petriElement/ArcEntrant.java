package petriElement;

import Error.NegParException;
import Error.NullException;

public class ArcEntrant {
	
	private int weight;
	private Place place;
	private Transition transition;
	
	
	public ArcEntrant(int n, Place p, Transition t) throws NullException, NegParException {
		if (n<0) {
			throw new NegParException("Arc weight");
		}
		if (p == null) {
			throw new NullException("Place");
		}
		if (t==null) {
			throw new NullException("Transition");
		}
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
	
	public String toString() {
		return  transition.toString()+" -------"+weight+"------> " + place.toString();
	}
}
