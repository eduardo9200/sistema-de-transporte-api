package br.edu.ifce.sistematransporteapi.domain.itinerario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.ifce.sistematransporteapi.domain.linha.model.Linha;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "", name = "ITINERARIOLINHA")
public class ItinerarioLinha {

	@Id
	@Column(name = "IDITINERARIOLINHA")
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
