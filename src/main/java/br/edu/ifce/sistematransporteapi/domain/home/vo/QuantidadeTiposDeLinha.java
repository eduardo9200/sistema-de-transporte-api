package br.edu.ifce.sistematransporteapi.domain.home.vo;

import br.edu.ifce.sistematransporteapi.application.enums.TipoLinha;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QuantidadeTiposDeLinha {
	private TipoLinha tipo;
	private Long quantidade;
}
