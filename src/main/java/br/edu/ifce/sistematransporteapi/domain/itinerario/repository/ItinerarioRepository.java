package br.edu.ifce.sistematransporteapi.domain.itinerario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ifce.sistematransporteapi.domain.itinerario.model.Itinerario;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> {

	@Query("SELECT i FROM Itinerario i ORDER BY i.linha.nome ASC")
	public List<Itinerario> buscaTodosItinerarios();
	
	@Query("SELECT i FROM Itinerario i WHERE i.linha.numero = :numero")
	public List<Itinerario> itinerariosDaLinhaByNumero(@Param("numero") Long numero);
	
	@Query("SELECT i FROM Itinerario i WHERE UPPER(i.linha.nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
	public List<Itinerario> itinerariosDaLinhaByNome(@Param("nome") String nome);
	
	@Query("SELECT i FROM Itinerario i WHERE UPPER(i.descricao) LIKE UPPER(CONCAT('%', :logradouro, '%'))")
	public List<Itinerario> itinerariosByLogradouro(@Param("logradouro") String logradouro);
}
