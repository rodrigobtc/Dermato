package com.hmw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hmw.model.TipoDetalheLaudo;
import com.hmw.service.LaudoService;

@RestController
public class LaudoController {

	@Autowired
	LaudoService laudoService;

	@RequestMapping(method = RequestMethod.GET, value = "/laudo/{tipoLaudo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoDetalheLaudo>> getTipoDetalheLaudo(@PathVariable String tipoLaudo) {
		List<TipoDetalheLaudo> tiposDetalheLaudos = laudoService.getTiposDetalheLaudos(tipoLaudo);
		return new ResponseEntity<>(tiposDetalheLaudos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/laudo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoDetalheLaudo>> getTiposDetalheLaudo() {
		List<TipoDetalheLaudo> tiposDetalheLaudos = laudoService.getTiposDetalheLaudos(null);
		return new ResponseEntity<>(tiposDetalheLaudos, HttpStatus.OK);
	}
	
}
