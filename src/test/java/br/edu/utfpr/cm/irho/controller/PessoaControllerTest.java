package br.edu.utfpr.cm.irho.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import br.edu.utfpr.cm.irho.service.PessoaService;

public class PessoaControllerTest {
	
	private PessoaController pessoaController = new PessoaController();

	@Before
	public void before() {
		PessoaService serviceMock = EasyMock.createMock(PessoaService.class);
		pessoaController.setPessoaService(serviceMock);
		
	}
	
	@Test
	public void testeInserePessoa() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String nome = "Marcus";
		String telaRetorno = pessoaController.editadoPessoa(nome, null, request, response);
		assertEquals(null, telaRetorno);
	}
	
	@Test
	public void testeInserePessoaNomeNulo() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String nome = null;
		String telaRetorno = pessoaController.editadoPessoa(nome, null, request, response);
		assertEquals("pessoa/cadastro", telaRetorno);
	}
	
	@Test
	public void testeInserePessoaNomeVazio() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String nome = "";
		String telaRetorno = pessoaController.editadoPessoa(nome, null, request, response);
		assertEquals("pessoa/cadastro", telaRetorno);
	}
	
	@Test
	public void testeInserePessoaNomeVazio2() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response= EasyMock.createMock(HttpServletResponse.class);
		String nome = "            ";
		String telaRetorno = pessoaController.editadoPessoa(nome, null, request, response);
		assertEquals("pessoa/cadastro", telaRetorno);
	}

}

