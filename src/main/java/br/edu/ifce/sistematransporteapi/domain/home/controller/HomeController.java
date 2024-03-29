package br.edu.ifce.sistematransporteapi.domain.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.sistematransporteapi.domain.home.service.BuscaDadosService;
import br.edu.ifce.sistematransporteapi.domain.home.vo.DataList;
import br.edu.ifce.sistematransporteapi.domain.home.vo.QuantidadeTiposDeLinha;

@RestController
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private BuscaDadosService buscaDadosService;

	@GetMapping(value = "/buscar-dados")
	public List<DataList> getDataList() {
		return this.buscaDadosService.buscaDados();
	}
	
	@GetMapping(value = "/buscar-quantitativos-tipos-de-linha")
	public List<QuantidadeTiposDeLinha> getQuantidadeTipos() {
		return this.buscaDadosService.buscaQuantidadeTiposDeLinhas();
	}
}
