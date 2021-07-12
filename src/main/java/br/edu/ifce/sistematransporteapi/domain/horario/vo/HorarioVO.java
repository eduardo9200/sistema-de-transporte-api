package br.edu.ifce.sistematransporteapi.domain.horario.vo;

import br.edu.ifce.sistematransporteapi.domain.linha.model.Linha;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HorarioVO {
	private Long id;
	private Linha linha;
	private String inicioDiaUtil;
	private String inicioSabado;
	private String inicioDomingoEFeriado;
	private String fimDiaUtil;
	private String fimSabado;
	private String fimDomingoEFeriado;
	private Long intervaloDiaUtil;
	private Long intervaloSabado;
	private Long intervaloDomingoEFeriado;
}
