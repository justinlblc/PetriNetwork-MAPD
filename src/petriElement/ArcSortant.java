package petriElement;

import Error.NegParException;
import Error.NullException;

public class ArcSortant {
	
	protected int weight;
	protected Place place;
	protected Transition transition;
	
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
	public int getWeight() {
		return weight;
	}
	public Place getPlace() {
		return place;
	}
	
	public Transition getTransition() {
		return transition;
	}
	
	
	public void substract () {
		this.place.substractToken(this.weight);
	}
	
	public boolean arcState() {
		return this.place.getNbToken()>=this.weight;
	}
	

	
	public String toString() {
		return "-------"+weight+"------>";
	}
	
}