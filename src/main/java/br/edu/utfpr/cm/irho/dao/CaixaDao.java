package br.edu.utfpr.cm.irho.dao;

import org.springframework.stereotype.Component;

import br.edu.utfpr.cm.libutfcm.dao.GenericDao;
import br.edu.utfpr.cm.irho.model.Caixa;;

@Component
public class CaixaDao extends GenericDao<Caixa>{
	
	public CaixaDao (){
		super(Caixa.class);
	}

}
