package Error;

public class NullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NullException(String varName) {
		super(varName+" can not be null");
	}
	

}
