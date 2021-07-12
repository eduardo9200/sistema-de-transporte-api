package br.edu.ifce.sistematransporteapi.domain.linha.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifce.sistematransporteapi.application.enums.ItemPesquisaLinha;
import br.edu.ifce.sistematransporteapi.domain.linha.model.Linha;
import br.edu.ifce.sistematransporteapi.domain.linha.repository.LinhaRepository;
import br.edu.ifce.sistematransporteapi.domain.linha.vo.LinhaVO;

@Service
public class BuscaLinhaService {
	
	@Autowired
	private LinhaRepository linhaRepository;
	@Autowired
	private LinhaBuilderService linhaBuilderService;
	
	public List<LinhaVO> buscaTodasAsLinhas() {
		return this.linhaBuilderService.buildToRead(this.linhaRepository.findLinhaByOrderByNome());
	}
	
	public List<LinhaVO> buscaLinha(Long itemId, String texto) {
		ItemPesquisaLinha item = ItemPesquisaLinha.byId(itemId);
		List<Linha> linhas;
		
		switch(item) {
		case TODAS:
			linhas = this.linhaRepository.findLinhaByOrderByNome();
			break;
		case NUMERO:
			linhas = this.linhaRepository.findByNumero(Long.parseLong(texto));
			break;
		case NOME:
			linhas = this.linhaRepository.buscaPeloNome(texto);
			break;
		default:
			linhas = Collections.emptyList();
		}
		
		return this.linhaBuilderService.buildToRead(linhas);
	}
}
