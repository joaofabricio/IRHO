package br.edu.utfpr.cm.irho.model;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;

public class Tipo extends GenericModel {
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;
}
