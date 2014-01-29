package br.edu.utfpr.cm.irho.controller;

import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.InetOrgPerson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio(HttpServletRequest req, HttpServletResponse res) {
		
		InetOrgPerson principal = (InetOrgPerson) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		
		String nomePessoa = principal.getCn()[0];
		
		req.setAttribute("saudacao", "Olá, "+nomePessoa);
		
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login_irho")) {
				cookie.setValue(principal.getUsername());
				return "inicio";
			}
		}
		
		Cookie cookie = new Cookie("login_irho", principal.getUsername());
		res.addCookie(cookie );
		
		
		return "inicio";
	}
	
	@RequestMapping(value = "/sobre", method = RequestMethod.GET)
	public String sobre() {
		return "sobre";
	}
}
