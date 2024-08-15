package br.com.magna.dto.banda;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public record BandasCadastroDTO(
		
		@NotBlank(message = "O nome não pode estar vazio")
		String nome,
		
		@NotBlank(message = "O genero musical deve ser informado")
		String generoMusical,
		
		@PastOrPresent(message = "A data de criação não deve ser futura")
		//@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate dataCriacao,
		
		@NotBlank(message = "O país de origem deve ser informado")
		String paisOrigem) {

}
