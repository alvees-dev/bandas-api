package br.com.magna.dto.shows;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record ShowsAgendaDTO (
		
		@NotBlank(message = "O nome do show/turnê deve ser informado")
		String nome,
		
		@NotBlank
		@Future(message = "A data não pode ser passado ou presente")
		LocalDate dataInicio,
		
		@NotBlank
		@Future(message = "A data de término não pode ser passado ou presente")
		LocalDate dataTermino
		
//		@NotNull
//		@Valid
//		DadosEndereco endereco
		){

}
