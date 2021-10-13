package petriElement;

public class ArcZero extends ArcSortant {

	public ArcZero(Place p, Transition t) {
		super(0,p,t);
	}
	
	public boolean arcState() {
		return (this.place.getNbToken()==0);
	}
}
