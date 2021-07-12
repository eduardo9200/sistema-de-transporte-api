package br.edu.ifce.sistematransporteapi.domain.itinerario.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.application.enums.ItemPesquisa;
import br.edu.ifce.sistematransporteapi.domain.itinerario.model.Itinerario;
import br.edu.ifce.sistematransporteapi.domain.itinerario.repository.ItinerarioRepository;
import br.edu.ifce.sistematransporteapi.domain.itinerario.vo.ItinerarioVO;

@Service
public class BuscaItinerarioService {

	@Autowired
	private ItinerarioRepository itinerarioRepository;
	@Autowired
	private ItinerarioBuilderService itinerarioBuilderService;
	
	public List<ItinerarioVO> buscaItinerario(Long itemId, String texto) {
		ItemPesquisa item = ItemPesquisa.byId(itemId);
		List<Itinerario> itinerarios;
		
		switch(item) {
		case TODOS:
			itinerarios = itinerarioRepository.buscaTodosItinerarios();
			break;
		case NUMERO:
			itinerarios = itinerarioRepository.itinerariosDaLinhaByNumero(Long.parseLong(texto));
			break;
		case LINHA:
			itinerarios = itinerarioRepository.itinerariosDaLinhaByNome(texto);
			break;
		case LOGRADOURO:
			itinerarios = itinerarioRepository.itinerariosByLogradouro(texto);
			break;
		default:
			itinerarios = Collections.emptyList();
		}
		
		return itinerarioBuilderService.buildToRead(itinerarios);
	}
}
