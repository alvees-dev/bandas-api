package br.com.magna.model;

import java.time.LocalDate;

import br.com.magna.dto.endereco.Endereco;
import br.com.magna.dto.shows.ShowsAgendaDTO;
import br.com.magna.dto.shows.ShowsAtualizacaoDTO;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "tb_shows")
@Entity(name = "Shows")
public class Shows {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String nome;
	LocalDate dataInicio;
	LocalDate dataTermino;

	@Embedded
	Endereco endereco;

	public Shows() {

	}

	public Shows(ShowsAgendaDTO dados) {
		this.nome = dados.nome();
		this.dataInicio = dados.dataInicio();
		this.dataTermino = dados.dataTermino();
		this.endereco = new Endereco(dados.endereco());

	}
	
	public void atualizacaoShows(ShowsAtualizacaoDTO dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.dataInicio() != null) {
			this.dataInicio = dados.dataInicio();
		}
		if (dados.dataTermino() != null) {
			this.dataTermino = dados.dataTermino();
		}
		if (dados.endereco() != null) {
			this.endereco.atualizarEndereco(dados.endereco());
		}
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	
	

}
