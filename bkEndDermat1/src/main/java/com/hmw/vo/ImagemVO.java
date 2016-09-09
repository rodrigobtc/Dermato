package com.hmw.vo;

public class ImagemVO {
	private long imgId;
	private String descricao;
	private String mensagem;
	private byte[] img;
	private Integer exame;
	public Integer getExame() {
		return exame;
	}
	public void setExame(Integer exame) {
		this.exame = exame;
	}
	public String getDescricao() {
		return descricao;
	}
	public byte[] getImg() {
		return img;
	}
	public long getImgId() {
		return imgId;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public void setImgId(long imgId) {
		this.imgId = imgId;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
