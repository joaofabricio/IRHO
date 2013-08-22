package br.edu.utfpr.cm.irho.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;
@Entity
public class Tipo extends GenericModel {
	
	@Column
	private String descricao;
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
