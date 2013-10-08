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

	
	@RequestMapping(value = TIPO_ARQUIVO_CADASTRO, method =  RequestMethod.GET)
	public String cadastroTipoArquivo(HttpServletRequest request) {

		Collection<Validade> retorno = validadeService.findByCriterion();

		request.setAttribute("result", retorno);
		return TIPO_ARQUIVO_CADASTRO;
	}
	
	@RequestMapping(value = TIPO_ARQUIVO_CADASTRO, method = RequestMethod.POST)
	public String cadastrarTipo(String descricao, Long validadeId,
								  HttpServletRequest request,
								  HttpServletResponse response) throws IOException {
		
		if (!StringUtils.hasText(descricao)) {
			request.setAttribute("erro", "Descrição inválida.");
			return cadastroTipoArquivo(request);
		}
		
		if (validadeId == null || validadeId < 0) {
			request.setAttribute("erro", "Selecione uma validade.");
			return cadastroTipoArquivo(request);
		}
		
		Validade validade = validadeService.find(validadeId);
		
		if (validade == null) {
			request.setAttribute("erro", "A validade especificada não foi recuperada.");
			return cadastroTipoArquivo(request);
		}
		
		Tipo tipo = new Tipo();
		tipo.setDescricao(descricao);
		tipo.setValidade(validade);
		tipoService.save(tipo);
		
		
		response.sendRedirect("cadastradoSucesso?id="+tipo.getId());
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
