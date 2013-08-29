package br.edu.utfpr.cm.irho.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import br.edu.utfpr.cm.irho.service.CaixaService;

public class CaixaControllerTest {
	
	private CaixaController caixaController = new CaixaController();

	@Before
	public void before() {
		CaixaService serviceMock = EasyMock.createMock(CaixaService.class);
		caixaController.setPessoaService(serviceMock);
		
	}
	
	@Test
	public void testeInsereCaixa() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String descricao = "B45";
		String telaRetorno = caixaController.cadastroCaixa(descricao, request, response);
		assertEquals(null, telaRetorno);
	}
	
	@Test
	public void testeInsereCaixaDescricaoNulo() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String descricao = null;
		String telaRetorno = caixaController.cadastroCaixa(descricao, request, response);
		assertEquals("caixa/cadastroCaixa", telaRetorno);
	}
	
	@Test
	public void testeInsereCaixaDescriçãoVazia() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String descricao = "";
		String telaRetorno = caixaController.cadastroCaixa(descricao, request, response);
		assertEquals("caixa/cadastroCaixa", telaRetorno);
	}
	
	@Test
	public void testeInsereCaixaDescriçãoVazia2() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String descricao = "            ";
		String telaRetorno = caixaController.cadastroCaixa(descricao, request, response);
		assertEquals("caixa/cadastroCaixa", telaRetorno);
	}

}

