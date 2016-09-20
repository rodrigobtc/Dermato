package com.hmw.model;

import java.io.Serializable;

public class SecaoLaudoDetalheLaudoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int secaolaudo;
	private int detalhelaudo;

	public int getSecaolaudo() {
		return secaolaudo;
	}

	public void setSecaolaudo(int secaolaudo) {
		this.secaolaudo = secaolaudo;
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
		result = prime * result + secaolaudo;
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
		SecaoLaudoDetalheLaudoId other = (SecaoLaudoDetalheLaudoId) obj;
		if (detalhelaudo != other.detalhelaudo)
			return false;
		if (secaolaudo != other.secaolaudo)
			return false;
		return true;
	}

}
