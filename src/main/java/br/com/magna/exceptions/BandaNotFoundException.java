package br.com.magna.exceptions;

public class BandaNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public BandaNotFoundException(String message) {
		super(message);
	}
			

}
