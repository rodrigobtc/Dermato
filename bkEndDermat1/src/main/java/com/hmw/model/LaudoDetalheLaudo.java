package com.hmw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(LaudoDetalheLaudoId.class)
public class LaudoDetalheLaudo {

	@Id
	@ManyToOne
	@JoinColumn(name = "laudo_id")
	private Laudo laudo;

	@Id
	@ManyToOne
	@JoinColumn(name = "detalhelaudo_id")
	private DetalheLaudo detalhelaudo;

	public Laudo getLaudo() {
		return laudo;
	}

	public void setLaudo(Laudo laudo) {
		this.laudo = laudo;
	}

	public DetalheLaudo getDetalhelaudo() {
		return detalhelaudo;
	}

	public void setDetalhelaudo(DetalheLaudo detalhelaudo) {
		this.detalhelaudo = detalhelaudo;
	}

}
