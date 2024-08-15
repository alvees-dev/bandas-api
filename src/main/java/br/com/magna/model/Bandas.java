package br.com.magna.model;

import java.time.LocalDate;

import br.com.magna.dto.banda.BandaAtualizacaoDTO;
import br.com.magna.dto.banda.BandasCadastroDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "tb_bandas")
@Entity(name = "Bandas")
public class Bandas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	private String generoMusical;
	private LocalDate dataCriacao;
	private String paisOrigem;

	public Bandas() {

	}

	public Bandas(BandasCadastroDTO dados) {

		this.nome = dados.nome();
		this.generoMusical = dados.generoMusical();
		this.dataCriacao = dados.dataCriacao();
		this.paisOrigem = dados.paisOrigem();
	}
	
	public void atualizacaoCadastroBanda(BandaAtualizacaoDTO dados) {
		
		if(dados.nome() != null) {
			this.nome = dados.nome();
		} if (dados.generoMusical() != null) {
			this.generoMusical = dados.generoMusical();
		} if (dados.dataCriacao() != null) {
			this.dataCriacao = dados.dataCriacao();
		} if (dados.paisOrigem() != null) {
			this.paisOrigem = dados.paisOrigem();
		}
		
		
	}

	public Long getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

}