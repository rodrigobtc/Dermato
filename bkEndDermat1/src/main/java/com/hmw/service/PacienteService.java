package com.hmw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmw.dao.PacienteDAO;
import com.hmw.model.Paciente;
import com.hmw.repository.PacienteRepository;
import com.hmw.vo.PacienteVO;

@Service
public class PacienteService {
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	PacienteDAO pacienteDAO;
	
	public Paciente cadastrar(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	
	public List<PacienteVO> procurarPaciente(String nome) {
		//return pacienteRepository.procurarPaciente(nome);
		return pacienteDAO.getPacientes(nome);
	}
	
	public Paciente localizar(Integer id) {
		return pacienteRepository.getOne(id);
	}
}
