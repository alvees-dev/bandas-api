package br.com.magna.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "tb_integrantes")
@Entity(name = "Integrantes")
public class Integrantes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idIntegrantes;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa")
	Pessoas pessoa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bandas")
	Bandas banda;
	
	String funcao;
	
	public Integrantes() {
		
	}
	
	public Integrantes(Long id, Bandas bandas, Pessoas pessoas, String funcao) {
		this.idIntegrantes = id;
		this.pessoa = pessoas;
		this.banda = bandas;
		this.funcao = funcao;
	}

	public Long getIdIntegrantes() {
		return idIntegrantes;
	}

	public Pessoas getIdPessoa() {
		return pessoa;
	}

	public Bandas getIdBanda() {
		return banda;
	}

	public String getFuncao() {
		return funcao;
	}
	
	
	

}
