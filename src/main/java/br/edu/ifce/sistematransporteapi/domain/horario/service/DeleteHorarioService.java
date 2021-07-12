package br.edu.ifce.sistematransporteapi.domain.horario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.horario.repository.HorarioRepository;

@Service
public class DeleteHorarioService {

	@Autowired
	private HorarioRepository horarioRepository;
	
	public void delete(Long id) {
		this.horarioRepository.deleteById(id);
	}
}
