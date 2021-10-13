package petriElement;

public class ArcSortant {
	
	protected int weight;
	protected Place place;
	protected Transition transition;
	
	public ArcSortant(int n, Place p, Transition t) {
		this.weight=n;
		this.place=p;
		this.transition = t;
	}
	
	public Place getPlace() {
		return place;
	}
	
	public Transition getTransition() {
		return transition;
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