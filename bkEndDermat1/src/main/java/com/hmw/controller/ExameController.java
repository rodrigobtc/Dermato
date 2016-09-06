package com.hmw.controller;

import java.util.Collection;

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

import com.hmw.model.Exame;
import com.hmw.service.ExameService;
import com.hmw.service.PacienteService;
import com.hmw.vo.ExameVO;

@RestController
public class ExameController {

	@Autowired
	ExameService exameService;

	@Autowired
	PacienteService pacienteService;

	@RequestMapping("/exame")
	public String irParaUpload() {
		return "exame";
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/exames/{id}/{carregaImagens}", method = { RequestMethod.GET })
	public ResponseEntity<?> getExame(@PathVariable Integer id, @PathVariable Boolean carregaImagens) {
		try {
			ResponseEntity<ExameVO> responseEntity = new ResponseEntity<>(exameService.localizar(id, carregaImagens), HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.PUT, value = "/exames", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Exame> atualizarExame(@RequestBody ExameVO exame) {
		Exame cadastro = new Exame();
		cadastro.setId(exame.getId());

		return new ResponseEntity<>(exameService.atualizar(cadastro), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value = "/exames", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Exame> cadastrarExame(@RequestBody ExameVO exame) {
		try {
			Exame cadastro = new Exame();

			cadastro.setDescricao(exame.getDescricao());
			cadastro.setIndicacao(exame.getIndicacao());
			cadastro.setPaciente(pacienteService.localizar(exame.getCodigoPaciente()));

			return new ResponseEntity<>(exameService.cadastrar(cadastro), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, value = "/exames", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<ExameVO>> consultarUsuarios() {
		Collection<ExameVO> consultarTodos = exameService.consultarTodos();

		return new ResponseEntity<>(consultarTodos, HttpStatus.OK);
	}

}
