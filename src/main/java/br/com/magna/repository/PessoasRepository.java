package br.com.magna.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.model.Pessoas;

@Repository
public interface PessoasRepository  extends JpaRepository<Pessoas, Long>{
	
	Optional<Pessoas> findByNome(String nome);
	
	//Optional<List<Pessoas>> findAllByNomeStartingWith(String nomePrefixo);
	

}
