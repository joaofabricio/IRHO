package br.edu.utfpr.cm.irho.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.InetOrgPerson.Essence;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

import br.edu.utfpr.cm.irho.model.Usuario;
import br.edu.utfpr.cm.irho.service.UsuarioService;

public class UserMapper extends LdapUserDetailsMapper {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails mapUserFromContext(DirContextOperations ctx,
			String username, Collection<GrantedAuthority> authorities) {
		
		Essence essence = new Essence(ctx);
		
		Usuario usuario = new Usuario();
		usuario.setLogin(username);
		usuario = usuarioService.findUniqueByExample(usuario);
		
//		if (usuario == null) {
			essence.addAuthority(new SimpleGrantedAuthority("ROLE_USER"));
//		} else {
//			essence.addAuthority(new SimpleGrantedAuthority(usuario.getAcesso().toString()));
//		}
		
		return essence.createUserDetails();
	}
	
}
