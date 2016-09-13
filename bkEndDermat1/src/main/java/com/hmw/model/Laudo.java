package com.hmw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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

	@JsonProperty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laudo", cascade = CascadeType.ALL)
	private List<DetalheLaudo> lesaoElementar;
	
	@JsonProperty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laudo", cascade = CascadeType.ALL)
	private List<DetalheLaudo> lesaoSecundaria;
	
	@JsonProperty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laudo", cascade = CascadeType.ALL)
	private List<DetalheLaudo> coloracao;
	
	@JsonProperty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laudo", cascade = CascadeType.ALL)
	private List<DetalheLaudo> morfologia;
	
	@JsonProperty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laudo", cascade = CascadeType.ALL)
	private List<DetalheLaudo> distribuicao;
	
	@JsonProperty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "laudo", cascade = CascadeType.ALL)
	private List<DetalheLaudo> compatibilidadeLesao;
	
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

	public List<DetalheLaudo> getLesaoElementar() {
		return lesaoElementar;
	}

	public void setLesaoElementar(List<DetalheLaudo> lesaoElementar) {
		this.lesaoElementar = lesaoElementar;
	}

	public List<DetalheLaudo> getLesaoSecundaria() {
		return lesaoSecundaria;
	}

	public void setLesaoSecundaria(List<DetalheLaudo> lesaoSecundaria) {
		this.lesaoSecundaria = lesaoSecundaria;
	}

	public List<DetalheLaudo> getColoracao() {
		return coloracao;
	}

	public void setColoracao(List<DetalheLaudo> coloracao) {
		this.coloracao = coloracao;
	}

	public List<DetalheLaudo> getMorfologia() {
		return morfologia;
	}

	public void setMorfologia(List<DetalheLaudo> morfologia) {
		this.morfologia = morfologia;
	}

	public List<DetalheLaudo> getDistribuicao() {
		return distribuicao;
	}

	public void setDistribuicao(List<DetalheLaudo> distribuicao) {
		this.distribuicao = distribuicao;
	}

	public List<DetalheLaudo> getCompatibilidadeLesao() {
		return compatibilidadeLesao;
	}

	public void setCompatibilidadeLesao(List<DetalheLaudo> compatibilidadeLesao) {
		this.compatibilidadeLesao = compatibilidadeLesao;
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

}
