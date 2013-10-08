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
public class BuscaArquivo {

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "pessoa/buscaarquivo", method = RequestMethod.GET)
	public String cadastroPessoa() {
		return "pessoa/BuscarArquivo";
	}

	/*@RequestMapping(value = "pessoa/buscaarquivo", method = RequestMethod.POST)
	public String buscarPessoa(String nome, String ordem,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Criterion criterion = Criterion.like("nome", nome);

		Order o = Order.ascending(ordem);

		Collection<Pessoa> retorno = pessoaService
				.findByCriterion(o, criterion);

		request.setAttribute("result", retorno);

		request.setAttribute("nomePessoa", nome);
		return "pessoa/BuscadoPessoa";
	}
*/
	@RequestMapping(value = "pessoa/BuscarArquivo", method = RequestMethod.GET)
	public String BuscarPessoa() {
		return "pessoa/Arquivo";
	}

/*	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}*/

}
