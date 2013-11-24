package com.dev.uva.prv.commun;

/**
 * Classe personnalisée de gestion des exception de PRV.
 * @author bafal
 * @version PRV v.1 
 */
public class PrvException extends Throwable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public PrvException() {
		super("");
	}

	public PrvException(String message) {
		super(message);
	}

	public PrvException(Throwable throwable) {
		super(throwable);
	}

	public PrvException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
