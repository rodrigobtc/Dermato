package com.hmw.vo;

public class DetalheLaudoVO {
	private Long id;
	private String descricao;
	private Boolean marcado;
	private Integer ordem;
	private ExameVO exameVO;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getMarcado() {
		return marcado;
	}
	public void setMarcado(Boolean marcado) {
		this.marcado = marcado;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public ExameVO getExameVO() {
		return exameVO;
	}
	public void setExameVO(ExameVO exameVO) {
		this.exameVO = exameVO;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
