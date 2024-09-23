package br.com.magna.dto.shows;

import java.time.LocalDate;

import br.com.magna.dto.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShowsAgendaDTO (
		
		@NotBlank(message = "O nome do show/turnê deve ser informado")
		String nome,
		
		@NotBlank
		@Future(message = "A data não pode ser passado ou presente")
		LocalDate dataInicio,
		
		@NotBlank
		@Future(message = "A data de término não pode ser passado ou presente")
		LocalDate dataTermino,
		
		@NotNull
		@Valid
		DadosEndereco endereco
		){

}
