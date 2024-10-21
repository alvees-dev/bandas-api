package br.com.magna.infra.exceptions;

public class DataTerminoAntesDataInicio extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DataTerminoAntesDataInicio(String message) {
		super(message);
	}

}
