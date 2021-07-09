package br.edu.ifce.sistematransporteapi.domain.itinerario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.application.enums.ItemPesquisa;
import br.edu.ifce.sistematransporteapi.domain.itinerario.model.Itinerario;
import br.edu.ifce.sistematransporteapi.domain.itinerario.repository.ItinerarioRepository;
import br.edu.ifce.sistematransporteapi.domain.itinerario.vo.ResultadoBuscaVO;

@Service
public class BuscaItinerarioService {

	@Autowired
	private ItinerarioRepository itinerarioRepository;
	@Autowired
	private ItinerarioBuilderService itinerarioBuilderService;
	
	public List<ResultadoBuscaVO> buscaItinerario(Long itemId, String texto) {
		ItemPesquisa item = ItemPesquisa.byId(itemId);
		List<Itinerario> itinerarios;
		
		switch(item) {
		case NUMERO:
			itinerarios = itinerarioRepository.itinerariosDaLinhaByNumero(Long.parseLong(texto));
		case LINHA:
			itinerarios = itinerarioRepository.itinerariosDaLinhaByNome(texto);
		case LOGRADOURO:
			itinerarios = itinerarioRepository.itinerariosByLogradouro(texto);
		default:
			itinerarios = new ArrayList<>();
		}
		
		return itinerarioBuilderService.buildToRead(itinerarios);
	}
}
