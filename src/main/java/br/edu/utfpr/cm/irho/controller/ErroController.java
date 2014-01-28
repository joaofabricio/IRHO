package br.edu.utfpr.cm.irho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErroController {

	@RequestMapping(value = "erro")
	public String erro() {
		return "Erro";
	}
}
