package br.edu.ifce.sistematransporteapi.domain.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifce.sistematransporteapi.domain.home.vo.DataObject;

@Repository
public interface HomeRepository {

	@Query(value = "SELECT" +
				"NUMERO_LINHA, NOME_LINHA, LINHA_ATIVA, RESUMO_ITINERARIO," +
				"INICIO_DIA_UTIL, FIM_DIA_UTIL, INICIO_SABADO, FIM_SABADO, INICIO_DOMINGO_E_FERIADO, FIM_DOMINGO_E_FERIADO" +
			"FROM (" +
				"SELECT" +
					"h.inicioDiaUtil AS INICIO_DIA_UTIL," +
					"h.fimDiaUtil AS FIM_DIA_UTIL," +
					"h.inicioSabado AS INICIO_SABADO," +
					"h.fimSabado AS FIM_SABADO," +
					"h.inicioDomingo AS INICIO_DOMINGO_E_FERIADO," +
					"h.fimDomingo AS FIM_DOMINGO_E_FERIADO" +
				"FROM" +
					"(" +
						"SELECT l.numero AS NUMERO_LINHA, l.nome AS NOME_LINHA, l.ativa AS LINHA_ATIVA, i.resumo AS RESUMO_ITINERARIO" +
						"FROM" +
							"Linha l" +
								"LEFT JOIN Itinerario i ON i.idLinha = l.idLinha" +
								"LEFT JOIN Horario h ON h.idLinha = l.idLinha" +
							"GROUP BY l.nome" +
						")" +
			")", nativeQuery = true)
	public List<DataObject> getDataList();
}
