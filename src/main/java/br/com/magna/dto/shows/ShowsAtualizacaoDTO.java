package br.com.magna.dto.shows;

import java.time.LocalDate;

public record ShowsAtualizacaoDTO(
		
		Long id,
		String nome,
		LocalDate dataInicio,
		LocalDate dataTermino,
		String endereco
		
		
		) {

}
