package com.hmw.vo;

import java.util.List;

public class ExameVO {
	private Integer id;
	private String descricao;
	private String indicacao;
	private String nomePaciente;
	private Integer codigoPaciente;
	private List<ImagemVO> imagens;
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<ImagemVO> getImagens() {
		return imagens;
	}

	public void setImagens(List<ImagemVO> imagens) {
		this.imagens = imagens;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public Integer getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(Integer codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}
}
