package br.edu.utfpr.cm.irho.dao;

import org.springframework.stereotype.Component;

import br.edu.utfpr.cm.libutfcm.dao.GenericDao;

import br.edu.utfpr.cm.irho.model.Validade;

@Component
public class ValidadeDao extends GenericDao<Validade>{
	
	public ValidadeDao (){
		super(Validade.class);
	}

}
