package br.edu.ifce.sistematransporteapi.domain.itinerario.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.edu.ifce.sistematransporteapi.application.converter.SentidoLinhaConverter;
import br.edu.ifce.sistematransporteapi.application.enums.SentidoLinha;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "SITP", name = "ITINERARIO")
@SequenceGenerator(name = "SEQ_ITINERARIO", sequenceName = "SEQ_ITINERARIO", schema = "SITP", allocationSize = 1, initialValue = 1)
public class Itinerario {

	@Id
	@Column(name = "IDITINERARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITINERARIO")
	@Getter @Setter
	private Long id;
	
	@Column(name = "ITINERARIO")
	@Getter @Setter
	private String descricao;
	
	@Column(name = "RESUMO")
	@Getter @Setter
	private String resumo;
	
	@Convert(converter = SentidoLinhaConverter.class)
	@Column(name = "SENTIDO")
	@Getter @Setter
	private SentidoLinha sentido;
	
	@Column(name = "PONTOINICIAL")
	@Getter @Setter
	private String pontoInicial;
	
	@Column(name = "PONTOFINAL")
	@Getter @Setter
	private String pontoFinal;
}
