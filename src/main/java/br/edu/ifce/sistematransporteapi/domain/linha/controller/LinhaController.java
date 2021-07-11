package br.edu.ifce.sistematransporteapi.domain.linha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.sistematransporteapi.domain.linha.service.BuscaLinhaService;
import br.edu.ifce.sistematransporteapi.domain.linha.service.DeleteLinhaService;
import br.edu.ifce.sistematransporteapi.domain.linha.service.LinhaBuilderService;
import br.edu.ifce.sistematransporteapi.domain.linha.service.SalvaLinhaService;
import br.edu.ifce.sistematransporteapi.domain.linha.vo.LinhaVO;

@RestController
@RequestMapping("linha")
public class LinhaController {

	@Autowired
	private BuscaLinhaService buscaLinhaService;
	@Autowired
	private SalvaLinhaService salvaLinhaService;
	@Autowired
	private DeleteLinhaService deleteLinhaService;
	@Autowired
	private LinhaBuilderService linhaBuilderService;
	
	@GetMapping(value = "/buscar-todas")
	public List<LinhaVO> buscarTodasAsLinhas() {
		return this.buscaLinhaService.buscaTodasAsLinhas();
	}
	
	@GetMapping(value="/pesquisar/{itemId}/{valor}")
	public List<LinhaVO> buscaLinha(@PathVariable("itemId") Long itemId, @PathVariable("valor") String valor) {
		return this.buscaLinhaService.buscaLinha(itemId, valor);
	}
	
	@PostMapping(value="/salva-linha")
	public LinhaVO salvaLinha(@RequestBody LinhaVO linha) {
		return this.linhaBuilderService.buildToRead(this.salvaLinhaService.salvaLinha(linha));
	}
	
	@DeleteMapping(value="/delete/id/{id}")
	public boolean deleteLinha(@PathVariable("id") Long id) {
		this.deleteLinhaService.deleteLinha(id);
		return true;
	}
}
