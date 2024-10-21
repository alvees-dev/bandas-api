package br.com.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.magna.model.Usuarios;

@Repository
public interface AutenticacaoRepository extends JpaRepository<Usuarios, Long> {

	UserDetails findByLogin(String login);

}
