package com.hmw.model;

import java.io.Serializable;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize
@Table(name = "exame")
public class Exame implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "exame_id_seq", sequenceName = "exame_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exame_id_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(columnDefinition=" varchar(100)")
	private String descricao;
	
	@Column(columnDefinition=" varchar(100)")
	private String indicacao;

	@ManyToOne
	@JsonBackReference
	private Usuario laudador;
	
	@ManyToOne
	@JsonBackReference
	private Usuario requisitante;
	
	@ManyToOne
	@JsonBackReference
	private Paciente paciente;
	
	@JsonProperty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exame", cascade = CascadeType.ALL)
	private List<Imagem> imagens;
	
	@JsonProperty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exame", cascade = CascadeType.ALL)
	private List<Laudo> laudos;


	public String getDescricao() {
		return descricao;
	}

	public Integer getId() {
		return id;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public Usuario getLaudador() {
		return laudador;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Usuario getRequisitante() {
		return requisitante;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public void setLaudador(Usuario laudador) {
		this.laudador = laudador;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setRequisitante(Usuario requisitante) {
		this.requisitante = requisitante;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

}
