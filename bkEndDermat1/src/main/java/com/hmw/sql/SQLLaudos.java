package com.hmw.sql;

public class SQLLaudos {
	public static String getTipoDetalheLaudo(String tipo) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT id, \n");
		sb.append("		descricao, \n");
		sb.append("		tipo \n");
		sb.append("FROM tipo_detalhe_laudo \n");
		if (tipo != null) {
			sb.append("WHERE tipo = '" + tipo + "' \n");
		}
		sb.append("ORDER BY ordem \n");
		return sb.toString();
	}
}
