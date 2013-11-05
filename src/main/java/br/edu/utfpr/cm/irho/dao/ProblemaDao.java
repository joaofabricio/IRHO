package br.edu.utfpr.cm.irho.dao;

import org.springframework.stereotype.Component;

import br.edu.utfpr.cm.irho.model.Problema;
import br.edu.utfpr.cm.libutfcm.dao.GenericDao;

@Component
public class ProblemaDao extends GenericDao<Problema> {

	public ProblemaDao() {
		super(Problema.class);
	}

}
