package br.edu.ifce.sistematransporteapi.domain.itinerario.vo;

import br.edu.ifce.sistematransporteapi.application.enums.SentidoLinha;
import br.edu.ifce.sistematransporteapi.domain.linha.vo.LinhaVO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItinerarioVO {

	private Long id;
	private LinhaVO linha;
	private String descricao;
	private String resumo;
	private SentidoLinha sentido;
	private String pontoInicial;
	private String pontoFinal;
}
