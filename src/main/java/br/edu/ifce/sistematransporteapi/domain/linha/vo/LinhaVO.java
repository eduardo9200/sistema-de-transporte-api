package br.edu.ifce.sistematransporteapi.domain.linha.vo;

import br.edu.ifce.sistematransporteapi.application.enums.TipoLinha;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LinhaVO {
	private Long id;
	private Long numero;
	private String nome;
	private Boolean ativa;
	private TipoLinha tipo;
}
