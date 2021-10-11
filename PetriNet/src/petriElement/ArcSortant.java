package petriElement;

public class ArcSortant {
	
	protected int weight;
	protected Place place;
	
	public ArcSortant(int n, Place p) {
		this.weight=n;
		this.place=p;
	}
	
	public void substract () {
		this.place.substractToken(this.weight);
	}
	
	public boolean arcState() {
		return this.place.getNbToken()>=this.weight;
	}
	
	public void setWeight(int n) {
		this.weight=n;
	}
	
}