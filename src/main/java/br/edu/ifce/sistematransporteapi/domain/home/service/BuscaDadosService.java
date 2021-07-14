package br.edu.ifce.sistematransporteapi.domain.home.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.home.repository.HomeRepository;
import br.edu.ifce.sistematransporteapi.domain.home.vo.DataList;
import br.edu.ifce.sistematransporteapi.domain.home.vo.DataObject;
import br.edu.ifce.sistematransporteapi.domain.horario.vo.HorarioVO;
import br.edu.ifce.sistematransporteapi.domain.itinerario.vo.ItinerarioVO;
import br.edu.ifce.sistematransporteapi.domain.linha.vo.LinhaVO;

@Service
public class BuscaDadosService {
	
	@Autowired
	private HomeRepository homeRepository;
	
	public List<DataList> buscaDados() {
		List<DataObject> result = this.homeRepository.getDataList();
		List<DataList> resultList = new ArrayList<>();
		
		for(DataObject obj : result) {
			LinhaVO linha = new LinhaVO();
			linha.setNumero(obj.getNumeroLinha());
			linha.setNome(obj.getNomeLinha());
			linha.setAtiva(obj.getLinhaAtiva());
			
			HorarioVO horario = new HorarioVO();
			horario.setInicioDiaUtil(obj.getInicioDiaUtil());
			horario.setInicioSabado(obj.getInicioSabado());
			horario.setInicioDomingoEFeriado(obj.getInicioDomingoEFeriado());
			horario.setFimDiaUtil(obj.getFimDiaUtil());
			horario.setFimSabado(obj.getFimSabado());
			horario.setFimDomingoEFeriado(obj.getFimDomingoEFeriado());
			
			ItinerarioVO itinerario = new ItinerarioVO();
			itinerario.setResumo(obj.getResumoItinerario());
			
			DataList data = new DataList();
			data.setLinha(linha);
			data.setHorario(horario);
			data.setItinerario(itinerario);
			
			resultList.add(data);
		}
		
		return resultList;
	}
}
