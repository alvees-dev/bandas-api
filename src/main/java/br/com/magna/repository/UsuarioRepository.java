package br.com.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.magna.model.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    UserDetails findByLogin(String login);
}
