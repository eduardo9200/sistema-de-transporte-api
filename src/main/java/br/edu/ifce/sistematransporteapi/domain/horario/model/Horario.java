package br.edu.ifce.sistematransporteapi.domain.horario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.edu.ifce.sistematransporteapi.domain.linha.model.Linha;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "SITP", name = "HORARIO")
@SequenceGenerator(name = "SEQ_HORARIO", sequenceName = "SEQ_HORARIO", schema = "SITP", allocationSize = 1, initialValue = 1)
public class Horario {

	@Id
	@Column(name = "IDHORARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HORARIO")
	@Getter @Setter
	private Long id;
	
	@JoinColumn(name = "IDLINHA")
	@Getter @Setter
	private Linha linha;
	
	@Column(name = "HORA")
	@Getter @Setter
	private String inicioDiaUtil;
	
	@Column(name = "HORA")
	@Getter @Setter
	private String inicioSabado;
	
	@Column(name = "HORA")
	@Getter @Setter
	private String inicioDomingoEFeriado;
	
	@Column(name = "HORA")
	@Getter @Setter
	private String fimDiaUtil;
	
	@Column(name = "HORA")
	@Getter @Setter
	private String fimSabado;
	
	@Column(name = "HORA")
	@Getter @Setter
	private String fimDomingoEFeriado;
}
