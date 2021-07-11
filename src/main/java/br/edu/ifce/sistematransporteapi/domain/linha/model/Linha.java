package br.edu.ifce.sistematransporteapi.domain.linha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "SITP", name = "LINHA")
@SequenceGenerator(name = "SEQ_LINHA", sequenceName = "SEQ_LINHA", schema = "SITP", allocationSize = 1, initialValue = 1)
public class Linha {

	@Id
	@Column(name = "IDLINHA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LINHA")
	@Getter @Setter
	private Long id;
	
	@Column(name = "NUMERO")
	@Getter @Setter
	private Long numero;
	
	@Column(name = "NOME")
	@Getter @Setter
	private String nome;
	
	@Column(name = "ATIVA")
	@Getter @Setter
	private Boolean ativa;
}
