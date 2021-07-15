package br.edu.ifce.sistematransporteapi.domain.home.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import br.edu.ifce.sistematransporteapi.application.enums.TipoLinha;
import br.edu.ifce.sistematransporteapi.domain.home.repository.HomeRepository;
import br.edu.ifce.sistematransporteapi.domain.home.vo.DataObject;
import br.edu.ifce.sistematransporteapi.domain.home.vo.QuantidadeTiposDeLinha;

@Repository
public class HomeRepositoryImpl implements HomeRepository {

	@Value(value = "${spring.datasource.url}")
	private String url;
	
	@Value(value = "${spring.datasource.username}")
	private String username;
	
	@Value(value = "${spring.datasource.password}")
	private String password;
	
	@Override
	public List<DataObject> getDataList() {

		List<DataObject> dataList = new ArrayList<DataObject>();
		
		StringBuilder sql = new StringBuilder();
		//Main query
		sql.append("SELECT NUMERO_LINHA, NOME_LINHA, LINHA_ATIVA, RESUMO_ITINERARIO, INICIO_DIA_UTIL, FIM_DIA_UTIL, INICIO_SABADO, FIM_SABADO,");
		sql.append(" INICIO_DOMINGO_E_FERIADO, FIM_DOMINGO_E_FERIADO, INTERVALO_DIA_UTIL, INTERVALO_SABADO, INTERVALO_DOMINGO_E_FERIADO");
		sql.append(" FROM ");
		//Sub-query Q1:
		sql.append("(SELECT l.idLinha AS ID_LINHA, l.numero AS NUMERO_LINHA, l.nome AS NOME_LINHA, l.ativa AS LINHA_ATIVA, i.resumo AS RESUMO_ITINERARIO");
		sql.append(" FROM sitp.linha l ");
		sql.append("LEFT JOIN sitp.itinerario i ON i.idLinha = l.idlinha");
		sql.append(") Q1");
		sql.append(" LEFT JOIN ");
		//Sub-query Q2:
		sql.append("(SELECT h.idLinha AS ID_LINHA, h.inicioDiaUtil AS INICIO_DIA_UTIL, h.fimDiaUtil AS FIM_DIA_UTIL, h.inicioSabado AS INICIO_SABADO, h.fimSabado AS FIM_SABADO,");
		sql.append(" h.inicioDomingoEFeriado AS INICIO_DOMINGO_E_FERIADO, h.fimDomingoEFeriado AS FIM_DOMINGO_E_FERIADO,");
		sql.append(" h.intervaloDiaUtil AS INTERVALO_DIA_UTIL, h.intervaloSabado AS INTERVALO_SABADO, h.intervalodomingoEFeriado AS INTERVALO_DOMINGO_E_FERIADO");
		sql.append(" FROM sitp.horario h");
		sql.append(") Q2");
		sql.append(" ON Q1.ID_LINHA = Q2.ID_LINHA");
		
		System.out.println(sql.toString());
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement pesquisa = connection.prepareStatement(sql.toString());
			ResultSet result = pesquisa.executeQuery();
			
			while(result.next()) {
				DataObject data = new DataObject();
				data.setNumeroLinha(result.getLong("NUMERO_LINHA"));
				data.setNomeLinha(result.getString("NOME_LINHA"));
				data.setLinhaAtiva(result.getBoolean("LINHA_ATIVA"));
				data.setResumoItinerario(result.getString("RESUMO_ITINERARIO"));
				data.setInicioDiaUtil(result.getString("INICIO_DIA_UTIL"));
				data.setFimDiaUtil(result.getString("FIM_DIA_UTIL"));
				data.setInicioSabado(result.getString("INICIO_SABADO"));
				data.setFimSabado(result.getString("FIM_SABADO"));
				data.setInicioDomingoEFeriado(result.getString("INICIO_DOMINGO_E_FERIADO"));
				data.setFimDomingoEFeriado(result.getString("FIM_DOMINGO_E_FERIADO"));
				data.setIntervaloDiaUtil(result.getLong("INTERVALO_DIA_UTIL"));
				data.setIntervaloSabado(result.getLong("INTERVALO_SABADO"));
				data.setIntervaloDomingoEFeriado(result.getLong("INTERVALO_DOMINGO_E_FERIADO"));
				
				dataList.add(data);
			}
			
			return dataList;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<QuantidadeTiposDeLinha> getQuantidadeTiposDeLinha() {
		List<QuantidadeTiposDeLinha> quantidades = new ArrayList<QuantidadeTiposDeLinha>();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT l.tipo AS TIPO_LINHA, COUNT(l.tipo) AS QUANTIDADE_TIPO_LINHA");
		sql.append(" FROM sitp.linha l");
		sql.append(" GROUP BY l.tipo");
		
		System.out.println(sql.toString());
		
		try {
			Connection connection;
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement pesquisa = connection.prepareStatement(sql.toString());
			ResultSet result = pesquisa.executeQuery();
			
			while(result.next()) {
				QuantidadeTiposDeLinha qtd = new QuantidadeTiposDeLinha();
				qtd.setTipo(TipoLinha.bySigla(result.getString("TIPO_LINHA")));
				qtd.setQuantidade(result.getLong("QUANTIDADE_TIPO_LINHA"));
				
				quantidades.add(qtd);
			}
			
			return quantidades;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}