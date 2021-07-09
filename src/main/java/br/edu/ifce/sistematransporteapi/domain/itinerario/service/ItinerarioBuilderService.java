package br.edu.ifce.sistematransporteapi.domain.itinerario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.itinerario.model.Itinerario;
import br.edu.ifce.sistematransporteapi.domain.itinerario.vo.ResultadoBuscaVO;

@Service
public class ItinerarioBuilderService {

	/*public ResultadoBuscaVO buildToRead(Itinerario itinerario) {
		ResultadoBuscaVO resultado = new ResultadoBuscaVO();
		resultado.setNumeroLinha(itinerario.getLinha().getNumero());
		resultado.setNomeLinha(itinerario.getLinha().getNome());
		resultado.setItinerario(itinerario.getDescricao());
		resultado.setResumoItinerario(itinerario.getResumo());
		resultado.setSentido(itinerario.getSentido());
		resultado.setLinhaAtiva(itinerario.getLinha().getAtiva());
		return resultado;
	}*/
	
	public List<ResultadoBuscaVO> buildToRead(List<Itinerario> itinerarios) {
		List<ResultadoBuscaVO> resultados = new ArrayList<>();
		for(Itinerario i : itinerarios) {
			resultados.add(this.buildToRead(i));
		}
		return resultados;
	}
	
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
		itinerario.setLinha(vo.getLinha());
		itinerario.setDescricao(vo.getDescricao());
		itinerario.setResumo(vo.getResumo());
		itinerario.setSentido(vo.getSentido());
		itinerario.setPontoInicial(vo.getPontoInicial());
		itinerario.setPontoFinal(vo.getPontoFinal());
		return itinerario;
	}
}
