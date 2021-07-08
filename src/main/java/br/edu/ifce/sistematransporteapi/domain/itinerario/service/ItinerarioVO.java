package br.edu.ifce.sistematransporteapi.domain.itinerario.service;

import br.edu.ifce.sistematransporteapi.application.enums.SentidoLinha;
import br.edu.ifce.sistematransporteapi.domain.linha.model.Linha;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItinerarioVO {

	private Long id;
	private Linha linha;
	private String descricao;
	private String resumo;
	private SentidoLinha sentido;
	private String pontoInicial;
	private String pontoFinal;
}
