package br.com.magna.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.magna.dto.JsonResponse;
import br.com.magna.dto.banda.BandaAtualizacaoDTO;
import br.com.magna.dto.banda.BandasCadastroDTO;
import br.com.magna.dto.banda.BandasRetornoDTO;
import br.com.magna.infra.exceptions.BandaNotFoundException;
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

		var bandas = repository.findById(id)
				.orElseThrow(() -> new BandaNotFoundException("Não foi possível encontrar uma Banda com este id!"));
		bandas.atualizacaoCadastroBanda(dados);

		return new BandasRetornoDTO(bandas);
	}

	public List<BandasRetornoDTO> getBandas() {
		var bandas = repository.findAll();
		List<BandasRetornoDTO> dtos = new ArrayList<>();
		if (!bandas.isEmpty()) {
			for (Bandas banda : bandas) {
				BandasRetornoDTO dto = new BandasRetornoDTO(banda);
				dtos.add(dto);
			}
			return dtos;
		}
		throw new BandaNotFoundException("Não foram encontradas bandas cadastradas");
	}

	public BandasRetornoDTO getBandaById(Long id) {
		Optional<Bandas> bandasOptional = repository.findById(id);
		if (bandasOptional.isPresent()) {
			Bandas bandas = bandasOptional.get();
			return new BandasRetornoDTO(bandas);
		}
		throw new BandaNotFoundException("Não foi encontrada banda com a ID digitada");
	}

	public BandasRetornoDTO findBandaByNome(String nome) {
		Optional<Bandas> bandasOptional = repository.findBandaByNome(nome);
		if (bandasOptional.isPresent()) {
			Bandas bandas = bandasOptional.get();
			return new BandasRetornoDTO(bandas);
		}
		throw new BandaNotFoundException("Não foi encontrada banda com o nome digitado");
	}

}
