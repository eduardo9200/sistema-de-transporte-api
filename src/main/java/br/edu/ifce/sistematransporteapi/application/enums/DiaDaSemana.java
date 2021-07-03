package br.edu.ifce.sistematransporteapi.application.enums;

public enum DiaDaSemana {

	SEGUNDA("SEGUNDA"),
	TERCA("TERÇA"),
	QUARTA("QUARTA"),
	QUINTA("QUINTA"),
	SEXTA("SEXTA"),
	SABADO("SÁBADO"),
	DOMINGO("DOMINGO");
	
	private String dia;
	
	private DiaDaSemana(String dia) {
		this.dia = dia;
	}
	
	public String getDia() {
		return this.dia;
	}
	
	public static DiaDaSemana byDia(String dia) {
		if(dia == null || dia.isEmpty()) {
			throw new RuntimeException("Dia informado inválido.");
		}
		
		dia = dia.toUpperCase();
		for(DiaDaSemana diaDaSemana : values()) {
			if(diaDaSemana.getDia().equals(dia)) {
				return diaDaSemana;
			}
		}
		
		throw new RuntimeException("Dia informado não localizado.");
	}
}
