package br.edu.ifce.sistematransporteapi.domain.empresa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "", name = "EMPRESA")
public class Empresa {

	@Id
	@Column(name = "IDEMPRESA")
	@Getter @Setter
	private Long id;
	
	@Column(name = "NOME")
	@Getter @Setter
	private String nome;
	
	@Column(name = "CNPJ")
	@Getter @Setter
	private String cnpj;
}
