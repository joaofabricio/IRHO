package br.edu.utfpr.cm.irho.model;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;

public class Pessoa extends GenericModel {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
