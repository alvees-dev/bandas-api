package br.com.magna.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.pessoa.PessoasAtualizacaoDTO;
import br.com.magna.dto.pessoa.PessoasCadastroDTO;
import br.com.magna.dto.pessoa.PessoasRetornoDTO;
import br.com.magna.service.PessoasService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pessoas")
public class PessoasController {

	private final PessoasService service;

	public PessoasController(PessoasService service) {
		this.service = service;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PessoasRetornoDTO> cadastrarPessoa(@RequestBody @Valid PessoasCadastroDTO dados) {
		var dto = service.createPessoa(dados);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<JsonResponse> deletarPessoa(@PathVariable Long id) {
		service.deletePessoa(id);
		return ResponseEntity.noContent().build();

	}
	
	@PutMapping("/atualizarPessoa/{id}")
	@Transactional
	public ResponseEntity<PessoasRetornoDTO>AtualizarPessoa(@PathVariable Long id, @RequestBody @Valid PessoasAtualizacaoDTO dados) {
		service.updatePessoa(id, dados);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<PessoasRetornoDTO>> listarPessoas() {
		return ResponseEntity.ok(service.getPessoas());

	}

	@GetMapping("id/{id}")
	public ResponseEntity<PessoasRetornoDTO> listarPessoaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.getByIdPessoa(id));
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<PessoasRetornoDTO> listarPessoaPorNome(@PathVariable String nome) { 
		return ResponseEntity.ok(service.getPessoaByNome(nome));
	}
}
