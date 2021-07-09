package br.edu.ifce.sistematransporteapi.domain.itinerario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.sistematransporteapi.domain.itinerario.service.BuscaItinerarioService;
import br.edu.ifce.sistematransporteapi.domain.itinerario.service.ItinerarioBuilderService;
import br.edu.ifce.sistematransporteapi.domain.itinerario.service.ItinerarioVO;
import br.edu.ifce.sistematransporteapi.domain.itinerario.service.SalvaItinerarioService;
import br.edu.ifce.sistematransporteapi.domain.itinerario.vo.ResultadoBuscaVO;

@RestController
@RequestMapping("itinerario")
public class ItinerarioController {

	@Autowired
	private BuscaItinerarioService buscaItinerarioService;
	@Autowired
	private SalvaItinerarioService salvaItinerarioService;
	@Autowired
	private ItinerarioBuilderService itinerarioBuilderService;
	
	@PostMapping(value="/salva-itinerario")
	public ItinerarioVO salvaItinerario(@RequestBody ItinerarioVO itinerario) {
		return this.itinerarioBuilderService.buildToRead(this.salvaItinerarioService.salvaItinerario(itinerario));
	}
	
	@GetMapping(value="/pesquisar/{itemId}/{valor}")
	public List<ResultadoBuscaVO> buscaItinerario(@PathVariable("itemId") Long itemId, @PathVariable("valor") String valor) {
		return this.buscaItinerarioService.buscaItinerario(itemId, valor);
	}
	
}
