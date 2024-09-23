package br.com.magna.dto.shows;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.magna.dto.endereco.Endereco;
import br.com.magna.model.Shows;

public record ShowsRetornoDTO(

		Long id, String nome,

		@JsonFormat(pattern = "dd-mm-yyyy") LocalDate dataInicio,
		@JsonFormat(pattern = "dd-mm-yyyy") LocalDate dataTermino, Endereco endereco

) {

	public ShowsRetornoDTO(Shows shows) {
		this(shows.getId(), 
			 shows.getNome(), 
			 shows.getDataInicio(), 
			 shows.getDataTermino(), 
			 shows.getEndereco());
	}

}