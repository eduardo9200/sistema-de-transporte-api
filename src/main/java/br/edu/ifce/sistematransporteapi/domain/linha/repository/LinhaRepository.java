package br.edu.ifce.sistematransporteapi.domain.linha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifce.sistematransporteapi.domain.linha.model.Linha;

@Repository
public interface LinhaRepository extends JpaRepository<Linha, Long> {

}
