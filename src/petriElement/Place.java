package petriElement;

public class Place {
	
	private int nbToken;
	
	public Place(int n) {
		this.nbToken=n;
	}
	
	public int getNbToken() {
		return this.nbToken;
	}
	
	public void substractToken(int n) {
		this.nbToken-=n;
	}
	
	public void addToken(int n) {
		this.nbToken+=n;
	}
	
	
	
	
	
	
	
	
}
