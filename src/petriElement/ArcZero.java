package petriElement;

import Error.NegParException;
import Error.NullException;

public class ArcZero extends ArcSortant {

	public ArcZero(Place p, Transition t) throws NullException, NegParException {
		super(0,p,t);
	}
	
	public boolean arcState() {
		return (this.place.getNbToken()==0);
	}
	
	public String toString() {
		return "--------Zero------->";
	}
}
