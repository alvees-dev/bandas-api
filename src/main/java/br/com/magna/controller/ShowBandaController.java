package br.com.magna.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.showBanda.ShowBandaRetornoDTO;
import br.com.magna.dto.showBanda.ShowBandaVinculacaoDTO;
import br.com.magna.service.ShowBandasService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/showBandas")
public class ShowBandaController {

	private ShowBandasService showBandaService;

	public ShowBandaController(ShowBandasService service) {
		this.showBandaService = service;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ShowBandaRetornoDTO> vincularShowBanda(@RequestBody @Valid ShowBandaVinculacaoDTO dados) {
		var dto = showBandaService.vincularShowsBandas(dados);
		return ResponseEntity.ok(dto);
	}

	@DeleteMapping("{/id}")
	@Transactional
	public ResponseEntity<JsonResponse> deleteMemberVinculation(@PathVariable Long id) {
		showBandaService.cancelShowVinculation(id);
		return ResponseEntity.ok().build();
	}

}
