package br.edu.utfpr.cm.irho.dao;

import org.springframework.stereotype.Component;

import br.edu.utfpr.cm.irho.model.Tipo;
import br.edu.utfpr.cm.libutfcm.dao.GenericDao;

@Component
public class TipoDao extends GenericDao<Tipo> {

	public TipoDao() {
		super(Tipo.class);
	}

}
