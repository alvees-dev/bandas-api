package br.com.magna.dto.shows;

import java.time.LocalDate;

import br.com.magna.dto.endereco.DadosEndereco;

public record ShowsAtualizacaoDTO(
		
		Long id,
		String nome,
		LocalDate dataInicio,
		LocalDate dataTermino,
		DadosEndereco endereco
		
		
		) {

}
