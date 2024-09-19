package br.com.magna.exceptions;

public class PessoaBadRequestException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public PessoaBadRequestException(String message) {
		super(message);
	}
}
