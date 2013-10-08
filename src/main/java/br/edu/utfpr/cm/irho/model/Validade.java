package br.edu.utfpr.cm.irho.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;

@Entity
public class Validade extends GenericModel {
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
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
