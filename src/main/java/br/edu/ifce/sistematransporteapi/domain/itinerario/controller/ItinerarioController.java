package br.edu.ifce.sistematransporteapi.domain.itinerario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.sistematransporteapi.domain.itinerario.service.BuscaItinerarioService;
import br.edu.ifce.sistematransporteapi.domain.itinerario.vo.ResultadoBuscaVO;

@RestController
@RequestMapping("itinerario")
public class ItinerarioController {

	@Autowired
	private BuscaItinerarioService buscaItinerarioService;
	
	@GetMapping(value="/pesquisar/{itemId}/{valor}")
	public List<ResultadoBuscaVO> buscaItinerario(@PathVariable("itemId") Long itemId, @PathVariable("valor") String valor) {
		return this.buscaItinerarioService.buscaItinerario(itemId, valor);
	}
	
}
