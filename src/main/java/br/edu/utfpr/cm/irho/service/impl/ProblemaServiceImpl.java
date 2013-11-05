package br.edu.utfpr.cm.irho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.cm.irho.dao.ProblemaDao;
import br.edu.utfpr.cm.irho.model.Problema;
import br.edu.utfpr.cm.irho.service.ProblemaService;
import br.edu.utfpr.cm.libutfcm.dao.IGenericDao;
import br.edu.utfpr.cm.libutfcm.service.GenericService;

@Service
public class ProblemaServiceImpl extends GenericService<Problema> implements ProblemaService {
	
	@Autowired
	private ProblemaDao problemaDao;
	
	@Override
	protected IGenericDao<Problema> getDao() {
		return problemaDao ;
	}
	

}
