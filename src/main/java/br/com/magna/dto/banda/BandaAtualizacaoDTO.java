package br.com.magna.dto.banda;

import java.time.LocalDate;

import jakarta.validation.constraints.PastOrPresent;

public record BandaAtualizacaoDTO (
	
	Long id,
	String nome,
	String generoMusical,
	
	@PastOrPresent
	LocalDate dataCriacao,
	String paisOrigem

		) {
	
}
