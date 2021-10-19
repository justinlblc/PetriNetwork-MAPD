package petriElement;

import Error.NegParException;
import Error.NullException;

// TODO: Auto-generated Javadoc
/**
 * The Class ArcSortant.
 */
public class ArcSortant {
	
	/** The weight. */
	protected int weight;
	
	/** The place. */
	protected Place place;
	
	/** The transition. */
	protected Transition transition;
	
	/**
	 * Instantiates a new arc sortant which links a place and a transition.
	 *
	 * @param n the weight
	 * @param p the place
	 * @param t the transition
	 * @throws NullException Place or Transition given is null
	 * @throws NegParException Weight given is negative
	 */
	public ArcSortant(int n, Place p, Transition t) throws NullException, NegParException {
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
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
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
	 * Gets the place.
	 *
	 * @return the place
	 */
	public Place getPlace() {
		return place;
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
	 * Substract weight to the number of token of the place linked to.
	 */
	public void substract () {
		this.place.substractToken(this.weight);
	}
	
	/**
	 * Arc state.
	 *
	 * @return true, if successful
	 */
	public boolean arcState() {
		return this.place.getNbToken()>=this.weight;
	}
	
	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	public boolean equals(Object o) {
		if (o!= null || (o instanceof ArcSortant)) {
			ArcSortant as = (ArcSortant)o;
			return this.transition==as.transition && this.place==as.place;
		}
		return false;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return place.toString()+  " -------"+weight+"------> "+transition.toString();
	}
	
}