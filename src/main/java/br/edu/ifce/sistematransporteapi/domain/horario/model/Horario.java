package br.edu.ifce.sistematransporteapi.domain.horario.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.ifce.sistematransporteapi.application.converter.DiaDaSemanaConverter;
import br.edu.ifce.sistematransporteapi.application.enums.DiaDaSemana;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "", name = "HORARIO")
public class Horario {

	@Id
	@Column(name = "IDHORARIO")
	@Getter @Setter
	private Long id;
	
	@Convert(converter = DiaDaSemanaConverter.class)
	@Column(name = "DIADASEMANA")
	@Getter @Setter
	private DiaDaSemana dia;
	
	@Column(name = "HORASAIDA")
	@Getter @Setter
	private LocalTime hora;
}
