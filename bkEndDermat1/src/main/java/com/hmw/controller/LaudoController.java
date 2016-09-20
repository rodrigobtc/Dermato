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

import com.hmw.model.Laudo;
import com.hmw.model.SecaoLaudo;
import com.hmw.service.ExameService;
import com.hmw.service.LaudoService;
import com.hmw.vo.DetalheLaudoVO;
import com.hmw.vo.LaudoVO;

@RestController
public class LaudoController {

	@Autowired
	LaudoService laudoService;
	
	@Autowired
	ExameService exameService;

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET, value = "/laudo/{exameId}/{laudoId}")
	public ResponseEntity<LaudoVO> getTipoDetalheLaudo(@PathVariable Integer exameId,
			@PathVariable Integer laudoId) {
		LaudoVO laudos = laudoService.getLaudo(exameId, laudoId).get(0);
		return new ResponseEntity<>(laudos, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value = "/secoeslaudo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addSecaoLaudo(@RequestBody SecaoLaudo secao) {
		laudoService.cadastrarSecaoLaudo(secao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value = "/laudo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Laudo> cadastrarLaudo(@RequestBody LaudoVO laudo) {
		try {
			return new ResponseEntity<>(laudoService.cadastrar(laudo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
