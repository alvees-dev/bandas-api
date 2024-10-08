package br.com.magna.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.model.Pessoas;
import br.com.magna.model.Shows;

@Repository
public interface ShowsRepository extends JpaRepository<Shows, Long> {

	Optional<Shows> findShowByNome(String nome);
}
