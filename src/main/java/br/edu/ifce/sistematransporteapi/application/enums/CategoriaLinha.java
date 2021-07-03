package br.edu.ifce.sistematransporteapi.application.enums;

public enum CategoriaLinha {

	URBANO("U", "URBANO"),
	ALTERNATIVO("A", "ALTERNATIVO"),
	INTERURBANO("I", "INTERURBANO");
	
	private String codigo;
	private String descricao;
	
	private CategoriaLinha(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static CategoriaLinha byCodigo(String codigo) {
		if(codigo == null || codigo.isEmpty()) {
			throw new RuntimeException("Código da categoria da linha informado inválido.");
		}
		
		codigo = codigo.toUpperCase();
		for(CategoriaLinha categoria : values()) {
			if(categoria.getCodigo().equals(codigo)) {
				return categoria;
			}
		}
		
		throw new RuntimeException("Não foi possível identificar a categoria da linha.");
	}
}
