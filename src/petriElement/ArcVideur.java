package petriElement;

public class ArcVideur extends ArcSortant {
	
	public ArcVideur(Place p, Transition t) {
		super(0, p, t);
	}
	
	public boolean arcState() {
		if (this.place.getNbToken()<1) {
			return false;
		}
		this.weight=this.place.getNbToken();
		return true;
	}
}
