package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.utfpr.cm.irho.model.Pessoa;
import br.edu.utfpr.cm.irho.service.PessoaService;
import br.edu.utfpr.cm.libutfcm.dao.Criterion;
import br.edu.utfpr.cm.libutfcm.dao.Order;

@Controller
public class PessoaPopUpController {
	
	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "pessoa/popup", method = {RequestMethod.GET, RequestMethod.POST})
	public String buscarPessoa(@RequestParam(required=false) String nome,
								HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		nome = nome != null? nome : "";
		
		Criterion criterion = Criterion.like("nome", nome);

		Order o = Order.ascending("nome");

		Collection<Pessoa> retorno = pessoaService.findByCriterion(o, criterion);

		request.setAttribute("result", retorno);
		request.setAttribute("nome", nome);

		return "pessoa/popUpPessoa";
	}
}
