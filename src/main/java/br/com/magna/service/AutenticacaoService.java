package br.com.magna.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.magna.repository.AutenticacaoRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
	
	private AutenticacaoRepository usuarioRepository;
	
	public AutenticacaoService (AutenticacaoRepository repository) {
		this.usuarioRepository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepository.findByLogin(username);
	}

}
