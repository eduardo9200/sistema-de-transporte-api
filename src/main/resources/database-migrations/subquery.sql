SELECT
	NUMERO_LINHA,
	NOME_LINHA,
	LINHA_ATIVA,
	RESUMO_ITINERARIO,
	INICIO_DIA_UTIL,
	FIM_DIA_UTIL,
	INICIO_SABADO,
	FIM_SABADO,
	INICIO_DOMINGO_E_FERIADO,
	FIM_DOMINGO_E_FERIADO,
	INTERVALO_DIA_UTIL,
	INTERVALO_SABADO,
	INTERVALO_DOMINGO_E_FERIADO
FROM
    (SELECT  l.idLinha AS ID_LINHA,
             l.numero AS NUMERO_LINHA,
             l.nome AS NOME_LINHA,
             l.ativa AS LINHA_ATIVA,
             i.resumo AS RESUMO_ITINERARIO
    FROM sitp.linha l
        LEFT JOIN sitp.itinerario i ON i.idLinha = l.idlinha
    ) Q1
    
    LEFT JOIN
    
    (SELECT h.idLinha AS ID_LINHA,
            h.inicioDiaUtil AS INICIO_DIA_UTIL,
            h.fimDiaUtil AS FIM_DIA_UTIL,
            h.inicioSabado AS INICIO_SABADO,
            h.fimSabado AS FIM_SABADO,
            h.inicioDomingoEFeriado AS INICIO_DOMINGO_E_FERIADO,
            h.fimDomingoEFeriado AS FIM_DOMINGO_E_FERIADO,
            h.intervaloDiaUtil AS INTERVALO_DIA_UTIL,
            h.intervaloSabado AS INTERVALO_SABADO,
            h.intervalodomingoEFeriado AS INTERVALO_DOMINGO_E_FERIADO
    FROM sitp.horario h
    ) Q2
    
    ON Q1.ID_LINHA = Q2.ID_LINHA;
    