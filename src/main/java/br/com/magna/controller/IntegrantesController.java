package br.com.magna.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.integrantes.IntegrantesRetornoDTO;
import br.com.magna.dto.integrantes.IntegrantesVinculacaoDTO;
import br.com.magna.service.IntegrantesService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/integrantes")
public class IntegrantesController {

	private final IntegrantesService integranteService;

	public IntegrantesController(IntegrantesService service) {
		this.integranteService = service;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<IntegrantesRetornoDTO> vincularIntegrantes(
			@RequestBody @Valid IntegrantesVinculacaoDTO dados) {
		var dto = integranteService.vincularIntegrante(dados);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping("{/id}")
	@Transactional
	public ResponseEntity<JsonResponse> deleteMemberVinculation(@PathVariable Long id) {
		integranteService.deletarVinculacaoIntegrante(id);
		return ResponseEntity.ok().build();
	}
}
