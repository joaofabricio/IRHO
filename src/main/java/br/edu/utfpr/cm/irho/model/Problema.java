package br.edu.utfpr.cm.irho.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;

@Entity
public class Problema extends GenericModel {

	@Column
	private String descricao;

	@Column
	private Boolean terminado;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getTerminado() {
		return terminado;
	}

	public void setTerminado(Boolean terminado) {
		this.terminado = terminado;
	}
	
}
