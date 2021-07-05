package br.edu.ifce.sistematransporteapi.domain.itinerario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.sistematransporteapi.domain.itinerario.model.Itinerario;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> {

}
