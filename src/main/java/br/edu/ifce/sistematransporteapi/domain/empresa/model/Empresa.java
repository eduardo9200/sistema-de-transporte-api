package br.edu.ifce.sistematransporteapi.domain.empresa.model;

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
@Table(schema = "SITP", name = "EMPRESA")
@SequenceGenerator(name = "SEQ_EMPRESA", sequenceName = "SEQ_EMPRESA", allocationSize = 1, initialValue = 1)
public class Empresa {

	@Id
	@Column(name = "IDEMPRESA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPRESA")
	@Getter @Setter
	private Long id;
	
	@Column(name = "NOME")
	@Getter @Setter
	private String nome;
	
	@Column(name = "CNPJ")
	@Getter @Setter
	private String cnpj;
}
