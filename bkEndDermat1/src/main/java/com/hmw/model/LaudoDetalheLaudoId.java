package com.hmw.model;

import java.io.Serializable;

public class LaudoDetalheLaudoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int laudo;
	private int detalhelaudo;

	public int getLaudo() {
		return laudo;
	}

	public void setLaudo(int laudo) {
		this.laudo = laudo;
	}

	public int getDetalhelaudo() {
		return detalhelaudo;
	}

	public void setDetalhelaudo(int detalhelaudo) {
		this.detalhelaudo = detalhelaudo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + detalhelaudo;
		result = prime * result + laudo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LaudoDetalheLaudoId other = (LaudoDetalheLaudoId) obj;
		if (detalhelaudo != other.detalhelaudo)
			return false;
		if (laudo != other.laudo)
			return false;
		return true;
	}

}
