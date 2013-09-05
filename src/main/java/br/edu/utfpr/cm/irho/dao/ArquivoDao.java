package br.edu.utfpr.cm.irho.dao;

import org.springframework.stereotype.Component;

import br.edu.utfpr.cm.libutfcm.dao.GenericDao;
import br.edu.utfpr.cm.irho.model.Arquivo;

@Component
public class ArquivoDao extends GenericDao<Arquivo>{
	
	public ArquivoDao (){
		super(Arquivo.class);
	}

}