package br.edu.ifce.sistematransporteapi.domain.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.sistematransporteapi.domain.horario.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

}
