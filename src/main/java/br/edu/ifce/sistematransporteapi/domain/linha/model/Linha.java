package br.edu.ifce.sistematransporteapi.domain.linha.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.ifce.sistematransporteapi.application.converter.CategoriaLinhaConverter;
import br.edu.ifce.sistematransporteapi.application.enums.CategoriaLinha;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "", name = "LINHA")
public class Linha {

	@Id
	@Column(name = "IDLINHA")
	@Getter @Setter
	private Long id;
	
	@Column(name = "NUMERO")
	@Getter @Setter
	private Long numero;
	
	@Column(name = "NOME")
	@Getter @Setter
	private String nome;
	
	@Convert(converter = CategoriaLinhaConverter.class)
	@Column(name = "CATEGORIA")
	@Getter @Setter
	private CategoriaLinha categoria;
	
	@Column(name = "ATIVA")
	@Getter @Setter
	private Boolean ativa;
}
