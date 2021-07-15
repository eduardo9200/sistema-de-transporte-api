package br.edu.ifce.sistematransporteapi.domain.horario.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.application.enums.ItemPesquisaLinha;
import br.edu.ifce.sistematransporteapi.domain.horario.model.Horario;
import br.edu.ifce.sistematransporteapi.domain.horario.repository.HorarioRepository;
import br.edu.ifce.sistematransporteapi.domain.horario.vo.HorarioVO;

@Service
public class BuscaHorarioService {

	@Autowired
	private HorarioRepository horarioRepository;
	@Autowired
	private HorarioBuilderService horarioBuilderService;
	
	public List<HorarioVO> buscar(Long itemId, String texto) {
		ItemPesquisaLinha item = ItemPesquisaLinha.byId(itemId);
		List<Horario> horarioList;
		
		switch(item) {
		case TODAS:
			horarioList = this.horarioRepository.findByOrderByLinhaNomeAsc();
			break;
			
		case NUMERO:
			Optional<Horario> opt = this.horarioRepository.findByLinhaNumero(Long.parseLong(texto));
			horarioList = opt.isPresent() ? Collections.singletonList(opt.get()) : Collections.emptyList(); 
			break;		
							
		case NOME:
			horarioList = this.horarioRepository.buscaPeloNomeLinha(texto);
			break;
			
		default:
			horarioList = Collections.emptyList();
		}
		
		return this.horarioBuilderService.buildToRead(horarioList);
	}
}
