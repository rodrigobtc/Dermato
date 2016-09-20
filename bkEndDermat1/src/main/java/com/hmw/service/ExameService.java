package com.hmw.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmw.dao.ExamesDAO;
import com.hmw.model.DetalheImagem;
import com.hmw.model.Exame;
import com.hmw.repository.DetalheImagemRepository;
import com.hmw.repository.ExameRepository;
import com.hmw.vo.ExameVO;

@Service
public class ExameService {
	@Autowired
	ExameRepository exameRepository;
	
	@Autowired
	ExamesDAO exameDao;
	
	@Autowired
	DetalheImagemRepository detalheImagemRepository;
	

	public Exame cadastrar(Exame usuario) {
		return exameRepository.save(usuario);
	}
	
	public Collection<ExameVO> consultarTodos() {
		return exameDao.getExames();
	}
	
	public void apagar(Integer id) {
		exameRepository.delete(id);
	}
	
	public boolean existe(Integer id) {
		return exameRepository.exists(id);
	}
	
	public ExameVO localizar(Integer id, Boolean carregaImagens) throws Exception {
		
		return exameDao.getExame(id, carregaImagens);
	}

	public Exame localizarObj(Integer id) {
		
		return exameRepository.getOne(id);
	}
	
	public Exame getOne(Integer id) {
		return exameRepository.getOne(id);
	}
	
	public Exame atualizar(Exame exame) {
		return exameRepository.save(exame);
	}

	public DetalheImagem getDetalheImagem(Long idFoto) {
		return detalheImagemRepository.getOne(idFoto);
	}

}
