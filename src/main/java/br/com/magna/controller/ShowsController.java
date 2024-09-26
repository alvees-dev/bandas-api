package br.com.magna.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.shows.ShowsAgendaDTO;
import br.com.magna.dto.shows.ShowsAtualizacaoDTO;
import br.com.magna.dto.shows.ShowsRetornoDTO;
import br.com.magna.service.ShowsService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("shows")
public class ShowsController {

	private final ShowsService service;

	public ShowsController(ShowsService service) {
		this.service = service;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ShowsRetornoDTO> agendamentoDeShow(@RequestBody @Valid ShowsAgendaDTO dados) {
		var agendaShow = service.agendarShow(dados);
		return ResponseEntity.status(HttpStatus.CREATED).body(agendaShow);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<JsonResponse> deleteShow(@PathVariable Long id) {
		service.deleteShows(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/atualizarshows/{id}")
	@Transactional
	public ResponseEntity<ShowsRetornoDTO> updateShow(@PathVariable Long id, @RequestBody @Valid ShowsAtualizacaoDTO dados) {
		var shows = service.updateShow(id, dados);
		return ResponseEntity.status(HttpStatus.OK).body(shows);
	}
	
	@GetMapping
	public ResponseEntity<List<ShowsRetornoDTO>> getShow() {
		return ResponseEntity.ok(service.findShows());	
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<ShowsRetornoDTO> getShowById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findShowById(id));
	}
	
	@GetMapping("nome/{nome}")
	public ResponseEntity<ShowsRetornoDTO> getShowByNome(@PathVariable String nome) {
		return ResponseEntity.ok(service.findShowByNome(nome));
	}
	

}
