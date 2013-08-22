package br.edu.utfpr.cm.irho.model;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;

public class Caixa extends GenericModel {
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
