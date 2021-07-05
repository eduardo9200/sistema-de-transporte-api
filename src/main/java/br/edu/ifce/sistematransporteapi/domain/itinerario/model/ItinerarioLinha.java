package br.edu.ifce.sistematransporteapi.domain.itinerario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.edu.ifce.sistematransporteapi.domain.linha.model.Linha;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "SITP", name = "ITINERARIOLINHA")
@SequenceGenerator(name = "SEQ_ITINERARIOLINHA", sequenceName = "SEQ_ITINERARIOLINHA", schema = "SITP", allocationSize = 1, initialValue = 1)
public class ItinerarioLinha {

	@Id
	@Column(name = "IDITINERARIOLINHA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITINERARIOLINHA")
	@Getter @Setter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "IDITINERARIO")
	@Getter @Setter
	private Itinerario itinerario;
	
	@ManyToOne
	@JoinColumn(name = "IDLINHA")
	@Getter @Setter
	private Linha linha;
}
