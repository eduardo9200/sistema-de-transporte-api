package br.edu.ifce.sistematransporteapi.application.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.edu.ifce.sistematransporteapi.application.enums.CategoriaLinha;

@Converter()
public class CategoriaLinhaConverter implements AttributeConverter<CategoriaLinha, String> {

	@Override
	public String convertToDatabaseColumn(CategoriaLinha attribute) {
		return attribute.getCodigo();
	}

	@Override
	public CategoriaLinha convertToEntityAttribute(String dbData) {
		return CategoriaLinha.byCodigo(dbData);
	}

}
