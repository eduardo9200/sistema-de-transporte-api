package br.edu.ifce.sistematransporteapi.domain.horario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifce.sistematransporteapi.domain.horario.service.BuscaHorarioService;
import br.edu.ifce.sistematransporteapi.domain.horario.service.DeleteHorarioService;
import br.edu.ifce.sistematransporteapi.domain.horario.service.HorarioBuilderService;
import br.edu.ifce.sistematransporteapi.domain.horario.service.SalvaHorarioService;
import br.edu.ifce.sistematransporteapi.domain.horario.vo.HorarioVO;

@RestController
@RequestMapping("horario")
public class HorarioController {

	@Autowired
	private BuscaHorarioService buscaHorarioService;
	@Autowired
	private SalvaHorarioService salvaHorarioSercice;
	@Autowired
	private DeleteHorarioService deleteHorarioService;
	@Autowired
	private HorarioBuilderService horarioBuilderService;
	
	@GetMapping(value="/buscar/{itemId}/{texto}")
	public List<HorarioVO> buscarHorario(@PathVariable("itemId") Long itemId, @PathVariable("texto") String texto) {
		return this.buscaHorarioService.buscar(itemId, texto);
	}
	
	@PostMapping(value="/salvar-horario")
	public HorarioVO salvarHorario(@RequestBody HorarioVO horario) {
		return this.horarioBuilderService.buildToRead(this.salvaHorarioSercice.salvar(horario));
	}
	
	@DeleteMapping(value="/delete/id/{id}")
	public boolean deleteHorario(@PathVariable("id") Long id) {
		this.deleteHorarioService.delete(id);
		return true;
	}
}
