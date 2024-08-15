package br.com.magna.dto.pessoa;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public record PessoasCadastroDTO(
		
		@NotBlank(message = "O nome não pode estar vazio")
		String nome,
		
		@NotBlank(message = "O email não pode estar vazio")
		@Email(message = "O email não está no formato correto")
		String email, 
		
		@PastOrPresent(message = "A data de nascimento não deve ser futura ou presente")
		//@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate dataNascimento, 
		
		@NotBlank(message = "O país de nascimento não pode estar vazio")
		String paisNascimento) {
	
	

}
