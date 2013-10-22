package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.utfpr.cm.irho.model.Pessoa;
import br.edu.utfpr.cm.irho.service.PessoaService;
import br.edu.utfpr.cm.libutfcm.dao.Criterion;
import br.edu.utfpr.cm.libutfcm.dao.Order;

@Controller
public class PessoaPopUpController {
	
	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "pessoa/popup", method = RequestMethod.GET)
	public String buscarPessoa(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Criterion criterion = Criterion.like("nome", "");

		Order o = Order.ascending("nome");

		Collection<Pessoa> retorno = pessoaService.findByCriterion(o, criterion);

		request.setAttribute("result", retorno);

		return "pessoa/popUpPessoa";
	}
}
