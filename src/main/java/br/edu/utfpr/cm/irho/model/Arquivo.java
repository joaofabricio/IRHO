package br.edu.utfpr.cm.irho.model;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;

public class Arquivo extends GenericModel {
	private String assunto;
	private int dataArquivo;
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public int getDataArquivo() {
		return dataArquivo;
	}
	public void setDataArquivo(int dataArquivo) {
		this.dataArquivo = dataArquivo;
	}
	
}
