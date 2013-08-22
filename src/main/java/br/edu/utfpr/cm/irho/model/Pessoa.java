package br.edu.utfpr.cm.irho.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;
@Entity
public class Pessoa extends GenericModel {
	
	@Column
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
