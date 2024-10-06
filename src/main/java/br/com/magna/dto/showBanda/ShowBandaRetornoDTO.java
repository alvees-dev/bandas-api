package br.com.magna.dto.showBanda;

import br.com.magna.model.ShowBandas;

public record ShowBandaRetornoDTO(
		
		Long id,
		Long idShow,
		Long idBanda) {
	
	public ShowBandaRetornoDTO(ShowBandas showBanda) {
		this(showBanda.getId(),
			 showBanda.getShow().getIdShows(),
			 showBanda.getBanda().getIdBandas());
	}

}
