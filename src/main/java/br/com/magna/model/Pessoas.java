package br.com.magna.model;

import java.time.LocalDate;

import br.com.magna.dto.pessoa.PessoasAtualizacaoDTO;
import br.com.magna.dto.pessoa.PessoasCadastroDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "tb_pessoa")
@Entity(name = "Pessoa")
public class Pessoas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private String paisNascimento;

	public Pessoas() {
		
	}

	public Pessoas(PessoasCadastroDTO dados) {

		this.nome = dados.nome();
		this.email = dados.email();
		this.dataNascimento = dados.dataNascimento();
		this.paisNascimento = dados.paisNascimento();
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setId(Long id) {
		this.idPessoa = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPaisNascimento() {
		return paisNascimento;
	}

	public void setPaisNascimento(String paisNascimento) {
		this.paisNascimento = paisNascimento;
	}

	public void atualizacaoCadastroPessoa(PessoasAtualizacaoDTO dados ) {
		
		if(dados.nome() != null) {
			this.nome = dados.nome();
			}
			if(dados.email() != null) {
			this.email = dados.email();
			}
			if(dados.dataNascimento() != null) {
			this.dataNascimento = dados.dataNascimento();
			}
			if(dados.paisNascimento() != null) {
			this.paisNascimento = dados.paisNascimento();
			}
	}
	

}
