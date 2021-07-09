package br.edu.ifce.sistematransporteapi.domain.itinerario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ifce.sistematransporteapi.domain.itinerario.model.Itinerario;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> {

	@Query("SELECT I FROM ITINERARIO I WHERE I.LINHA.NUMERO = :numero")
	public List<Itinerario> itinerariosDaLinhaByNumero(@Param("numero") Long numero);
	
	@Query("SELECT I FROM ITINERARIO I WHERE I.LINHA.NOME = :nome")
	public List<Itinerario> itinerariosDaLinhaByNome(@Param("nome") String nome);
	
	@Query("SELECT I FROM ITINERARIO I WHERE UPPER(DESCRICAO) LIKE UPPER ('%:logradouro%')")
	public List<Itinerario> itinerariosByLogradouro(@Param("logradouro") String logradouro);
}
