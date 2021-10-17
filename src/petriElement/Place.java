package petriElement;

import Error.NegParException;

public class Place {
	private static int nb;
	private String name;
	private int nbToken;
	
	public Place(int n) throws NegParException {
		if (n<0) {
			throw new NegParException("Nb of token");
		}
		this.nbToken=n;
		this.name="P"+nb;
		nb++;
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
	
	public String toString() {
		return this.name + " : "+nbToken;
	}
	
	
	
	
	
	
	
}
