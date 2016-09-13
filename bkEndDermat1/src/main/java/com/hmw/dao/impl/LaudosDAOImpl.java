package com.hmw.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hmw.dao.LaudosDAO;
import com.hmw.model.TipoDetalheLaudo;
import com.hmw.sql.SQLLaudos;

@Repository
@Transactional
public class LaudosDAOImpl implements LaudosDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TipoDetalheLaudo> getTipoDetalheLaudo(String tipo) {
		List<Object[]> listaLaudos = this.em.createNativeQuery(SQLLaudos.getTipoDetalheLaudo(tipo)).getResultList();
		List<TipoDetalheLaudo> retorno = new ArrayList<>();
		TipoDetalheLaudo obj = null;
		for (Iterator<Object[]> iterator = listaLaudos.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			obj = new TipoDetalheLaudo();
			obj.setId((Integer) objects[0]);
			obj.setDescricao((String) objects[1]);
			obj.setTipo((String) objects[2]);
			retorno.add(obj);
		}
		return retorno;
	}
}
