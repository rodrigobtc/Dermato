package com.hmw.dao;

import java.util.List;

import com.hmw.model.TipoDetalheLaudo;

public interface LaudosDAO {
	public List<TipoDetalheLaudo> getTipoDetalheLaudo(String tipo);
}
