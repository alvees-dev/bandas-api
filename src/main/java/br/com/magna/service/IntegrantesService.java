package br.com.magna.service;

import org.springframework.stereotype.Service;

import br.com.magna.dto.integrantes.IntegrantesRetornoDTO;
import br.com.magna.dto.integrantes.IntegrantesVinculacaoDTO;
import br.com.magna.infra.exceptions.BandaNotFoundException;
import br.com.magna.infra.exceptions.PessoaNotFoundException;
import br.com.magna.model.Integrantes;
import br.com.magna.repository.BandasRepository;
import br.com.magna.repository.IntegrantesRepository;
import br.com.magna.repository.PessoasRepository;

@Service
public class IntegrantesService {

	private PessoasRepository pessoasRepository;
	private BandasRepository bandasRepository;
	private IntegrantesRepository integrantesRepository;

	public IntegrantesService(PessoasRepository pessoasRepo, BandasRepository bandasRepo,
			IntegrantesRepository integrantesRepo) {
		this.pessoasRepository = pessoasRepo;
		this.bandasRepository = bandasRepo;
		this.integrantesRepository = integrantesRepo;
	}

	public IntegrantesRetornoDTO vincularIntegrante(IntegrantesVinculacaoDTO dados) {

		var optionalBanda = bandasRepository.findById(dados.idBandas());
		if (optionalBanda.isEmpty()) {
			throw new BandaNotFoundException("Banda não encontrada");
		}
		
		var optionalPessoa = pessoasRepository.findById(dados.idPessoa());
		if (optionalPessoa.isEmpty()) {
			throw new PessoaNotFoundException("Show não encontrado");
		}

		var banda = optionalBanda.get();
		var pessoa = optionalPessoa.get();
		var funcao = dados.funcao();
		var integrantes = new Integrantes(null, banda, pessoa, funcao);
		integrantesRepository.save(integrantes);

		return new IntegrantesRetornoDTO(integrantes);
	}

}
