package br.edu.ifce.sistematransporteapi.domain.horario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.horario.model.Horario;
import br.edu.ifce.sistematransporteapi.domain.horario.vo.HorarioVO;

@Service
public class HorarioBuilderService {

	public HorarioVO buildToRead(Horario horario) {
		HorarioVO vo = new HorarioVO();
		vo.setId(horario.getId());
		vo.setLinha(horario.getLinha());
		vo.setInicioDiaUtil(horario.getInicioDiaUtil());
		vo.setInicioSabado(horario.getInicioSabado());
		vo.setInicioDomingoEFeriado(horario.getFimDomingoEFeriado());
		vo.setFimDiaUtil(horario.getFimDiaUtil());
		vo.setFimSabado(horario.getFimSabado());
		vo.setFimDomingoEFeriado(horario.getFimDomingoEFeriado());
		vo.setIntervaloDiaUtil(horario.getIntervaloDiaUtil());
		vo.setIntervaloSabado(horario.getIntervaloSabado());
		vo.setIntervaloDomingoEFeriado(horario.getIntervaloDomingoEFeriado());
		return vo;
	}
	
	public Horario buildToCreate(HorarioVO vo) {
		Horario horario = new Horario();
		horario.setId(vo.getId());
		horario.setLinha(vo.getLinha());
		horario.setInicioDiaUtil(vo.getInicioDiaUtil());
		horario.setInicioSabado(vo.getInicioSabado());
		horario.setInicioDomingoEFeriado(vo.getFimDomingoEFeriado());
		horario.setFimDiaUtil(vo.getFimDiaUtil());
		horario.setFimSabado(vo.getFimSabado());
		horario.setFimDomingoEFeriado(vo.getFimDomingoEFeriado());
		horario.setIntervaloDiaUtil(vo.getIntervaloDiaUtil());
		horario.setIntervaloSabado(vo.getIntervaloSabado());
		horario.setIntervaloDomingoEFeriado(vo.getIntervaloDomingoEFeriado());
		return horario;
	}
	
	public List<HorarioVO> buildToRead(List<Horario> horarioList) {
		List<HorarioVO> voList = new ArrayList<HorarioVO>();
		for(Horario horario : horarioList) {
			voList.add(this.buildToRead(horario));
		}
		return voList;
	}
}
