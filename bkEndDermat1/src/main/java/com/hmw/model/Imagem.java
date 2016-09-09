package com.hmw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize
public class Imagem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "imagem_id_seq", sequenceName = "imagem_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagem_id_seq")
	private long id;
	@JsonBackReference
	@ManyToOne
	private Exame exame;
	@Column(name = "img")
	private byte[] img;
	@OneToOne
	private DetalheImagem detalheImagem;

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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public DetalheImagem getDetalheImagem() {
		return detalheImagem;
	}

	public void setDetalheImagem(DetalheImagem detalheImagem) {
		this.detalheImagem = detalheImagem;
	}

}
