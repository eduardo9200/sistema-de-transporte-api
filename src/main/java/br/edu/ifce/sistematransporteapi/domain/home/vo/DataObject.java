package br.edu.ifce.sistematransporteapi.domain.home.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DataObject {
	private Long numeroLinha;
	private String nomeLinha;
	private Boolean linhaAtiva;
	private String resumoItinerario;
	private String inicioDiaUtil;
	private String fimDiaUtil;
	private String inicioSabado;
	private String fimSabado;
	private String inicioDomingoEFeriado;
	private String fimDomingoEFeriado;
}
