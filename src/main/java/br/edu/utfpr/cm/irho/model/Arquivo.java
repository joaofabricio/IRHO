package br.edu.utfpr.cm.irho.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.utfpr.cm.libutfcm.model.GenericModel;
import br.edu.utfpr.cm.libutfcm.util.DateUtil;

@Entity
public class Arquivo extends GenericModel {
	
	@Column
	private String assunto;

	@Column
	private String area;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataArquivo;
	
	@ManyToOne
	@JoinColumn(name="Pessoa_id")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="Tipo_id")
	private Tipo tipo;
	
	@ManyToOne
	@JoinColumn(name="Caixa_id")
	private Caixa caixa;
	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
	public String getDataArquivoFormatada() {
		return DateUtil.formatarDDMMAAAA(dataArquivo);
	}
	public void setDataArquivo(Date dataArquivo) {
		this.dataArquivo = dataArquivo;
	}

	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
}
