package br.com.magna.exceptions;

public class DataTerminoAntesDataInicio extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DataTerminoAntesDataInicio(String message) {
		super(message);
	}

}
