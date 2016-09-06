package com.hmw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hmw.dao.ExamesDAO;
import com.hmw.sql.SQLExames;
import com.hmw.vo.ExameVO;
import com.hmw.vo.ImagemVO;

@Repository
@Transactional
public class ExamesDAOImpl implements ExamesDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ExameVO> getExames() {
		List<ExameVO> retorno = new ArrayList<ExameVO>();

		List<Object[]> results = this.em.createNativeQuery(SQLExames.getExames()).getResultList();

		results.stream().forEach((record) -> {
			ExameVO exame = new ExameVO();
			exame.setId((Integer) record[0]);
			exame.setDescricao(record[1].toString());
			retorno.add(exame);
		});
		return retorno;
	}

	@Override
	public ExameVO getExame(Integer id, Boolean carregaImagens) {
		List<Object[]> results = this.em.createNativeQuery(SQLExames.getExame(id, carregaImagens)).getResultList();
		ExameVO retorno = new ExameVO();
		retorno.setImagens(new ArrayList<>());
		ImagemVO imagemVO = null;
		for (int i = 0; i < results.size(); i++) {
			Object[] record = results.get(i);
			imagemVO = new ImagemVO();
			retorno.setCodigoPaciente((Integer) record[0]);
			retorno.setNomePaciente((String) record[1]);
			retorno.setId((Integer) record[2]);
			retorno.setDescricao((String) record[3]);
			retorno.setIndicacao((String) record[4]);
			retorno.setCpf((String) record[8]);
			imagemVO.setDescricao((String) record[5]);
			imagemVO.setMensagem((String) record[6]);
			imagemVO.setImgId(new Long(record[7].toString()));
			imagemVO.setExame((Integer) record[2]);
			try {
				imagemVO.setImg((byte[]) record[9]);
			} catch (Exception e) {
				// TODO: handle exception
			}
				
			retorno.getImagens().add(imagemVO);
		}

		return retorno;
	}
/*
	@Override
	public ExameVO getImagensExame(Integer id) {
		List<Object[]> results = this.em.createNativeQuery(SQLExames.getExameImagens(id)).getResultList();
		ExameVO retorno = new ExameVO();
		retorno.setImagens(new ArrayList<>());
		ImagemVO imagemVO = null;
		for (int i = 0; i < results.size(); i++) {
			Object[] record = results.get(i);
			imagemVO = new ImagemVO();
			retorno.setCodigoPaciente((Integer) record[0]);
			retorno.setNomePaciente((String) record[1]);
			retorno.setId((Integer) record[2]);
			retorno.setDescricao((String) record[3]);
			retorno.setIndicacao((String) record[4]);
			imagemVO.setDescricao((String) record[5]);
			imagemVO.setMensagem((String) record[6]);
			imagemVO.setImg((byte[]) record[7]);
			imagemVO.setImgId(new Long(record[8].toString()));
			imagemVO.setExame((Integer) record[2]);
			retorno.getImagens().add(imagemVO);
		}

		return retorno;
	}*/

	
	/*
	 * 	public static String getExameImagens(Integer id) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT paciente.id AS idPaciente, \n");
		sb.append("		paciente.nome, \n");
		sb.append("		exame.id AS idExame, \n");
		sb.append("		exame.descricao,   \n");
		sb.append("		exame.indicacao AS indicacao, \n");
		sb.append("		detalhe_imagem.descricao AS descricao_imagem, \n");
		sb.append("		detalhe_imagem.mensagem AS mensagem_imagem, \n");
		sb.append("		imagem.img, \n");
		sb.append("		detalhe_imagem.id, \n");
		sb.append("		paciente.cpf \n");
		sb.append("FROM exame \n");
		sb.append("LEFT JOIN paciente ON (paciente.id = exame.paciente_id) \n");
		sb.append("LEFT JOIN detalhe_imagem ON (detalhe_imagem.id is not null) \n");
		sb.append("LEFT JOIN imagem ON (imagem.detalhe_imagem_id = detalhe_imagem.id AND imagem.exame_id = exame.id) \n");
		sb.append("WHERE exame.id = " + id);
		return sb.toString();
	}*/
	 
}
