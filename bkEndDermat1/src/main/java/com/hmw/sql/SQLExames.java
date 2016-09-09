package com.hmw.sql;

public class SQLExames {
	public static String getExames() {
		StringBuffer sb = new StringBuffer();
		sb.append("select id, descricao from exame order by id");
		return sb.toString();
	}

	public static String getExame(Integer id, Boolean carregaImagens) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT paciente.id AS idPaciente, \n");
		sb.append("		paciente.nome, \n");
		sb.append("		exame.id AS idExame, \n");
		sb.append("		exame.descricao,   \n");
		sb.append("		exame.indicacao AS indicacao, \n");
		sb.append("		detalhe_imagem.descricao AS descricao_imagem, \n");
		sb.append("		detalhe_imagem.mensagem AS mensagem_imagem, \n");
		sb.append("		detalhe_imagem.id, \n");
		sb.append("		paciente.cpf \n");
		if (carregaImagens) {
			sb.append("		,imagem.img \n");
		}
		sb.append("FROM exame \n");
		sb.append("LEFT JOIN paciente ON (paciente.id = exame.paciente_id) \n");
		sb.append("LEFT JOIN detalhe_imagem ON (detalhe_imagem.id is not null) \n");
		sb.append("LEFT JOIN imagem ON (imagem.detalhe_imagem_id = detalhe_imagem.id AND imagem.exame_id = exame.id) \n");
		sb.append("WHERE exame.id = " + id);
		return sb.toString();
	}
}
