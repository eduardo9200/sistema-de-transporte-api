package br.edu.ifce.sistematransporteapi.domain.horario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ifce.sistematransporteapi.domain.horario.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

	public List<Horario> findHorarioByOrderByLinhaNome(String nome);
	
	public Optional<Horario> findByLinhaNumero(Long numero);
	
	@Query("SELECT h FROM Horario h WHERE UPPER(h.linha.nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
	public List<Horario> buscaPeloNomeLinha(@Param("nome") String nome);
}
