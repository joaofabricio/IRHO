package br.edu.utfpr.cm.irho.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.edu.utfpr.cm.libutfcm.model.Email;
import br.edu.utfpr.cm.libutfcm.model.GenericModel;

@Entity
public class Usuario extends GenericModel {
	
	@Column
	private String nome;

	@Column
	private String login;

	@Embedded
	private Email email;

	@Column
	@Enumerated(EnumType.STRING)
	private Acesso acesso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

}
