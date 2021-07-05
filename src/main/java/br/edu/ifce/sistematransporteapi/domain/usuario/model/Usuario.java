package br.edu.ifce.sistematransporteapi.domain.usuario.model;

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
@Table(schema="SITP", name = "USUARIO")
@SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", schema = "SITP", allocationSize = 1, initialValue = 1)
public class Usuario {
	
	@Id
	@Column(name = "IDUSUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
	@Getter @Setter
	private Long id;
	
	@Column(name = "NOME")
	@Getter @Setter
	private String nome;
	
	@Column(name = "LOGIN")
	@Getter @Setter
	private String login;
	
	@Column(name = "SENHA")
	@Getter @Setter
	private String senha;

}
