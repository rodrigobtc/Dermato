package com.hmw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@Entity
public class TipoDetalheLaudo {
	@Id
	@SequenceGenerator(name = "tipodetalhelaudo_id_seq", sequenceName = "tipodetalhelaudo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipodetalhelaudo_id_seq")
	private Integer id;
	
	@Column(columnDefinition=" varchar(1)")
	private String tipo;
	
	@Column(columnDefinition=" varchar(25)")
	private String descricao;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
}
