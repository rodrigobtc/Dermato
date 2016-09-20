package com.hmw.dao;

import java.util.List;

import com.hmw.vo.ExameVO;

public interface ExamesDAO {
	List<ExameVO> getExames();
	ExameVO getExame(Integer id, Boolean carregaImagens) throws Exception;
	
	//ExameVO getImagensExame(Integer id);
	
}
