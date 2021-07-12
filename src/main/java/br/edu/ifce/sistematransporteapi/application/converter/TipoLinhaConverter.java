package br.edu.ifce.sistematransporteapi.application.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.edu.ifce.sistematransporteapi.application.enums.TipoLinha;

@Converter()
public class TipoLinhaConverter implements AttributeConverter<TipoLinha, String> {

	@Override
	public String convertToDatabaseColumn(TipoLinha attribute) {
		return attribute.getSigla();
	}

	@Override
	public TipoLinha convertToEntityAttribute(String dbData) {
		return TipoLinha.bySigla(dbData);
	}

}
