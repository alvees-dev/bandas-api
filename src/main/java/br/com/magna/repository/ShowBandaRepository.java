package br.com.magna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magna.model.ShowBandas;

@Repository
public interface ShowBandaRepository extends JpaRepository<ShowBandas, Long>{

}
