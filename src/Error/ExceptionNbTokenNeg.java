package Error;

public class ExceptionNbTokenNeg extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExceptionNbTokenNeg(){
		super("The number of token is negative");
	}
}
