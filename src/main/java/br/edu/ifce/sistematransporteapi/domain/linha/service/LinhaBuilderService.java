package br.edu.ifce.sistematransporteapi.domain.linha.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.domain.linha.model.Linha;
import br.edu.ifce.sistematransporteapi.domain.linha.vo.LinhaVO;

@Service
public class LinhaBuilderService {

	public Linha buildToCreate(LinhaVO vo) {
		Linha linha = new Linha();
		linha.setId(vo.getId());
		linha.setNumero(vo.getNumero());
		linha.setNome(vo.getNome());
		linha.setAtiva(vo.getAtiva());
		linha.setTipo(vo.getTipo());
		return linha;
	}
	
	public LinhaVO buildToRead(Linha linha) {
		LinhaVO vo = new LinhaVO();
		vo.setId(linha.getId());
		vo.setNumero(linha.getNumero());
		vo.setNome(linha.getNome());
		vo.setAtiva(linha.getAtiva());
		vo.setTipo(linha.getTipo());
		return vo;
	}
	
	public List<LinhaVO> buildToRead(List<Linha> linhas) {
		List<LinhaVO> voList = new ArrayList<>();
		for(Linha linha : linhas) {
			voList.add(this.buildToRead(linha));
		}
		return voList;
	}
}
