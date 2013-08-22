package br.edu.utfpr.cm.irho.model;

import java.util.Date;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;

public class Arquivo extends GenericModel {
	private String assunto;
	private Date dataArquivo;
	
	private Pessoa pessoa; 
	private Validade validade;
	private Tipo tipo;
	private Caixa caixa;
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Validade getValidade() {
		return validade;
	}
	public void setValidade(Validade validade) {
		this.validade = validade;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Caixa getCaixa() {
		return caixa;
	}
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public Date getDataArquivo() {
		return dataArquivo;
	}
	public void setDataArquivo(Date dataArquivo) {
		this.dataArquivo = dataArquivo;
	}
	
}
