package com.hmw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize
public class Laudo {
	@Id
	@SequenceGenerator(name = "laudo_id_seq", sequenceName = "laudo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laudo_id_seq")
	private long id;
	
	@JsonBackReference
	@ManyToOne
	private Exame exame;

	@OneToMany(mappedBy="laudo")
	private List<LaudoDetalheLaudo> detalhelaudo;
	
	@Column(columnDefinition = " text")
	private String descricaoEstudo;

	
	@Column(columnDefinition = " text")
	private String outrasInformacoes;
	
	@Column(columnDefinition = " text")
	private String conclusao;
	
	private Integer tamanho;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public String getDescricaoEstudo() {
		return descricaoEstudo;
	}

	public void setDescricaoEstudo(String descricaoEstudo) {
		this.descricaoEstudo = descricaoEstudo;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}

	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	public List<LaudoDetalheLaudo> getDetalhelaudo() {
		return detalhelaudo;
	}

	public void setDetalhelaudo(List<LaudoDetalheLaudo> detalhelaudo) {
		this.detalhelaudo = detalhelaudo;
	}

}
