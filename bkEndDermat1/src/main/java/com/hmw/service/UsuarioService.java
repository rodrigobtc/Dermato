package com.hmw.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmw.model.Usuario;
import com.hmw.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Collection<Usuario> consultarTodos() {
		return usuarioRepository.findAll();
	}
	
	public void apagar(Integer id) {
		usuarioRepository.delete(id);
	}
	
	public boolean existe(Integer id) {
		return usuarioRepository.exists(id);
	}
	
	public Usuario localizar(Integer id) {
		return usuarioRepository.findOne(id);
	}
}
