package com.hmw.dao;

import java.util.List;

import com.hmw.vo.LaudoVO;

public interface LaudosDAO {

	List<LaudoVO> getLaudo(Integer exameId, Integer laudoId);
}
