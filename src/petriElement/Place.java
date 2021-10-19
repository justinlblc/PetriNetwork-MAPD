package petriElement;

import Error.NegParException;

// TODO: Auto-generated Javadoc
/**
 * The Class Place.
 */
public class Place {
	
	/** The nb. */
	private static int nb;
	
	/** The name. */
	private String name;
	
	/** The nb token. */
	private int nbToken;
	
	/**
	 * Instantiates a new place.
	 *
	 * @param n the number of token
	 * @throws NegParException the given number of token is negative
	 */
	public Place(int n) throws NegParException {
		
		
		if (n<0) {
			throw new NegParException("Nb of token");
		}
		this.nbToken=n;
		this.name="P"+nb;
		nb++;
	}

	
	/**
	 * Gets the nb token.
	 *
	 * @return the nb token
	 */
	public int getNbToken() {
		return this.nbToken;
	}
	
	/**
	 * Substract n token from the initial number of token.
	 *
	 * @param n the number of token to substract
	 */
	public void substractToken(int n) {
		this.nbToken-=n;
	}
	
	/**
	 * Adds token.
	 *
	 * @param n the number of token to add
	 */
	public void addToken(int n) {
		this.nbToken+=n;
	}
	
	/**
	 * Reset name generator
	 */
	public static void reset() {
		nb = 0;
	}
	
	/**
	 * Sets the number of token.
	 *
	 * @param n the new nb token
	 * @throws NegParException the neg par exception
	 */
	public void setNbToken(int n) throws NegParException{
		if (n<0) {
			throw new NegParException("Nb token");
		
		}
		nbToken=n;
	}
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return this.name + " : "+nbToken;
	}
	
	
	
	
	
	
	
}
