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
		return sb.toString();
	}
	
	public static String getLaudo(Integer idExame, Integer idLaudo) {
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT laudo.id, \n");
		sb.append("		exame.descricao, \n");
		sb.append("		exame.indicacao, \n");
		sb.append("		laudo.conclusao, \n");
		sb.append("		laudo.descricao_estudo, \n");
		sb.append("		laudo.outras_informacoes, \n");
		sb.append("		sl.descricao AS descricaosecao, \n");
		sb.append("		dl.nome, \n");
		sb.append("		dlmarcado.id IS NOT NULL AS marcado, \n");
		sb.append("		dl.id AS dlId, \n");
		sb.append("		sl.id AS secao_id \n");
		sb.append("FROM exame \n");
		sb.append("LEFT JOIN secao_laudo sl ON (sl.id is not null) \n");
		sb.append("LEFT JOIN secao_laudo_detalhe_laudo sldl ON sldl.secaolaudo_id	= sl.id \n");
		sb.append("LEFT JOIN detalhe_laudo dl ON sldl.detalhelaudo_id = dl.id \n");
		sb.append("LEFT JOIN laudo ON laudo.exame_id = exame.id \n");
		sb.append("LEFT JOIN laudo_detalhe_laudo ldl ON ldl.laudo_id = laudo.id \n");
		sb.append("LEFT JOIN detalhe_laudo dlmarcado ON (ldl.detalhelaudo_id = dlmarcado.id AND dl.id = dlmarcado.id) \n");
		sb.append("WHERE exame.id = " + idExame + " \n");
		if (idLaudo != null) {
			sb.append("		AND laudo.id = " + idLaudo + " \n");
		}
		sb.append("ORDER BY sl.id, ordem; \n");

		
		
 
		return sb.toString();
	}
}
