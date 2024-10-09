package br.com.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.model.Integrantes;

@Repository
public interface IntegrantesRepository extends JpaRepository<Integrantes, Long>{

}
