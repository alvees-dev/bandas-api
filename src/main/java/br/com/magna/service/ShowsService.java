package br.com.magna.service;

import org.springframework.stereotype.Service;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.shows.ShowsAgendaDTO;
import br.com.magna.dto.shows.ShowsAtualizacaoDTO;
import br.com.magna.dto.shows.ShowsRetornoDTO;
import br.com.magna.exceptions.ShowNotFoundException;
import br.com.magna.model.Shows;
import br.com.magna.repository.ShowsRepository;

@Service
public class ShowsService {
	
	private final Shows shows;
	private final ShowsRepository repository;

	public ShowsService(ShowsRepository repository) {
		this.shows = new Shows();
		this.repository = repository;
	}
	
	public ShowsRetornoDTO agendarShow(ShowsAgendaDTO dados) {
		Shows shows = new Shows(dados);
		repository.save(shows);
		return new ShowsRetornoDTO(shows);
	}
	
	public JsonResponse deleteShows(Long id) {
		repository.deleteById(id);
		return new JsonResponse("O Show com a Id" + id + "foi deletado com sucesso");
	}

	public ShowsRetornoDTO updateShow(Long id, ShowsAtualizacaoDTO dados) {
		
		var show = repository.findById(id)
				.orElseThrow(() -> new ShowNotFoundException("Não foi encontrado Show com a Id digitada"));
		shows.atualizacaoShows(dados);
		
		return new ShowsRetornoDTO(shows);
	}
	
	
}
