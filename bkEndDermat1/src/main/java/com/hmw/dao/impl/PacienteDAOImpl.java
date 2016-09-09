package com.hmw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hmw.dao.PacienteDAO;
import com.hmw.sql.SQLPacientes;
import com.hmw.vo.PacienteVO;

@Repository
@Transactional
public class PacienteDAOImpl implements PacienteDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<PacienteVO> getPacientes(String nome) {
		List<PacienteVO> retorno = new ArrayList<PacienteVO>();

		List<Object[]> results = this.em.createNativeQuery(SQLPacientes.getPacientes(nome)).getResultList();

		results.stream().forEach((record) -> {
			PacienteVO pacientevo = new PacienteVO();
			pacientevo.setId((Integer) record[0]);
			pacientevo.setNome(record[1].toString());
			retorno.add(pacientevo);
		});
		return retorno;
	}

}
