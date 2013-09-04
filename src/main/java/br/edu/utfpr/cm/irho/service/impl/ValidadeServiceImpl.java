package br.edu.utfpr.cm.irho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.cm.irho.dao.ValidadeDao;
import br.edu.utfpr.cm.irho.model.Validade;
import br.edu.utfpr.cm.irho.service.ValidadeService;
import br.edu.utfpr.cm.libutfcm.dao.IGenericDao;
import br.edu.utfpr.cm.libutfcm.service.GenericService;

@Service
public class ValidadeServiceImpl extends GenericService<Validade> implements ValidadeService {
	
	@Autowired
	private ValidadeDao ValiDao;
	
	@Override
	protected IGenericDao<Validade> getDao() {
		return ValiDao ;
	}
	

}
