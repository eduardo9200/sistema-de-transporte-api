package br.edu.ifce.sistematransporteapi.domain.itinerario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.sistematransporteapi.domain.itinerario.service.BuscaItinerarioService;
import br.edu.ifce.sistematransporteapi.domain.itinerario.service.DeleteItinerarioService;
import br.edu.ifce.sistematransporteapi.domain.itinerario.service.ItinerarioBuilderService;
import br.edu.ifce.sistematransporteapi.domain.itinerario.service.SalvaItinerarioService;
import br.edu.ifce.sistematransporteapi.domain.itinerario.vo.ItinerarioVO;

@RestController
@RequestMapping("itinerario")
public class ItinerarioController {

	@Autowired
	private BuscaItinerarioService buscaItinerarioService;
	@Autowired
	private SalvaItinerarioService salvaItinerarioService;
	@Autowired
	private ItinerarioBuilderService itinerarioBuilderService;
	@Autowired
	private DeleteItinerarioService deleteItinerarioService;
	
	@PostMapping(value="/salva-itinerario")
	public ItinerarioVO salvaItinerario(@RequestBody ItinerarioVO itinerario) {
		return this.itinerarioBuilderService.buildToRead(this.salvaItinerarioService.salvaItinerario(itinerario));
	}
	
	@DeleteMapping(value="/delete/id/{id}")
	public boolean deleteItinerario(@PathVariable("id") Long id) {
		this.deleteItinerarioService.deleteItinerario(id);
		return true;
	}
	
	@GetMapping(value="/pesquisar/{itemId}/{valor}")
	public List<ItinerarioVO> buscaItinerario(@PathVariable("itemId") Long itemId, @PathVariable("valor") String valor) {
		return this.buscaItinerarioService.buscaItinerario(itemId, valor);
	}
	
}
