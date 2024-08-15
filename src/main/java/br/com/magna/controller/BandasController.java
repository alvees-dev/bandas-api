package br.com.magna.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.banda.BandaAtualizacaoDTO;
import br.com.magna.dto.banda.BandasCadastroDTO;
import br.com.magna.dto.banda.BandasRetornoDTO;
import br.com.magna.service.BandasService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("bandas")
public class BandasController {
	
	private final BandasService service;
	
	public BandasController(BandasService service) {
		this.service = service;
	}


	@PostMapping
	@Transactional
	public ResponseEntity<BandasRetornoDTO> cadastroBandas(@RequestBody @Valid BandasCadastroDTO dados) {
		
		var banda = service.createBanda(dados);
		return ResponseEntity.status(HttpStatus.CREATED).body(banda);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<JsonResponse> deletarBandas(@PathVariable Long id) {
		
		var delete = service.deleteBanda(id);
		return ResponseEntity.status(HttpStatus.OK).body(delete);
		
	}
	
	@PutMapping("/atualizarBanda/{id}")
	public ResponseEntity<BandasRetornoDTO> atualizarBanda(@PathVariable Long id, @RequestBody @Valid BandaAtualizacaoDTO dados) {
		var banda = service.atualizarBandas(id, dados);
		return ResponseEntity.status(HttpStatus.OK).body(banda);
		
		
	}
	

}
