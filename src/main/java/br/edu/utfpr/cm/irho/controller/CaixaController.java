package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.utfpr.cm.irho.model.Caixa;
import br.edu.utfpr.cm.irho.service.CaixaService;

@Controller
public class CaixaController {

	@Autowired
	private CaixaService caixaService;
	
	@RequestMapping(value = "caixa/editarCaixa", method =  RequestMethod.GET)
	public String editarCaixa(Long id, HttpServletRequest request) {
		Caixa p = caixaService.find(id);
		request.setAttribute("caixa", p);
		
		return "caixa/editarCaixa";
	}
	@RequestMapping(value="caixa/excluir")
	public String excluir(Long id, String ctx, HttpServletRequest request){
		Caixa caixa=caixaService.find(id);
		request.setAttribute("id", caixa.getId());
		request.setAttribute("descricao", caixa.getDescricao());
		request.setAttribute("entidade", "caixa");
		request.setAttribute("action", "caixa/ExcluirCaixa");
		request.setAttribute("ctx", ctx);
		return "ExcluirConfirmacao";
	}

	@RequestMapping(value="caixa/ExcluirCaixa")
	public String excluir(Long id, HttpServletRequest request){
		Caixa caixa = caixaService.find(id);
		request.setAttribute("descricao", caixa.getDescricao());
		request.setAttribute("entidade", "caixa");
		caixaService.delete(caixa);
		return "ExcluidoSucesso";
	}
	
	@RequestMapping(value = "caixa/cadastroCaixa", method = RequestMethod.GET)
	public String cadastroCaixa() {
		return "caixa/cadastroCaixa";
	}

	@RequestMapping(value = "caixa/cadastrarCaixa", method = RequestMethod.POST)
	public String cadastroCaixa(String descricao, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		if (!StringUtils.hasText(descricao)) {
			request.setAttribute("erro", "Descrição inválida.");
			return "caixa/cadastroCaixa";
		}

		Caixa caixa = new Caixa();
		caixa.setDescricao(descricao);
		caixaService.save(caixa);

		response.sendRedirect("cadastroSucessoCaixa?id="+caixa.getId());
		return null;
	}
	@RequestMapping(value = "caixa/editado", method = RequestMethod.POST)
	public String cadastrarCaixa(String descricao, Long id,
								  HttpServletRequest request,
								  HttpServletResponse response) throws IOException {
		
		if (!StringUtils.hasText(descricao)) {
			request.setAttribute("erro", "Nome invalido.");
			return cadastroCaixa();
		}

		Caixa caixa = new Caixa();
		caixa.setId(id);
		caixa.setDescricao(descricao);
		caixaService.save(caixa );
		
		response.sendRedirect("cadastroSucessoCaixa?id="+caixa.getId());
		return null;
	}
	@RequestMapping(value = "caixa/cadastroSucessoCaixa", method = RequestMethod.GET)
	public String cadastroSucesso(Long id,HttpServletRequest request) {
		
		Caixa caixa=caixaService.find(id);
		request.setAttribute("Descrition", caixa.getDescricao());
		
		
		return "caixa/cadastroSucessoCaixa";
	}

	public void setCaixaService(CaixaService caixaService) {
		this.caixaService = caixaService;
	}

}
