package br.edu.ifce.sistematransporteapi.domain.linha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.linha.repository.LinhaRepository;

@Service
public class DeleteLinhaService {

	@Autowired
	private LinhaRepository linhaRepository;
	
	public void deleteLinha(Long id) {
		this.linhaRepository.deleteById(id);
	}
}
