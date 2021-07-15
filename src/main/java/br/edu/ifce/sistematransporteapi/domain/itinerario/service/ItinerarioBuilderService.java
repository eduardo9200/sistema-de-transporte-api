package br.edu.ifce.sistematransporteapi.domain.itinerario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.itinerario.model.Itinerario;
import br.edu.ifce.sistematransporteapi.domain.itinerario.vo.ItinerarioVO;
import br.edu.ifce.sistematransporteapi.domain.linha.service.LinhaBuilderService;

@Service
public class ItinerarioBuilderService {
	
	@Autowired
	private LinhaBuilderService linhaBuilderService;
	
	public ItinerarioVO buildToRead(Itinerario itinerario) {
		ItinerarioVO vo = new ItinerarioVO();
		vo.setId(itinerario.getId());
		vo.setLinha(this.linhaBuilderService.buildToRead(itinerario.getLinha()));
		vo.setDescricao(itinerario.getDescricao());
		vo.setResumo(itinerario.getResumo());
		vo.setSentido(itinerario.getSentido());
		vo.setPontoInicial(itinerario.getPontoInicial());
		vo.setPontoFinal(itinerario.getPontoFinal());
		return vo;
	}
	
	public Itinerario buildToCreate(ItinerarioVO vo) {
		Itinerario itinerario = new Itinerario();
		itinerario.setId(vo.getId());
		itinerario.setLinha(this.linhaBuilderService.buildToCreate(vo.getLinha()));
		itinerario.setDescricao(vo.getDescricao());
		itinerario.setResumo(vo.getResumo());
		itinerario.setSentido(vo.getSentido());
		itinerario.setPontoInicial(vo.getPontoInicial());
		itinerario.setPontoFinal(vo.getPontoFinal());
		return itinerario;
	}
	
	public List<ItinerarioVO> buildToRead(List<Itinerario> itinerarios) {
		List<ItinerarioVO> voList = new ArrayList<>();
		for(Itinerario i : itinerarios) {
			voList.add(this.buildToRead(i));
		}
		return voList;
	}
}
