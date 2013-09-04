package br.edu.utfpr.cm.irho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.cm.irho.dao.TipoDao;
import br.edu.utfpr.cm.irho.model.Tipo;
import br.edu.utfpr.cm.irho.service.TipoService;
import br.edu.utfpr.cm.libutfcm.dao.IGenericDao;
import br.edu.utfpr.cm.libutfcm.service.GenericService;

@Service
public class TipoServiceImpl extends GenericService<Tipo> implements TipoService {

	@Autowired
	private TipoDao tipoDao;

	@Override
	protected IGenericDao<Tipo> getDao() {
		return tipoDao;
	}


}
