package br.edu.ifce.sistematransporteapi.domain.itinerario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.itinerario.model.Itinerario;
import br.edu.ifce.sistematransporteapi.domain.itinerario.vo.ItinerarioVO;

@Service
public class ItinerarioBuilderService {
	
	public ItinerarioVO buildToRead(Itinerario itinerario) {
		ItinerarioVO vo = new ItinerarioVO();
		vo.setId(itinerario.getId());
		vo.setLinha(itinerario.getLinha());
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
		itinerario.setLinha(vo.getLinha());
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
