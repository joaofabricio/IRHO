package br.edu.utfpr.cm.irho.controller;


	import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.utfpr.cm.irho.model.Caixa;
import br.edu.utfpr.cm.irho.service.CaixaService;
import br.edu.utfpr.cm.libutfcm.dao.Criterion;
import br.edu.utfpr.cm.libutfcm.dao.Order;
@Controller
public class BuscaCaixaController {
	

		@Autowired
		private CaixaService caixaService;

		@RequestMapping(value = "caixa/buscar", method = RequestMethod.GET)
		public String cadastroCaixa() {
			return "caixa/BuscarCaixa";
		}

		@RequestMapping(value = "caixa/buscar", method = RequestMethod.POST)
		public String buscarCaxia(String descricao, String ordem,
				HttpServletRequest request, HttpServletResponse response)
				throws IOException {

			Criterion criterion = Criterion.like("descricao",descricao);

			ordem = ordem!=null? ordem:"1";
			
			Order o = Order.ascending(ordem);

			Collection<Caixa> retorno = caixaService.findByCriterion(o, criterion);

			request.setAttribute("result", retorno);

			request.setAttribute("descricaoCaixa", descricao);
			return "caixa/BuscadoCaixa";
		}

		@RequestMapping(value = "caixa/BuscarCaixa", method = RequestMethod.GET)
		public String BuscarCaixa() {
			return "caixa/BuscarCaixa";
		}

		public void setCaixaService(CaixaService caixaService) {
			this.caixaService = caixaService;
		}

	}
