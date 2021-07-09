package br.edu.ifce.sistematransporteapi.domain.itinerario.vo;

import br.edu.ifce.sistematransporteapi.application.enums.SentidoLinha;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultadoBuscaVO {
	private Long numeroLinha;
	private String nomeLinha;
	private String itinerario;
	private String resumoItinerario;
	private SentidoLinha sentido;
	private Boolean linhaAtiva;
}