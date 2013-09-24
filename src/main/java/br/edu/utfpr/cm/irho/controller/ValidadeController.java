package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.utfpr.cm.irho.model.Validade;
import br.edu.utfpr.cm.irho.service.ValidadeService;
@Controller
public class ValidadeController {

	@Autowired
	private ValidadeService ValidadeService;

	@RequestMapping(value = "validade/cadastroValidade", method = RequestMethod.GET)
	public String cadastroValidade() {
		return "validade/cadastroValidade";
	}

	@RequestMapping(value = "validade/cadastrarValid", method = RequestMethod.POST)
	public String cadastroValidade(Integer prazoEmAnos, String descricao, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Validade validade = new Validade();
		
		if (!StringUtils.hasText(descricao)) {
			request.setAttribute("erro", "Descrição inválida.");
			request.setAttribute("validade", validade);
			return cadastroValidade();
		}
		
		validade.setDescricao(descricao);
		
		if (prazoEmAnos == null || prazoEmAnos < 0) {
			request.setAttribute("erro", "Prazo inválido.");
			request.setAttribute("validade", validade);
			return cadastroValidade();
		}

		validade.setPrazoEmAnos(prazoEmAnos);
		ValidadeService.save(validade);

		response.sendRedirect("cadastroSucessoValidade?id="+validade.getId());
		return null;
	}

	@RequestMapping(value = "validade/cadastroSucessoValidade", method = RequestMethod.GET)
	public String cadastroSucesso(Long id,HttpServletRequest request) {
		
		Validade validade=ValidadeService.find(id);
		request.setAttribute("Descrition", validade.getDescricao());
		
		return "validade/cadastroSucessoValidade";
	}

	public void setValidadeService(ValidadeService validService) {
		this.ValidadeService = validService;
	}

}