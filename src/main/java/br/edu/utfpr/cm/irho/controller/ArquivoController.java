package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.utfpr.cm.irho.model.Arquivo;
import br.edu.utfpr.cm.irho.service.ArquivoService;

@Controller
public class ArquivoController {

	@Autowired
	private ArquivoService arquivoService;
	
	@RequestMapping(value = "arquivo/cadastroArquivo", method = RequestMethod.GET)
	public String cadastroCaixa() {
		return "caixa/cadastroArquivo";
	}
	@RequestMapping(value = "caixa/cadastrarCaixa", method = RequestMethod.POST)
	