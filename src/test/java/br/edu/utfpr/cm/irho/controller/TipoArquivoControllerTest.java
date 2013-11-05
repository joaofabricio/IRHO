package br.edu.utfpr.cm.irho.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.Test;

import br.edu.utfpr.cm.irho.model.Validade;
import br.edu.utfpr.cm.irho.service.TipoService;
import br.edu.utfpr.cm.irho.service.ValidadeService;

public class TipoArquivoControllerTest {

	private TipoArquivoController cadastrotipoArquivoController = new TipoArquivoController();

	@Test
	public void cadastroPessoaTipoArquivo() {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		ValidadeService service = EasyMock.createMock(ValidadeService.class);
		cadastrotipoArquivoController.setValidadeService(service);
		String ret = cadastrotipoArquivoController.cadastroTipoArquivo(request);
		assertEquals("tipoArquivo/cadastro", ret);
	}

	@Test
	public void cadastrarPessoaDescricaovazia() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response = EasyMock.createMock(HttpServletResponse.class);
		ValidadeService vService = EasyMock.createMock(ValidadeService.class);
		cadastrotipoArquivoController.setValidadeService(vService);
		String descricao = null;
		String ret = cadastrotipoArquivoController.cadastrarTipo(descricao,1l,
				request, response);
		assertEquals("tipoArquivo/cadastro", ret);
	}

	@Test
	public void cadastroPessoaSucesso() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response = EasyMock
				.createMock(HttpServletResponse.class);
		TipoService service = EasyMock.createMock(TipoService.class);
		ValidadeService vService = EasyMock.createMock(ValidadeService.class);
		EasyMock.expect(vService.find(1l)).andReturn(new Validade()).once();
		EasyMock.expect(vService.findByCriterion()).andReturn(null).once();
		EasyMock.replay(vService);
		cadastrotipoArquivoController.setValidadeService(vService);
		cadastrotipoArquivoController.setTipoService(service);
		String descricao = "TESTE";
		String ret = cadastrotipoArquivoController.cadastrarTipo(descricao,1l,request, response);
		assertEquals(null, ret);
	}

	@Test
	public void cadastroPessoaErro() {
		HttpServletRequest request = EasyMock
				.createMock(HttpServletRequest.class);
		TipoService service = EasyMock.createMock(TipoService.class);
		cadastrotipoArquivoController.setTipoService(service);
		String ret = cadastrotipoArquivoController.cadastroSucesso(null,
				request);
		assertEquals("tipoArquivo/cadastro", ret);
	}
	
}

