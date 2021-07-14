package br.edu.ifce.sistematransporteapi.domain.home.vo;

import br.edu.ifce.sistematransporteapi.domain.horario.vo.HorarioVO;
import br.edu.ifce.sistematransporteapi.domain.itinerario.vo.ItinerarioVO;
import br.edu.ifce.sistematransporteapi.domain.linha.vo.LinhaVO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DataList {
	private LinhaVO linha;
	private ItinerarioVO itinerario;
	private HorarioVO horario;
}
