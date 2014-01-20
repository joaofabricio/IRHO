package br.edu.utfpr.cm.irho.service;

import br.edu.utfpr.cm.irho.model.Usuario;
import br.edu.utfpr.cm.libutfcm.service.IGenericService;

public interface UsuarioService extends IGenericService<Usuario> {
	
	Usuario findLoggedInUser();

}
