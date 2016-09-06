package com.hmw.dao;

import java.util.List;

import com.hmw.vo.PacienteVO;

public interface PacienteDAO {
	List<PacienteVO> getPacientes(String nome);
}
