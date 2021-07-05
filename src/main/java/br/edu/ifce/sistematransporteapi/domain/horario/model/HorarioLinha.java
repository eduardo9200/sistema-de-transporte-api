package br.edu.ifce.sistematransporteapi.domain.horario.model;

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
@Table(schema = "SITP", name = "HORARIOLINHA")
@SequenceGenerator(name = "SEQ_HORARIOLINHA", sequenceName = "SEQ_HORARIOLINHA", schema = "SITP", allocationSize = 1, initialValue = 1)
public class HorarioLinha {

	@Id
	@Column(name = "IDHORARIOLINHA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HORARIOLINHA")
	@Getter @Setter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "IDHORARIO")
	@Getter @Setter
	private Horario horario;
	
	@ManyToOne
	@JoinColumn(name = "IDLINHA")
	@Getter @Setter
	private Linha linha;
}
