package br.edu.ifce.sistematransporteapi.application.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.edu.ifce.sistematransporteapi.application.enums.SentidoLinha;

@Converter()
public class SentidoLinhaConverter implements AttributeConverter<SentidoLinha, String> {

	@Override
	public String convertToDatabaseColumn(SentidoLinha attribute) {
		return attribute.getCodigo();
	}

	@Override
	public SentidoLinha convertToEntityAttribute(String dbData) {
		return SentidoLinha.byCodigo(dbData);
	}

}
