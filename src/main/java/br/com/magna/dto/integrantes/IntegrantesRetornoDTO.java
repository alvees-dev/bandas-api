package br.com.magna.dto.integrantes;

import br.com.magna.model.Integrantes;

public record IntegrantesRetornoDTO(
		
		Long id,
		Long idPessoa,
		Long idBandas,
		String funcao
		) {
	
	public IntegrantesRetornoDTO (Integrantes integrantes	) {
		this(integrantes.getIdIntegrantes(),
			 integrantes.getIdPessoa().getIdPessoa(),
			 integrantes.getIdBanda().getIdBandas(),
			 integrantes.getFuncao());
	}

}
