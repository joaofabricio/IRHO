package br.edu.utfpr.cm.irho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.cm.irho.dao.ArquivoDao;
import br.edu.utfpr.cm.irho.model.Arquivo;
import br.edu.utfpr.cm.irho.service.ArquivoService;
import br.edu.utfpr.cm.libutfcm.dao.IGenericDao;
import br.edu.utfpr.cm.libutfcm.service.GenericService;

@Service
public class ArquivoServiceImpl extends GenericService<Arquivo> implements ArquivoService {
	
	@Autowired
	private ArquivoDao arquivoDao;
	
	@Override
	protected IGenericDao<Arquivo> getDao() {
		return arquivoDao ;
	}
	

}
