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

import com.hmw.model.Usuario;
import com.hmw.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
		return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Usuario>> consultarUsuarios() {
		Collection<Usuario> consultarTodos = usuarioService.consultarTodos();
		return new ResponseEntity<>(consultarTodos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/usuarios/{id}")
	public ResponseEntity<Collection<Usuario>> apagarUsuario(@PathVariable Integer id) {
		if (!usuarioService.existe(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		usuarioService.apagar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://192.168.10.103:8100")
	@RequestMapping(method = RequestMethod.GET, value = "/usuarios/{id}")
	public ResponseEntity<Usuario> localizarUsuario(@PathVariable Integer id) {
		if (!usuarioService.existe(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(usuarioService.localizar(id), HttpStatus.OK);
	}

}
