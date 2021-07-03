package br.edu.ifce.sistematransporteapi.domain.horario.model;

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
@Table(schema = "", name = "HORARIOLINHA")
public class HorarioLinha {

	@Id
	@Column(name = "IDHORARIOLINHA")
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
