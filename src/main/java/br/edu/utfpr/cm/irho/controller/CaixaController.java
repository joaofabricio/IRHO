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
