package br.edu.utfpr.cm.irho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.cm.irho.dao.PessoaDao;
import br.edu.utfpr.cm.irho.model.Pessoa;
import br.edu.utfpr.cm.irho.service.PessoaService;
import br.edu.utfpr.cm.libutfcm.dao.IGenericDao;
import br.edu.utfpr.cm.libutfcm.service.GenericService;

@Service
public class PessoaServiceImpl extends GenericService<Pessoa> implements PessoaService {

	@Autowired
	private PessoaDao pessoaDao;

	@Override
	protected IGenericDao<Pessoa> getDao() {
		return pessoaDao;
	}


}
