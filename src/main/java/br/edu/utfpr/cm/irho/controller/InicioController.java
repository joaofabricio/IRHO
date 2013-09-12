package br.edu.utfpr.cm.irho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio() {
		return "inicio";
	}
	
	@RequestMapping(value = "/sobre", method = RequestMethod.GET)
	public String sobre() {
		return "sobre";
	}
}
