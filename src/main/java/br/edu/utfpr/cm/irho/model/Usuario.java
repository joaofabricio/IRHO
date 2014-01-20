package br.edu.utfpr.cm.irho.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

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

}
