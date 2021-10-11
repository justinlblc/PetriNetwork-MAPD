package petriElement;

public class ArcZero extends ArcSortant {

	public ArcZero(Place p) {
		super(0,p);
	}
	
	public boolean arcState() {
		return (this.place.getNbToken()==0);
	}
}
