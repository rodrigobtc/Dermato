package com.hmw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hmw.model.Paciente;
import com.hmw.service.PacienteService;
import com.hmw.vo.PacienteVO;

@RestController
public class PacienteController {

	@Autowired
	PacienteService pacienteService;

	@RequestMapping(method = RequestMethod.POST, value = "/pacientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody PacienteVO paciente) {
		Paciente pacienteDAO = new Paciente();
		pacienteDAO.setNascimento(paciente.getNascimento());
		pacienteDAO.setNome(paciente.getNome());
		Paciente pacienteCadastrado = pacienteService.cadastrar(pacienteDAO);
		return new ResponseEntity<>(pacienteCadastrado, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/pacientes/{nome}", method = { RequestMethod.GET })
	public ResponseEntity<List<PacienteVO>> procurarPaciente(@PathVariable String nome) {
		List<PacienteVO> procurarPaciente = pacienteService.procurarPaciente(nome);
		return new ResponseEntity<>(procurarPaciente, HttpStatus.OK);
	}
}
