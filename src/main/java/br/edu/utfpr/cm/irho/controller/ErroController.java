package br.edu.utfpr.cm.irho.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErroController {

	@RequestMapping(value = "erro")
	public String erro(HttpServletRequest request) {
		return "Erro";
	}

	@RequestMapping(value = "acessoNegado")
	public String acessoNegado() {
		return "login/acessoNegado";
	}
}
