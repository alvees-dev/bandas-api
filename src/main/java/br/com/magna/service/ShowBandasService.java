package br.com.magna.service;

import org.springframework.stereotype.Service;

import br.com.magna.dto.showBanda.ShowBandaRetornoDTO;
import br.com.magna.dto.showBanda.ShowBandaVinculacaoDTO;
import br.com.magna.infra.exceptions.BandaNotFoundException;
import br.com.magna.infra.exceptions.ShowNotFoundException;
import br.com.magna.model.ShowBandas;
import br.com.magna.repository.BandasRepository;
import br.com.magna.repository.ShowBandaRepository;
import br.com.magna.repository.ShowsRepository;

@Service
public class ShowBandasService {

	private BandasRepository bandaRepository;
	private ShowsRepository showRepository;
	private ShowBandaRepository showBandaRepository;

	public ShowBandasService(BandasRepository bandaRepo, ShowsRepository showRepo, ShowBandaRepository showBandaRepo) {
		this.bandaRepository = bandaRepo;
		this.showRepository = showRepo;
		this.showBandaRepository = showBandaRepo;
	}
	
	public ShowBandaRetornoDTO vincularShowsBandas(ShowBandaVinculacaoDTO dados) {
		
		var optionalShow = showRepository.findById(dados.idShows());
	    if (optionalShow.isEmpty()) {
	        throw new ShowNotFoundException("Show não encontrado");
	    }
	    
	    var optionalBanda = bandaRepository.findById(dados.idBandas());
	    if (optionalBanda.isEmpty()) {
	        throw new BandaNotFoundException("Banda não encontrada");
	    }
	    
	    var show = optionalShow.get();
	    var banda = optionalBanda.get();
	    var showBanda = new ShowBandas(null, show, banda);
	    showBandaRepository.save(showBanda);
	    
	    return new ShowBandaRetornoDTO(showBanda);
 	}

}
