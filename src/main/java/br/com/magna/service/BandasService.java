 package br.com.magna.service;

import org.springframework.stereotype.Service;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.banda.BandaAtualizacaoDTO;
import br.com.magna.dto.banda.BandasCadastroDTO;
import br.com.magna.dto.banda.BandasRetornoDTO;
import br.com.magna.exceptions.BandaNotFoundException;
import br.com.magna.model.Bandas;
import br.com.magna.repository.BandasRepository;

@Service
public class BandasService {

	private final BandasRepository repository;
	
	public BandasService(BandasRepository repository) {
		this.repository = repository;
	}
	
	public BandasRetornoDTO createBanda(BandasCadastroDTO dados) {
		var banda = new Bandas(dados);
		repository.save(banda);
		return new BandasRetornoDTO(banda);
		
	}
	
	public JsonResponse deleteBanda(Long id) {
		repository.deleteById(id);
		return new JsonResponse("A banda com o id " + id + " foi deletada com sucesso!");
	}
	
	public BandasRetornoDTO atualizarBandas(Long id, BandaAtualizacaoDTO dados) {
		
		var bandas = repository.findById(id).orElseThrow(() -> new BandaNotFoundException("Não foi possível encontrar uma Banda com este id!"));
		bandas.atualizacaoCadastroBanda(dados);
		
		return new BandasRetornoDTO(bandas);
	}
	
}
