package br.edu.utfpr.cm.irho.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.InetOrgPerson;
import org.springframework.stereotype.Service;

import br.edu.utfpr.cm.irho.dao.UsuarioDao;
import br.edu.utfpr.cm.irho.model.Usuario;
import br.edu.utfpr.cm.irho.service.UsuarioService;
import br.edu.utfpr.cm.libutfcm.dao.IGenericDao;
import br.edu.utfpr.cm.libutfcm.service.GenericService;

@Service
public class UsuarioServiceImpl extends GenericService<Usuario> implements UsuarioService {

	@Autowired
	private UsuarioDao dao;

	@Override
	protected IGenericDao<Usuario> getDao() {
		return dao;
	}

	@Override
	public Usuario findLoggedInUser() {
		InetOrgPerson principal = (InetOrgPerson) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Usuario usuario = new Usuario();
		usuario.setLogin(principal.getUsername());
		usuario = findUniqueByExample(usuario);
		
		return usuario;
	}

}
