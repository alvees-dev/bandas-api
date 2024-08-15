package br.com.magna.dto.pessoa;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;

public record PessoasAtualizacaoDTO(
			
		Long id,
		String nome,
		
		@Email
		String email,
		
		@PastOrPresent
		LocalDate dataNascimento,
		String paisNascimento
		) {

}
