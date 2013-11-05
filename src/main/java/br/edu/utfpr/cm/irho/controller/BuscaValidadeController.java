package br.edu.utfpr.cm.irho.controller;



import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.utfpr.cm.irho.model.Tipo;
import br.edu.utfpr.cm.irho.model.Validade;
import br.edu.utfpr.cm.irho.service.TipoService;
import br.edu.utfpr.cm.irho.service.TipoService;
import br.edu.utfpr.cm.irho.service.ValidadeService;
import br.edu.utfpr.cm.libutfcm.dao.Criterion;
import br.edu.utfpr.cm.libutfcm.dao.Order;


@Controller
public class BuscaValidadeController {

		@Autowired
		private ValidadeService validadeService;
		
	
		@RequestMapping(value = "validade/buscar", method = RequestMethod.GET)
		public String cadastroTipoArquivo() {
			return "validade/BuscarValidade";
		}


		@RequestMapping(value = "validade/buscar", method = RequestMethod.POST)
		public String buscarValidade(String descricao, String ordem,
				HttpServletRequest request, HttpServletResponse response)
				throws IOException {

			Criterion criterion = Criterion.like("descricao",descricao);

			Order or = Order.ascending(ordem);

			Collection<Validade> retorno = validadeService.findByCriterion(or, criterion);

			request.setAttribute("result", retorno);

			request.setAttribute("descricaoValidade", descricao);
			return "validade/BuscadoValidade";
		}

		@RequestMapping
		(value = "validade/BuscarValidade", method = RequestMethod.GET)
		public String BuscarTipo() {
			return "validade/BuscarValidade";
		}


	}
