package br.com.magna.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.pessoa.PessoasAtualizacaoDTO;
import br.com.magna.dto.pessoa.PessoasCadastroDTO;
import br.com.magna.dto.pessoa.PessoasRetornoDTO;
import br.com.magna.infra.exceptions.PessoaNotFoundException;
import br.com.magna.model.Pessoas;
import br.com.magna.repository.PessoasRepository;

@Service
public class PessoasService {

	public final PessoasRepository pessoaRepository;

	public PessoasService(PessoasRepository repository) {
		this.pessoaRepository = repository;
	}

	public PessoasRetornoDTO createPessoa(PessoasCadastroDTO dados) {
		var pessoa = new Pessoas(dados);
		pessoaRepository.save(pessoa);
		
		return new PessoasRetornoDTO(pessoa);
	}

	public JsonResponse deletePessoa(Long id) {
		pessoaRepository.deleteById(id);
		return new JsonResponse("A pessoa com o id " + id + " foi deletada com sucesso!");
	}

	public PessoasRetornoDTO updatePessoa(Long id, PessoasAtualizacaoDTO dados) {

		var pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new PessoaNotFoundException("Não foi encontrada uma pessoa com essa ID."));
		pessoa.atualizacaoCadastroPessoa(dados);

		return new PessoasRetornoDTO(pessoa);
	}

	public List<PessoasRetornoDTO> getPessoas() {
		var pessoas = pessoaRepository.findAll();
		List<PessoasRetornoDTO> dtos = new ArrayList<>();
		if (!pessoas.isEmpty()) {
			for (Pessoas pessoa : pessoas) {
				PessoasRetornoDTO dto = new PessoasRetornoDTO(pessoa);
				dtos.add(dto);
			}
			return dtos;
		}
		throw new PessoaNotFoundException("Não foram encontradas pessoas cadastradas");
	}

	public PessoasRetornoDTO getByIdPessoa(Long id) {
		Optional<Pessoas> pessoaOptional = pessoaRepository.findById(id);
		if (pessoaOptional.isPresent()) {
			Pessoas pessoa = pessoaOptional.get();
			return new PessoasRetornoDTO(pessoa);
		}
		throw new PessoaNotFoundException("Não foi encontrada uma Pessoa com essa ID.");
	}

	public PessoasRetornoDTO getPessoaByNome(String nome) {
		Optional<Pessoas> pessoaOptional = pessoaRepository.findByNome(nome);
		if (pessoaOptional.isPresent()) {
			Pessoas pessoa = pessoaOptional.get();
			return new PessoasRetornoDTO(pessoa);
		}
		throw new PessoaNotFoundException("Não foi encontrada uma Pessoa com esse Nome.");
	}

}
