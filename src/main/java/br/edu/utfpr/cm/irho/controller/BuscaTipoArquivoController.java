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
import br.edu.utfpr.cm.irho.service.TipoService;
import br.edu.utfpr.cm.libutfcm.dao.Criterion;
import br.edu.utfpr.cm.libutfcm.dao.Order;


@Controller
public class BuscaTipoArquivoController {
	
		@Autowired
		private TipoService tipoService;

		@RequestMapping(value = "tipo/buscar", method = RequestMethod.GET)
		public String cadastroTipoArquivo() {
			return "tipoArquivo/buscarTipo";
		}

		@RequestMapping(value = "tipo/buscar", method = RequestMethod.POST)
		public String buscarTipo(String descricao, String ordem,
				HttpServletRequest request, HttpServletResponse response)
				throws IOException {

			Criterion criterion = Criterion.like("descricao",descricao);

			ordem = ordem!=null? ordem: "descricao";

			Order o = Order.ascending(ordem);

			Collection<Tipo> retorno = tipoService.findByCriterion(o, criterion);

			request.setAttribute("result", retorno);

			request.setAttribute("descricao", descricao);
			return "tipoArquivo/buscadoTipo";
		}

		@RequestMapping(value = "tipo/BuscarTipo", method = RequestMethod.GET)
		public String BuscarTipo() {
			return "tipoArquivo/buscarTipo";
		}

		public void setTipoService(TipoService tipoService) {
			this.tipoService = tipoService;
		}

	}
