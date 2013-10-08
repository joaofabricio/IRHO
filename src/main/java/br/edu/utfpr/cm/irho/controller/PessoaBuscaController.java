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
import br.edu.utfpr.cm.irho.service.PessoaService;
import br.edu.utfpr.cm.libutfcm.dao.Criterion;
import br.edu.utfpr.cm.libutfcm.dao.Order;

@Controller
public class PessoaBuscaController {

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "pessoa/buscar", method = RequestMethod.GET)
	public String cadastroPessoa() {
		return "pessoa/BuscarPessoa";
	}

	@RequestMapping(value = "pessoa/buscar", method = RequestMethod.POST)
	public String buscarPessoa(String nome, String ordem,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Criterion criterion = Criterion.like("nome", nome);

		ordem = StringUtils.hasText(ordem)?ordem:"1";
		Order o = Order.ascending(ordem);

		Collection<Pessoa> retorno = pessoaService.findByCriterion(o, criterion);

		request.setAttribute("result", retorno);

		request.setAttribute("nomePessoa", nome);
		return "pessoa/BuscadoPessoa";
	}

	@RequestMapping(value = "pessoa/BuscarPessoa", method = RequestMethod.GET)
	public String BuscarPessoa() {
		return "pessoa/BuscarPessoa";
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

}
