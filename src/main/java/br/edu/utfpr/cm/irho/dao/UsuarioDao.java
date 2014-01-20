package br.edu.utfpr.cm.irho.dao;

import org.springframework.stereotype.Component;

import br.edu.utfpr.cm.irho.model.Usuario;
import br.edu.utfpr.cm.libutfcm.dao.GenericDao;

@Component
public class UsuarioDao extends GenericDao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
	}

}
