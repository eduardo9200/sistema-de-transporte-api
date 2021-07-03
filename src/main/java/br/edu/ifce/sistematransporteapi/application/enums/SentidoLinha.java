package br.edu.ifce.sistematransporteapi.application.enums;

public enum SentidoLinha {
	IDA("I", "IDA"),
	VOLTA("V", "VOLTA");
	
	private String codigo;
	private String descricao;
	
	private SentidoLinha(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static SentidoLinha byCodigo(String codigo) {
		if(codigo == null || codigo.isEmpty()) {
			throw new RuntimeException("Código do sentido da linha informado inválido.");
		}
		
		codigo = codigo.toUpperCase();
		for(SentidoLinha sentido : values()) {
			if(sentido.getCodigo().equals(codigo)) {
				return sentido;
			}
		}
		
		throw new RuntimeException("Sentido da linha não localizado.");
	}
}
