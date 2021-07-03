package br.edu.ifce.sistematransporteapi.application.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.edu.ifce.sistematransporteapi.application.enums.DiaDaSemana;

@Converter()
public class DiaDaSemanaConverter implements AttributeConverter<DiaDaSemana, String> {

	@Override
	public String convertToDatabaseColumn(DiaDaSemana attribute) {
		return attribute.getDia();
	}

	@Override
	public DiaDaSemana convertToEntityAttribute(String dbData) {
		return DiaDaSemana.byDia(dbData);
	}

}
