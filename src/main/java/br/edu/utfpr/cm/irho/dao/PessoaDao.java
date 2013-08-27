package br.edu.utfpr.cm.irho.dao;

import org.springframework.stereotype.Component;

import br.edu.utfpr.cm.irho.model.Pessoa;
import br.edu.utfpr.cm.libutfcm.dao.GenericDao;

@Component
public class PessoaDao extends GenericDao<Pessoa> {

	public PessoaDao() {
		super(Pessoa.class);
	}

}
