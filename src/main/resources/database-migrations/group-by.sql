SELECT
	l.tipo AS TIPO_LINHA,
	COUNT(l.tipo) AS QUANTIDADE_TIPO_LINHA
FROM sitp.linha l
GROUP BY l.tipo;