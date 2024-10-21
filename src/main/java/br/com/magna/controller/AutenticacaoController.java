package br.com.magna.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.autenticacao.AutenticacaoDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	private AuthenticationManager authenticationManager;
	
	public AutenticacaoController(AuthenticationManager manager) {
		this.authenticationManager = manager;
	}
	
	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO dados) {
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
		var autenticador = authenticationManager.authenticate(token);
		
		return ResponseEntity.ok().build();
	}

}
