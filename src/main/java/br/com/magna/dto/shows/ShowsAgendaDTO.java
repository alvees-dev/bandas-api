package br.com.magna.dto.shows;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShowsAgendaDTO (
		
		@NotBlank(message = "O nome do show/turnê deve ser informado")
		String nome,
		
		@NotNull
		@Future(message = "A data não pode ser passado ou presente")
		LocalDate dataInicio,
		
		@NotNull
		@Future(message = "A data de término não pode ser passado ou presente")
		LocalDate dataTermino,
		
		@NotBlank(message = "O endereço não pode estar vazio")
		String endereco
		){

}
