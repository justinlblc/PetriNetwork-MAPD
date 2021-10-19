package petriElement;

import Error.NegParException;
import Error.NullException;

// TODO: Auto-generated Javadoc
/**
 * The Class ArcVideur.
 */
public class ArcVideur extends ArcSortant {
	
	/**
	 * Instantiates a new arc videur between a given place and a given transition.
	 *
	 * @param p the place
	 * @param t the transition
	 * @throws NullException Place or Transition given is null
	 * @throws NegParException Weight given is negative
	 */
	public ArcVideur(Place p, Transition t) throws NullException, NegParException{
		super(0, p, t);
		
	}
	
	/**
	 * Give the arc state.
	 *
	 * @return true, if successful
	 */
	public boolean arcState() {
		if (this.place.getNbToken()==0) {
			return false;
		}
		this.weight=this.place.getNbToken();
		return true;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return place.toString()+" -------Videur------> " + transition.toString();
	}
}
