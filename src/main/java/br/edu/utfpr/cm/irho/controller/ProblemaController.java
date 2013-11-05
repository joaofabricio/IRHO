package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.cm.irho.model.Problema;
import br.edu.utfpr.cm.irho.service.ProblemaService;

@Controller
public class ProblemaController {
	
	@Autowired
	private ProblemaService problemaService;
	
	@RequestMapping(value="problemas")
	public String problemas(HttpServletRequest request) {
		
		Collection<Problema> problemas = problemaService.findByCriterion();
		request.setAttribute("result", problemas );
		
		return "problema/problemas";
	}
	
	@RequestMapping(value="problemas/mudaStatus")
	public String mudaStatus(Long id, HttpServletResponse response) throws IOException {
		
		Problema problema = problemaService.find(id);
		problema.setTerminado(!problema.getTerminado());
		
		problemaService.save(problema);
		
		response.sendRedirect("../problemas");
		return null;
	}
	

	@RequestMapping(value="problemas/incluir")
	public String incluir(String descricao, HttpServletResponse response) throws IOException {
		
		Problema problema = new Problema();
		problema.setDescricao(descricao);
		problema.setTerminado(false);
		
		problemaService.save(problema);
		
		response.sendRedirect("../problemas");
		return null;
	}

}
