package br.com.magna.infra.exceptions;

public class ShowNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ShowNotFoundException(String message) {
		super(message);
	}

}
