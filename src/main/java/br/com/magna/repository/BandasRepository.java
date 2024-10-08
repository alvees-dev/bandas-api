package br.com.magna.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.model.Bandas;

@Repository
public interface BandasRepository extends JpaRepository<Bandas, Long>{
	
	Optional<Bandas> findBandaByNome(String nome);

}
