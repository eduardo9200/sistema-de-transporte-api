package br.edu.ifce.sistematransporteapi.application.enums;

public enum ItemPesquisaLinha {

	TODAS(0L),
	NUMERO(1L),
	NOME(2L);
	
	private Long id;
	
	private ItemPesquisaLinha(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public static ItemPesquisaLinha byId(Long id) {
		for(ItemPesquisaLinha item : values()) {
			if(item.getId() == id)
				return item;
		}
		throw new RuntimeException("ID de pesquisa de linha inválido.");
	}
}
