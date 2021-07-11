package br.edu.ifce.sistematransporteapi.domain.linha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ifce.sistematransporteapi.domain.linha.model.Linha;

@Repository
public interface LinhaRepository extends JpaRepository<Linha, Long> {

	public List<Linha> findLinhaByOrderByNome();
	
	public List<Linha> findByNumero(Long numero);
	
	@Query("SELECT l FROM Linha l WHERE UPPER(l.nome) LIKE UPPER(CONCAT('%', :nome, '%'))")
	public List<Linha> buscaPeloNome(@Param("nome") String nome);
}
