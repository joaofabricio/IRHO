package br.edu.utfpr.cm.irho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.cm.irho.dao.CaixaDao;
import br.edu.utfpr.cm.irho.model.Caixa;
import br.edu.utfpr.cm.irho.service.CaixaService;
import br.edu.utfpr.cm.libutfcm.dao.IGenericDao;
import br.edu.utfpr.cm.libutfcm.service.GenericService;

@Service
public class CaixaServiceImpl extends GenericService<Caixa> implements CaixaService {
	
	@Autowired
	private CaixaDao caixaDao;
	
	@Override
	protected IGenericDao<Caixa> getDao() {
		return caixaDao ;
	}
	

}
