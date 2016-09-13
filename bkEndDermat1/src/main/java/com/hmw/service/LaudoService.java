package com.hmw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmw.dao.LaudosDAO;
import com.hmw.model.TipoDetalheLaudo;

@Service
public class LaudoService {
	@Autowired
	LaudosDAO laudosDAO;
	
	public List<TipoDetalheLaudo> getTiposDetalheLaudos(String tipoLaudo) {
		return laudosDAO.getTipoDetalheLaudo(tipoLaudo);
	}
}
