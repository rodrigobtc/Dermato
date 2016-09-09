package com.hmw.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmw.dao.ExamesDAO;
import com.hmw.dao.impl.ExamesDAOImpl;
import com.hmw.model.Imagem;
import com.hmw.repository.ImagemRepository;
import com.hmw.vo.ExameVO;
import com.hmw.vo.ImagemVO;

@Service
public class ImagemService {
	@Autowired
	ImagemRepository imagemRepository;
	
	@Autowired
	ExamesDAO exameDAO;
	
	public Imagem cadastrar(Imagem imagem) {
		return imagemRepository.save(imagem);
	}
	
	public Collection<Imagem> consultarTodos() {
		return imagemRepository.findAll();
	}
	
	public void apagar(Long id) {
		imagemRepository.delete(id);
	}
	
	public boolean existe(Long id) {
		return imagemRepository.exists(id);
	}
	
	public Imagem localizar(Long id) {
		return imagemRepository.getOne(id);
	}
	
	/*public ExameVO getImgsExame(Integer idExame) {
		return exameDAO.getImagensExame(idExame);
	}*/
}
