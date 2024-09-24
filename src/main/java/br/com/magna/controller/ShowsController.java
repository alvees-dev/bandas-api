package br.com.magna.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<ShowsRetornoDTO> Show(@RequestBody @Valid ShowsAgendaDTO dados) {

		var agendarShow = service.agendarShow(dados);
		return ResponseEntity.status(HttpStatus.CREATED).body(agendarShow);
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

}
