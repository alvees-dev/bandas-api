package br.com.magna.exceptions;

public class BandaBadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public BandaBadRequestException(String message) {
		super(message);
	}

}
