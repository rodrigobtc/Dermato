package com.hmw.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@Entity
public class DetalheLaudo {
	@Id
	@SequenceGenerator(name = "detalhelaudo_id_seq", sequenceName = "detalhelaudo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalhelaudo_id_seq")
	private Integer id;
	private String nome;
	@JsonBackReference
	@OneToMany(mappedBy="detalhelaudo")
	private List<LaudoDetalheLaudo> laudo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<LaudoDetalheLaudo> getLaudo() {
		return laudo;
	}
	public void setLaudo(List<LaudoDetalheLaudo> laudo) {
		this.laudo = laudo;
	}

}
