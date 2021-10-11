package petriElement;

public class ArcVideur extends ArcSortant {
	
	public ArcVideur(Place p) {
		super(0, p);
	}
	
	public boolean arcState() {
		if (this.place.getNbToken()<1) {
			return false;
		}
		this.weight=this.place.getNbToken();
		return true;
	}
}
