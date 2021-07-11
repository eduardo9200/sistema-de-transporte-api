package br.edu.ifce.sistematransporteapi.domain.linha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.linha.model.Linha;
import br.edu.ifce.sistematransporteapi.domain.linha.repository.LinhaRepository;
import br.edu.ifce.sistematransporteapi.domain.linha.vo.LinhaVO;

@Service
public class SalvaLinhaService {

	@Autowired
	private LinhaRepository linhaRepository;
	@Autowired
	private LinhaBuilderService linhaBuilderService;
	
	
	public Linha salvaLinha(LinhaVO linha) {
		return this.linhaRepository.save(this.linhaBuilderService.buildToCreate(linha));
	}
}
