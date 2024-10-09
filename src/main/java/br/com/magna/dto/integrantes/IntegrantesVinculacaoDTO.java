package br.com.magna.dto.integrantes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IntegrantesVinculacaoDTO (
		
		@NotNull
		Long idPessoa,
		
		@NotNull
		Long idBandas,
		
		@NotBlank
		String funcao
		
		){
	
}
