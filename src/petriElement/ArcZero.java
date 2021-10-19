package petriElement;

import Error.NegParException;
import Error.NullException;

// TODO: Auto-generated Javadoc
/**
 * The Class ArcZero.
 */
public class ArcZero extends ArcSortant {

	/**
	 * Instantiates a new arc zero between a place and a transition.
	 *
	 * @param p the place
	 * @param t the transition
	 * @throws NullException Place or Transition given is null
	 * @throws NegParException Weight given is negative
	 */
	public ArcZero(Place p, Transition t) throws NullException, NegParException {
		super(0,p,t);
	}
	
	/**
	 * Arc state.
	 *
	 * @return true, if successful
	 */
	public boolean arcState() {
		return (this.place.getNbToken()==0);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return place.toString()+  " --------Zero-------> " + transition.toString();
	}
}
