package br.edu.utfpr.cm.irho.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import br.edu.utfpr.cm.irho.service.ValidadeService;

public class ValidadeControllerTest {
	
	private ValidadeController ValidadeController = new ValidadeController();

	@Before
	public void before() {
		ValidadeService serviceMock = EasyMock.createMock(ValidadeService.class);
		ValidadeController.setValidadeService(serviceMock);
		
	}
	
	@Test
	public void testeInsereValidade() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String descricao = "1 ano";
		String telaRetorno = ValidadeController.cadastroValidade(descricao, request, response);
		assertEquals(null, telaRetorno);
	}
	
	@Test
	public void testeInsereValidadeDescricaoNulo() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String descricao = null;
		String telaRetorno = ValidadeController.cadastroValidade(descricao, request, response);
		assertEquals("validade/cadastroValidade", telaRetorno);
	}
	
	@Test
	public void testeInsereValidadeDescriçãoVazia() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String descricao = "";
		String telaRetorno = ValidadeController.cadastroValidade(descricao, request, response);
		assertEquals("validade/cadastroValidade", telaRetorno);
	}
	
	@Test
	public void testeInsereValidadeDescriçãoVazia2() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String descricao = "            ";
		String telaRetorno = ValidadeController.cadastroValidade(descricao, request, response);
		assertEquals("validade/cadastroValidade", telaRetorno);
	}

}

