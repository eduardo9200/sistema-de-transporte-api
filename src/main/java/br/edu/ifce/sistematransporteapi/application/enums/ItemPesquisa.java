package br.edu.ifce.sistematransporteapi.application.enums;

public enum ItemPesquisa {

	TODOS(0L),
	NUMERO(1L),
	LINHA(2L),
	LOGRADOURO(3L);
	
	private Long id;
	
	private ItemPesquisa(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public static ItemPesquisa byId(Long id) {
		for(ItemPesquisa item : values()) {
			if(item.getId() == id)
				return item;
		}
		throw new RuntimeException("ID de pesquisa inválido.");
	}
}
