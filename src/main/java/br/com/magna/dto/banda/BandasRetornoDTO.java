package br.com.magna.dto.banda;

import java.time.LocalDate;

import br.com.magna.model.Bandas;

public record BandasRetornoDTO(

		Long id, 
		String nome, 
		String generoMusical, 
		LocalDate dataCriacao, 
		String paisOrigem) {
	
	public BandasRetornoDTO(Bandas bandas) {
		this(bandas.getId(), 
			 bandas.getNome(), 
			 bandas.getGeneroMusical(), 
			 bandas.getDataCriacao(), 
			 bandas.getPaisOrigem());
	}

}