package br.edu.ifce.sistematransporteapi.domain.itinerario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.itinerario.model.Itinerario;
import br.edu.ifce.sistematransporteapi.domain.itinerario.repository.ItinerarioRepository;

@Service
public class SalvaItinerarioService {
	
	@Autowired
	private ItinerarioRepository itinerarioRepository;
	@Autowired
	private ItinerarioBuilderService itinerarioBuilderService;

	public Itinerario salvaItinerario(ItinerarioVO itinerario) {
		return this.itinerarioRepository.save(itinerarioBuilderService.buildToCreate(itinerario));
	}
}
