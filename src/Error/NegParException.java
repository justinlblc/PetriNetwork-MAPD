package Error;

public class NegParException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NegParException(String s){
		super(s + " can not be negative");
	}
}
