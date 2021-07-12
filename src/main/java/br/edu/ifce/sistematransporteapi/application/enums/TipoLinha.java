package br.edu.ifce.sistematransporteapi.application.enums;

public enum TipoLinha {

	CIRCULAR("CI", "Circular"),
	TERMINAL_TERMINAL("TT", "Terminal-Terminal"),
	TERMINAL_BAIRRO("TB", "Terminal-Bairro"),
	BAIRRO_BAIRRO("BB", "Bairro-Bairro");
	
	private String sigla;
	private String descricao;
	
	private TipoLinha(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}
	
	public String getSigla() {
		return this.sigla;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoLinha bySigla(String sigla) {
		if(sigla == null || sigla.isEmpty()) {
			return null;
		}
		
		for(TipoLinha tipo : values()) {
			if(tipo.getSigla().equals(sigla))
				return tipo;
		}
		throw new RuntimeException("Sigla do tipo de linha não localizada.");
	}
}
