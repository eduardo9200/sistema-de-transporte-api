package br.edu.ifce.sistematransporteapi.domain.home.repository;

import java.util.List;

import br.edu.ifce.sistematransporteapi.domain.home.vo.DataObject;
import br.edu.ifce.sistematransporteapi.domain.home.vo.QuantidadeTiposDeLinha;

public interface HomeRepository {

	public List<DataObject> getDataList();
	
	public List<QuantidadeTiposDeLinha> getQuantidadeTiposDeLinha();
}
