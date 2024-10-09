package br.com.magna.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.integrantes.IntegrantesRetornoDTO;
import br.com.magna.dto.integrantes.IntegrantesVinculacaoDTO;
import br.com.magna.service.IntegrantesService;
import jakarta.validation.Valid;

@RestController
public class IntegrantesController {

	private final IntegrantesService service;
	
	public IntegrantesController(IntegrantesService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<IntegrantesRetornoDTO> vincularIntegrantes(@RequestBody @Valid IntegrantesVinculacaoDTO dados) {
		var dto = service.vincularIntegrante(dados);
		return ResponseEntity.ok(dto);
		
	}
}
