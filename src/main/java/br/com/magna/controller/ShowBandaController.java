package br.com.magna.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.showBanda.ShowBandaRetornoDTO;
import br.com.magna.dto.showBanda.ShowBandaVinculacaoDTO;
import br.com.magna.service.ShowBandasService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/showBandas")
public class ShowBandaController {
	
	private ShowBandasService service;
	
	public ShowBandaController (ShowBandasService service) {
		this.service = service;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ShowBandaRetornoDTO> vincularShowBanda(@RequestBody @Valid ShowBandaVinculacaoDTO dados) {
		var dto = service.vincularShowsBandas(dados);
		return ResponseEntity.ok(dto);
	}

}
