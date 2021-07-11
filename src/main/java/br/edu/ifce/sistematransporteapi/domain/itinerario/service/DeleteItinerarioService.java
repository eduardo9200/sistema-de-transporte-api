package br.edu.ifce.sistematransporteapi.domain.itinerario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.itinerario.repository.ItinerarioRepository;

@Service
public class DeleteItinerarioService {

	@Autowired
	private ItinerarioRepository itinerarioRepository;
	
	public void deleteItinerario(Long id) {
		this.itinerarioRepository.deleteById(id);
	}
}
