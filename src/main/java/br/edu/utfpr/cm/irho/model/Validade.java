package br.edu.utfpr.cm.irho.model;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;

public class Validade extends GenericModel {
	private String descricao;
	private Integer prazoEmAnos;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getPrazoEmAnos() {
		return prazoEmAnos;
	}
	public void setPrazoEmAnos(Integer prazoEmAnos) {
		this.prazoEmAnos = prazoEmAnos;
	}

}
