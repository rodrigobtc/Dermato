package com.hmw.vo;

import java.math.BigInteger;
import java.util.List;

public class LaudoVO {
	private BigInteger laudoId;
	private ExameVO exame;
	private String conclusao;
	private String descricaoEstudo;
	private String outrasInformacoes;
	private List<SecaoLaudoVO> secoesLaudo;
	private List<DetalheLaudoVO> distribuicao;

	public ExameVO getExame() {
		return exame;
	}

	public void setExame(ExameVO exameVO) {
		this.exame = exameVO;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	public String getDescricaoEstudo() {
		return descricaoEstudo;
	}

	public void setDescricaoEstudo(String conclusaoEstudo) {
		this.descricaoEstudo = conclusaoEstudo;
	}

	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}

	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}

	public BigInteger getLaudoId() {
		return laudoId;
	}

	public void setLaudoId(BigInteger laudoId) {
		this.laudoId = laudoId;
	}

	public List<SecaoLaudoVO> getSecoesLaudo() {
		return secoesLaudo;
	}

	public void setSecoesLaudo(List<SecaoLaudoVO> secoesLaudo) {
		this.secoesLaudo = secoesLaudo;
	}

	public List<DetalheLaudoVO> getDistribuicao() {
		return distribuicao;
	}

	public void setDistribuicao(List<DetalheLaudoVO> distribuicao) {
		this.distribuicao = distribuicao;
	}

}
