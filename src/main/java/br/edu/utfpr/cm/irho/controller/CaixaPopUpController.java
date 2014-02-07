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

import br.edu.utfpr.cm.irho.model.Caixa;
import br.edu.utfpr.cm.irho.service.CaixaService;
import br.edu.utfpr.cm.libutfcm.dao.Criterion;
import br.edu.utfpr.cm.libutfcm.dao.Order;

@Controller
public class CaixaPopUpController {
	
	@Autowired
	private CaixaService caixaService;

	@RequestMapping(value = "caixa/popup", method = RequestMethod.GET)
	public String buscarcaixa(@RequestParam(required=false) String descricao,
							  HttpServletRequest request,
							  HttpServletResponse response)
			throws IOException {
		
		descricao = descricao != null ? descricao : "";

		Criterion criterion = Criterion.like("descricao", descricao);

		Order o = Order.ascending("descricao");

		Collection<Caixa> retorno = caixaService.findByCriterion(o, criterion);

		request.setAttribute("result", retorno);
		request.setAttribute("descricao", descricao);

		return "caixa/popUpCaixa";
	}
}
