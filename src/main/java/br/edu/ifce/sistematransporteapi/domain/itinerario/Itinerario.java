package br.edu.ifce.sistematransporteapi.domain.itinerario;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.ifce.sistematransporteapi.application.converter.SentidoLinhaConverter;
import br.edu.ifce.sistematransporteapi.application.enums.SentidoLinha;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "", name = "ITINERARIO")
public class Itinerario {

	@Id
	@Column(name = "IDITINERARIO")
	@Getter @Setter
	private Long id;
	
	@Column(name = "DESCRICAOITINERARIO")
	@Getter @Setter
	private String descricao;
	
	@Column(name = "RESUMOITINERARIO")
	@Getter @Setter
	private String resumo;
	
	@Column(name = "ENDERECOPONTOINICIAL")
	@Getter @Setter
	private String pontoInicial;
	
	@Column(name = "ENDERECOPONTOFINAL")
	@Getter @Setter
	private String pontoFinal;
	
	@Convert(converter = SentidoLinhaConverter.class)
	@Column(name = "SENTIDO")
	@Getter @Setter
	private SentidoLinha sentido;
}
