package br.com.magna.dto.showBanda;

import jakarta.validation.constraints.NotNull;

public record ShowBandaVinculacaoDTO(
		
		@NotNull
		Long idBandas,
		
		@NotNull
		Long idShows) {

}
