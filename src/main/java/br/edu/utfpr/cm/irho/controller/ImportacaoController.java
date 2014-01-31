package br.edu.utfpr.cm.irho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImportacaoController {
	
	@RequestMapping(value = "importar")
	public String telaInicial() {
		return "importacao/telaInicial";
	}

}
