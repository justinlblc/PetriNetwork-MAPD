package petriElement;

public class ArcEntrant {
	
	private int weight;
	private Place place;
	
	public ArcEntrant(int n, Place p) {
		this.weight=n;
		this.place=p;
	}
	
	public void add() {
		this.place.substractToken(this.weight);
	}
}
