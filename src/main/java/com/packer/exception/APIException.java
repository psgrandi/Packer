package com.packer.exception;

/**
 * Exception that is thrown when there's incorrect parameters and/or during pack processing.  
 * @author psilveira
 *
 */
public class APIException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;
	
	public APIException(String message) {
		super(message);
	}
	
	public APIException(String message, Throwable cause) {
		super(message, cause);
	}

}
