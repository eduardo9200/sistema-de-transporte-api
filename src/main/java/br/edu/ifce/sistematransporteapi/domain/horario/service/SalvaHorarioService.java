package br.edu.ifce.sistematransporteapi.domain.horario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.horario.model.Horario;
import br.edu.ifce.sistematransporteapi.domain.horario.repository.HorarioRepository;
import br.edu.ifce.sistematransporteapi.domain.horario.vo.HorarioVO;

@Service
public class SalvaHorarioService {

	@Autowired
	private HorarioRepository horarioRepository;
	@Autowired
	private HorarioBuilderService horarioBuilderService;
	
	public Horario salvar(HorarioVO horario) {
		return this.horarioRepository.save(this.horarioBuilderService.buildToCreate(horario));
	}
}
