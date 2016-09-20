package com.hmw.vo;

import java.util.List;

public class SecaoLaudoVO {
	private String descricao;
	private List<DetalheLaudoVO> detalhesLaudo;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<DetalheLaudoVO> getDetalhesLaudo() {
		return detalhesLaudo;
	}
	public void setDetalhesLaudo(List<DetalheLaudoVO> detalhesLaudo) {
		this.detalhesLaudo = detalhesLaudo;
	}
	
}
