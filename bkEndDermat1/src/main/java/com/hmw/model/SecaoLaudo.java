package com.hmw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize
public class SecaoLaudo {
	@Id
	@SequenceGenerator(name = "secoeslaudo_id_seq", sequenceName = "secoeslaudo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secoeslaudo_id_seq")
	private long id;

	@OneToMany(mappedBy = "laudo")
	private List<LaudoDetalheLaudo> detalhelaudo;

	@Column(columnDefinition = " varchar(20)")
	private String descricao;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<LaudoDetalheLaudo> getDetalhelaudo() {
		return detalhelaudo;
	}

	public void setDetalhelaudo(List<LaudoDetalheLaudo> detalhelaudo) {
		this.detalhelaudo = detalhelaudo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
