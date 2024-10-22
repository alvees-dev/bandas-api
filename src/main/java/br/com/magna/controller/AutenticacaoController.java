package br.com.magna.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.dto.autenticacao.AutenticacaoDTO;
import br.com.magna.infra.security.TokenDTO;
import br.com.magna.infra.security.TokenService;
import br.com.magna.model.Usuarios;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	private AuthenticationManager authenticationManager;
	private TokenService tokenService;
	
	public AutenticacaoController(AuthenticationManager manager, TokenService service) {
		this.authenticationManager = manager;
		this.tokenService = service;
	}
	
	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO dados) {
		var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
		var autenticador = authenticationManager.authenticate(authenticationToken);
		
		var tokenJWT = tokenService.gerarToken((Usuarios) autenticador.getPrincipal());
		
		return ResponseEntity.ok(new TokenDTO(tokenJWT));
	}

}
