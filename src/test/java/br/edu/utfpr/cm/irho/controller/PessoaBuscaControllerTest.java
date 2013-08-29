package br.edu.utfpr.cm.irho.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.Test;

import br.edu.utfpr.cm.irho.service.PessoaService;

public class PessoaBuscaControllerTest {

	@Test
	public void testebuscarPessoa() throws IOException {
		HttpServletRequest request = EasyMock
				.createMock(HttpServletRequest.class);
		HttpServletResponse response = EasyMock
				.createMock(HttpServletResponse.class);
		PessoaService service = EasyMock.createMock(PessoaService.class);
		String nome = "Mar";
		String ordem = "3";
		PessoaBuscaController pessoaBuscaController = new PessoaBuscaController();
		pessoaBuscaController.setPessoaService(service);
		String telaRetorno = pessoaBuscaController.buscarPessoa(nome, ordem,
				request, response);
		assertEquals("pessoa/BuscadoPessoa", telaRetorno);
	}

	@Test
	public void testeBuscarPessoa() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response = EasyMock.createMock(HttpServletResponse.class);
		PessoaBuscaController pessoaBuscaController = new PessoaBuscaController();
		String telaRetorno = pessoaBuscaController.BuscarPessoa();
		assertEquals("pessoa/BuscarPessoa", telaRetorno);
	}


	}

