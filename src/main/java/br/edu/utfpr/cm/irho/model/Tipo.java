package br.edu.utfpr.cm.irho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;
@Entity
public class Tipo extends GenericModel {
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="Validade_id", nullable = false)
	private Validade validade;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Validade getValidade() {
		return validade;
	}
	
	public void setValidade(Validade validade) {
		this.validade = validade;
	}
}
