package br.com.magna.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.pessoa.PessoasAtualizacaoDTO;
import br.com.magna.dto.pessoa.PessoasCadastroDTO;
import br.com.magna.dto.pessoa.PessoasRetornoDTO;
import br.com.magna.exceptions.PessoaNotFoundException;
import br.com.magna.model.Pessoas;
import br.com.magna.repository.PessoasRepository;

@Service
public class PessoasService {

	private final Pessoas pessoa;
	public final PessoasRepository repository;
	
	public PessoasService(PessoasRepository repository) {
		this.pessoa = new Pessoas();
		this.repository = repository;
	}

	public PessoasRetornoDTO createPessoa(PessoasCadastroDTO dados) {
		var pessoa = new Pessoas(dados);
		repository.save(pessoa);
		return new PessoasRetornoDTO(pessoa);

	}

	public JsonResponse deletePessoa(Long id) {
		repository.deleteById(id);
		return new JsonResponse("A pessoa com o id " + id + " foi deletada com sucesso!");
	}

	public PessoasRetornoDTO updatePessoa(Long id, PessoasAtualizacaoDTO dados) {
		
		var pessoa = repository.findById(id).orElseThrow(() ->  new PessoaNotFoundException("Não foi encontrada uma pessoa com essa ID."));
		pessoa.atualizacaoCadastroPessoa(dados);
		
		return new PessoasRetornoDTO(pessoa);

	}
	
	public List<PessoasRetornoDTO> getPessoas() {
		var pessoas = repository.findAll();
		List<PessoasRetornoDTO> dtos = new ArrayList<>();
		for(Pessoas pessoa : pessoas) {
			PessoasRetornoDTO dto = new PessoasRetornoDTO(pessoa);
			dtos.add(dto);
		}
		
		return dtos;
	}

	public PessoasRetornoDTO getByIdPessoa(Long id) {
		Optional<Pessoas> pessoaOptional = repository.findById(id);
		if(pessoaOptional.isPresent()) {
			Pessoas pessoa = pessoaOptional.get();
			return new PessoasRetornoDTO(pessoa);
		}
		throw new PessoaNotFoundException("Não foi encontrada uma Pessoa com essa ID.");
	}

	public PessoasRetornoDTO getPessoaByNome(String nome) {
		Optional<Pessoas> pessoaOptional = repository.findByNome(nome);
		if(pessoaOptional.isPresent()) {
			Pessoas pessoa = pessoaOptional.get();
			return new PessoasRetornoDTO(pessoa);
		}
		throw new PessoaNotFoundException("Não foi encontrada uma Pessoa com esse Nome.");
	}
	
//	public List<PessoasRetornoDTO> getPessoasByNomeParcial(String nomeParcial) {
//		Optional<List<Pessoas>> pessoasOptional = repository.findAllByNomeStartingWith(nomeParcial);
//		List<PessoasRetornoDTO> dtos = new ArrayList<>();
//		
//		for(List<Pessoas> pessoaOptional : pessoasOptional) {
//			if(pessoaOptional.isPresent()) {
//			PessoasRetornoDTO dto = new PessoasRetornoDTO(pessoa);
//			dtos.add(dto);
//			}
//		}
//		
//			
//		
//		return dtos;
//		
//	}
}
