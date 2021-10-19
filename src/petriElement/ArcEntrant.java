package petriElement;

import Error.NegParException;
import Error.NullException;

// TODO: Auto-generated Javadoc
/**
 * The Class ArcEntrant.
 */
public class ArcEntrant {
	
	/** The weight. */
	private int weight;
	
	/** The place. */
	private Place place;
	
	/** The transition. */
	private Transition transition;
	
	
	/**
	 * Instantiates a new arc entrant between a place and a transition.
	 *
	 * @param n the weight
	 * @param p the place
	 * @param t the transition
	 * @throws NullException Place or Transition given is null
	 * @throws NegParException Weight given is negative
	 */
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
	
	/**
	 * Sets the weight.
	 *
	 * @param n the new weight
	 * @throws NegParException Weight given is negative
	 */
	public void setWeight(int n) throws NegParException {
		if (n<0) {
			throw new NegParException("Wight");
		}
		weight=n;
	}
	
	
	/**
	 * Gets the transition.
	 *
	 * @return the transition
	 */
	public Transition getTransition() {
		return transition;
	}
	
	/**
	 * Gets the place.
	 *
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}
	
	/**
	 * Adds weight to the number of token of the place linked to.
	 */
	// Ajoute le poids de l'arc au nombre de jeton de la place associée
	public void add() {
		this.place.addToken(this.weight);
	}
	
	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	public boolean equals(Object o) {
		if (o!= null || (o instanceof ArcEntrant)) {
			ArcEntrant ae = (ArcEntrant)o;
			return this.transition==ae.transition && this.place==ae.place;
		}
		return false;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return  transition.toString()+" -------"+weight+"------> " + place.toString();
	}
}
