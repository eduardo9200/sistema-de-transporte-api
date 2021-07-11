package br.edu.ifce.sistematransporteapi.domain.linha.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LinhaVO {
	private Long id;
	private Long numero;
	private String nome;
	private Boolean ativa;
}
