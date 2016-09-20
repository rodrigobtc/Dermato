package com.hmw.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hmw.dao.LaudosDAO;
import com.hmw.sql.SQLLaudos;
import com.hmw.vo.DetalheLaudoVO;
import com.hmw.vo.ExameVO;
import com.hmw.vo.LaudoVO;
import com.hmw.vo.SecaoLaudoVO;

@Repository
@Transactional
public class LaudosDAOImpl implements LaudosDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<LaudoVO> getLaudo(Integer idExame, Integer idLaudo) {
		List<LaudoVO> retorno = new ArrayList<>();
		List<Object[]> listaLaudos = this.em.createNativeQuery(SQLLaudos.getLaudo(idExame, idLaudo)).getResultList();
		List<DetalheLaudoVO> detalhes = null;
		BigInteger laudoAtual = null;
		BigInteger secaoAtual = null;
		LaudoVO laudoVO = null;
		for (Iterator<Object[]> iterator = listaLaudos.iterator(); iterator.hasNext();) {
			Object[] res = (Object[]) iterator.next();
			if (res[0] != null && res[0] != laudoAtual) {
				laudoAtual = (BigInteger) res[0];
				laudoVO = getLaudo(res);
				retorno.add(laudoVO);
			}
			if (secaoAtual != res[10]) {
				detalhes = new ArrayList<>();
				secaoAtual = (BigInteger) res[10];
				laudoVO.getSecoesLaudo().add(getSecaoLaudo(detalhes, res));
			}
			detalhes.add(getDetalheLaudo(res));
		}
		return retorno;
	}

	private DetalheLaudoVO getDetalheLaudo(Object[] res) {
		DetalheLaudoVO detalheLaudoVO;
		detalheLaudoVO = new DetalheLaudoVO();
		detalheLaudoVO.setDescricao((String) res[7]);
		detalheLaudoVO.setMarcado(res[8] != null ? (Boolean) res[8] : false);
		detalheLaudoVO.setId((Long) res[9]);
		return detalheLaudoVO;
	}

	private SecaoLaudoVO getSecaoLaudo(List<DetalheLaudoVO> detalhes, Object[] res) {
		SecaoLaudoVO secaoLaudoVO;
		secaoLaudoVO = new SecaoLaudoVO();
		secaoLaudoVO.setDescricao((String) res[6]);
		secaoLaudoVO.setDetalhesLaudo(detalhes);
		return secaoLaudoVO;
	}

	private LaudoVO getLaudo(Object[] res) {
		LaudoVO laudoVO;
		laudoVO = new LaudoVO();
		laudoVO.setLaudoId((BigInteger) res[0]);
		laudoVO.setExame(getDadosExame(res));
		laudoVO.setConclusao((String) res[3]);
		laudoVO.setDescricaoEstudo((String) res[4]);
		laudoVO.setOutrasInformacoes((String) res[5]);
		laudoVO.setSecoesLaudo(new ArrayList<>());
		return laudoVO;
	}

	private ExameVO getDadosExame(Object[] res) {
		ExameVO exameVO;
		exameVO = new ExameVO();
		exameVO.setDescricao((String) res[1]);
		exameVO.setIndicacao((String) res[2]);
		return exameVO;
	}
}
