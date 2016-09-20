package com.hmw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(SecaoLaudoDetalheLaudoId.class)
public class SecaoLaudoDetalheLaudo {

	@Id
	@ManyToOne
	@JoinColumn(name = "secaolaudo_id")
	private SecaoLaudo secaolaudo;

	@Id
	@ManyToOne
	@JoinColumn(name = "detalhelaudo_id")
	private DetalheLaudo detalhelaudo;

	@NotNull
	private Integer ordem;

	public SecaoLaudo getSecaolaudo() {
		return secaolaudo;
	}

	public void setSecaolaudo(SecaoLaudo secaolaudo) {
		this.secaolaudo = secaolaudo;
	}

	public DetalheLaudo getDetalhelaudo() {
		return detalhelaudo;
	}

	public void setDetalhelaudo(DetalheLaudo detalhelaudo) {
		this.detalhelaudo = detalhelaudo;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

}
