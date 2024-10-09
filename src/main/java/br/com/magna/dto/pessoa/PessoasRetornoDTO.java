package br.com.magna.dto.pessoa;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.magna.model.Pessoas;

public record PessoasRetornoDTO(
		
		Long id,
		String nome, 
		String email, 
		
		@JsonFormat(pattern = "dd/MM/yyyy")
		LocalDate dataNascimento, 
		String paisNascimento)
		
		 {
	
	 public PessoasRetornoDTO(Pessoas pessoas) {
		 this(pessoas.getIdPessoa(),
		      pessoas.getNome(),
		      pessoas.getEmail(),
		      pessoas.getDataNascimento(),
		      pessoas.getPaisNascimento());
	 }

}
