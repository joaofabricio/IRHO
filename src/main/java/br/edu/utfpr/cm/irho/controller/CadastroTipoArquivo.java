package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.utfpr.cm.irho.model.Pessoa;
import br.edu.utfpr.cm.irho.model.Tipo;
import br.edu.utfpr.cm.irho.model.Validade;
import br.edu.utfpr.cm.irho.service.TipoService;
import br.edu.utfpr.cm.irho.service.ValidadeService;

@Controller
public class CadastroTipoArquivo {
	
	private static final String TIPO_ARQUIVO_CADASTRO = "tipoArquivo/cadastro";
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private ValidadeService validadeService;
	
	@RequestMapping(value = "tipo/editarTipo", method =  RequestMethod.GET)
	public String editarTipo(Long id, HttpServletRequest request) {
		Tipo p = tipoService.find(id);
		request.setAttribute("tipo", p);
		
		return "tipo/editarTipo";
	}

	@RequestMapping(value="tipo/excluir")
	public String excluir(Long id, String ctx, HttpServletRequest request){
		Tipo tipo=tipoService.find(id);
		request.setAttribute("id", tipo.getId());
		request.setAttribute("descricao", tipo.getDescricao());
		request.setAttribute("entidade", "tipo");
		request.setAttribute("action", "tipo/ExcluirTipo");
		request.setAttribute("ctx", ctx);
		return "ExcluirConfirmacao";
	}
	@RequestMapping(value="tipo/ExcluirTipo")
	public String excluirDelete(Long id, HttpServletRequest request){
		Tipo tipo = tipoService.find(id);
		request.setAttribute("Nome", tipo.getDescricao());
		request.setAttribute("entidade", "tipo");
		tipoService.delete(tipo);
		return "ExcluidoSucesso";
	}
	@RequestMapping(value = TIPO_ARQUIVO_CADASTRO, method =  RequestMethod.GET)
	public String cadastroTipoArquivo(HttpServletRequest request) {

		Collection<Validade> retorno = validadeService.findByCriterion();

		request.setAttribute("result", retorno);
		return TIPO_ARQUIVO_CADASTRO;
	}
	
	@RequestMapping(value = TIPO_ARQUIVO_CADASTRO, method = RequestMethod.POST)
	public String cadastrarTipo(String descricao, 
								  HttpServletRequest request,
								  HttpServletResponse response) throws IOException {
		
		if (!StringUtils.hasText(descricao)) {
			request.setAttribute("erro", "Descrição invalida.");
			return TIPO_ARQUIVO_CADASTRO;
		}
		
		Tipo tipo = new Tipo();
		tipo.setDescricao(descricao);
		tipoService.save(tipo);
		
		
		response.sendRedirect("cadastradoSucesso?id="+tipo.getId());
		return null;
	}
	
	@RequestMapping(value = "tipo/editado", method = RequestMethod.POST)
	public String cadastrarTipo(String descricao, Long id,
								  HttpServletRequest request,
								  HttpServletResponse response) throws IOException {
		
		if (!StringUtils.hasText(descricao)) {
			request.setAttribute("erro", "Nome invalido.");
			return cadastroTipoArquivo(request);
		}

		Tipo tipo = new Tipo();
		tipo.setId(id);
		tipo.setDescricao(descricao);
		tipoService.save(tipo);
		
		response.sendRedirect("cadastroSucessoTipo?id="+tipo.getId());
		return null;
	}
	
	@RequestMapping
	(value = "tipoArquivo/cadastradoSucesso", method = RequestMethod.GET)
	public String cadastroSucesso(Long id, HttpServletRequest request) {
		
			Tipo tipo;
			tipo = tipoService.find(id);
			if (tipo == null){
				request.setAttribute("erro", "Erro ao processar tipo.");
				return TIPO_ARQUIVO_CADASTRO;
				
			}
			
		
		request.setAttribute("descricao", tipo.getDescricao());
		
		return "tipoArquivo/cadastradoSucesso";
	}
	
	

	public void setTipoService(TipoService service) {
		this.tipoService = service;
		
		
	}

	public void setValidadeService(ValidadeService service) {
		this.validadeService = service;		
	}

}
