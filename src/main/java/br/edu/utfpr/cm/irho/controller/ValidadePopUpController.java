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
public class ValidadePopUpController {
	
	private static final String MSG_PRAZO_INVALIDO = "Prazo inválido";
	private static final String MSG_DESCRICAO_INVALIDA = "Descrição inválida";
	private static final String ERRO_REQUEST = "erro";
	private static final String OBJ_REQUEST = "validade";
	private static final String VALIDADE_CADASTRO_POPUP = "validade/cadastroPopup";
	private static final String VALIDADE_CADASTRO_POPUP_SUBMIT = "validade/cadastroPopupSubmit";
	private static final String VALIDADE_CADASTRO_POPUP_OK = "validade/cadastroPopupOk";
	@Autowired
	private ValidadeService validadeService;

	@RequestMapping(value = VALIDADE_CADASTRO_POPUP, method = RequestMethod.GET)
	public String cadastroPopup(HttpServletRequest request) {
		return VALIDADE_CADASTRO_POPUP;
	}
	

	@RequestMapping(value = VALIDADE_CADASTRO_POPUP_SUBMIT, method = RequestMethod.GET)
	public String cadastroPopupSubmit(String descricao, Integer prazoEmAnos,
									  HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Validade validade = new Validade();
		
		if (!StringUtils.hasText(descricao)) {
			request.setAttribute(ERRO_REQUEST, MSG_DESCRICAO_INVALIDA);
			request.setAttribute(OBJ_REQUEST, validade);
			return cadastroPopup(request);
		}
		
		validade.setDescricao(descricao);
		
		if (prazoEmAnos == null || prazoEmAnos < 0) {
			request.setAttribute(ERRO_REQUEST, MSG_PRAZO_INVALIDO);
			request.setAttribute(OBJ_REQUEST, validade);
			return cadastroPopup(request);
		}

		validade.setPrazoEmAnos(prazoEmAnos);
		validadeService.save(validade);

		response.sendRedirect("cadastroPopupOk"+"?id="+validade.getId());
		return null;
	}
	
	@RequestMapping(value = VALIDADE_CADASTRO_POPUP_OK, method = RequestMethod.GET)
	public String cadastroPopupOk(Long id, HttpServletRequest request) {
		request.setAttribute(OBJ_REQUEST, validadeService.find(id));
		return VALIDADE_CADASTRO_POPUP_OK;
	}
	
}
