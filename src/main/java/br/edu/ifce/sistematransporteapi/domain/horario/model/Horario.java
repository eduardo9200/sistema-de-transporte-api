package br.edu.ifce.sistematransporteapi.domain.horario.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.edu.ifce.sistematransporteapi.application.converter.DiaDaSemanaConverter;
import br.edu.ifce.sistematransporteapi.application.enums.DiaDaSemana;
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
	
	@Convert(converter = DiaDaSemanaConverter.class)
	@Column(name = "DIADASEMANA")
	@Getter @Setter
	private DiaDaSemana dia;
	
	@Column(name = "HORA")
	@Getter @Setter
	private LocalTime hora;
}
