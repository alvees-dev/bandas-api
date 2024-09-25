package br.com.magna.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.shows.ShowsAgendaDTO;
import br.com.magna.dto.shows.ShowsAtualizacaoDTO;
import br.com.magna.dto.shows.ShowsRetornoDTO;
import br.com.magna.exceptions.BandaNotFoundException;
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
		
		return new ShowsRetornoDTO(show);
	}
	
	public List<ShowsRetornoDTO> findShows() {
		var shows = repository.findAll();
		List<ShowsRetornoDTO> listShows = new ArrayList<>();
		if(!listShows.isEmpty()) {
			for(Shows show : shows) {
				ShowsRetornoDTO dto = new ShowsRetornoDTO(show);
				listShows.add(dto);
			}
			return listShows;
		}
		throw new ShowNotFoundException("Não foram encontrados Shows disponíveis");
	}
	
	public ShowsRetornoDTO findShowById(Long id) {
		Optional<Shows> showsOptional = repository.findById(id);
		if (showsOptional.isPresent()) {
			Shows shows = showsOptional.get();
			return new ShowsRetornoDTO(shows);
		}
		throw new BandaNotFoundException("Não foi encontrado show com a ID digitada");
	}

	public ShowsRetornoDTO findShowByNome(String nome) {
		Optional<Shows> showsOptional = repository.findShowByNome(nome);
		if (showsOptional.isPresent()) {
			Shows shows = showsOptional.get();
			return new ShowsRetornoDTO(shows);
		}
		throw new BandaNotFoundException("Não foi encontrado show com o nome digitado");
	}
	
	
}
