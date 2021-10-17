package petriElement;

import Error.NegParException;
import Error.NullException;

public class ArcVideur extends ArcSortant {
	
	public ArcVideur(Place p, Transition t) throws NullException, NegParException{
		super(0, p, t);
		
	}
	
	public boolean arcState() {
		if (this.place.getNbToken()==0) {
			return false;
		}
		this.weight=this.place.getNbToken();
		return true;
	}
	
	public String toString() {
		return place.toString()+" -------Videur------> " + transition.toString();
	}
}
