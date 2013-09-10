package br.edu.utfpr.cm.irho.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMock;
import org.junit.Test;

import br.edu.utfpr.cm.irho.service.ArquivoService;
import br.edu.utfpr.cm.irho.service.CaixaService;
import br.edu.utfpr.cm.irho.service.TipoService;

public class BuscaArquivoControllerTest {

	@Test
	public void testeBuscaArquivo() throws IOException {
		HttpServletRequest request = EasyMock.createStrictMock(HttpServletRequest.class);
		
		BuscaArquivoController buscaArquivo= new BuscaArquivoController();
	
		TipoService tipoService = EasyMock.createStrictMock(TipoService.class);
		EasyMock.expect(tipoService.findByCriterion()).andReturn(null).once();
		request.setAttribute("tipos", null);
		EasyMock.expectLastCall();
		
		CaixaService caixaService = EasyMock.createStrictMock(CaixaService.class);
		EasyMock.expect(caixaService.findByCriterion()).andReturn(null).once();
		request.setAttribute("caixas", null);
		EasyMock.expectLastCall();
		
		EasyMock.replay(caixaService);
		EasyMock.replay(tipoService);
		EasyMock.replay(request);
		
		buscaArquivo.setTipoService(tipoService);
		buscaArquivo.setCaixaService(caixaService);
		
		String telaRetorno = buscaArquivo.buscaArquivo(request);
		assertEquals("arquivo/buscar", telaRetorno);
	}
	
	@Test
	public void buscaSubmitTudoNull() throws IOException {
		
		BuscaArquivoController buscaArquivo = new BuscaArquivoController();
		
		String pessoa = null;
		String dataArquivo = null;
		Long tipo = null;
		Long caixa = null;
		String assunto = null;
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		
		ArquivoService service = EasyMock.createStrictMock(ArquivoService.class);
		EasyMock.expect(service.findByCriterion()).andReturn(null).once();
		request.setAttribute("arquivos", null);
		EasyMock.expectLastCall();
		
		TipoService tipoService = EasyMock.createStrictMock(TipoService.class);
		EasyMock.expect(tipoService.find(null)).andReturn(null).once();
		
		CaixaService caixaService = EasyMock.createStrictMock(CaixaService.class);
		EasyMock.expect(caixaService.find(null)).andReturn(null).once();
		
		buscaArquivo.setArquivoService(service);
		buscaArquivo.setTipoService(tipoService);
		buscaArquivo.setCaixaService(caixaService);
		
		String retorno = buscaArquivo.buscarSubmit(pessoa, dataArquivo, tipo, caixa, assunto, request);
		assertEquals("arquivo/buscado", retorno);
	}
	
	@Test
	public void buscaSubmitQuaseTudoNullPessoa() throws IOException {
		
		BuscaArquivoController buscaArquivo = new BuscaArquivoController();
		
		String pessoa = "Apenas um rapaz latino americano.";
		String dataArquivo = null;
		Long tipo = null;
		Long caixa = null;
		String assunto = null;
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		
		ArquivoService service = EasyMock.createStrictMock(ArquivoService.class);
		EasyMock.expect(service.findByCriterion()).andReturn(null).once();
		request.setAttribute("arquivos", null);
		EasyMock.expectLastCall();
		
		TipoService tipoService = EasyMock.createStrictMock(TipoService.class);
		EasyMock.expect(tipoService.find(null)).andReturn(null).once();
		
		CaixaService caixaService = EasyMock.createStrictMock(CaixaService.class);
		EasyMock.expect(caixaService.find(null)).andReturn(null).once();
		
		buscaArquivo.setArquivoService(service);
		buscaArquivo.setTipoService(tipoService);
		buscaArquivo.setCaixaService(caixaService);
		
		String retorno = buscaArquivo.buscarSubmit(pessoa, dataArquivo, tipo, caixa, assunto, request);
		assertEquals("arquivo/buscado", retorno);
}
	
	@Test
	public void buscaSubmitQuaseTudoNulltipo() throws IOException {
		
		BuscaArquivoController buscaArquivo = new BuscaArquivoController();
		
		String pessoa = null;
		String dataArquivo = null;
		Long tipo = 1l;
		Long caixa = null;
		String assunto = null;
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		
		ArquivoService service = EasyMock.createStrictMock(ArquivoService.class);
		EasyMock.expect(service.findByCriterion()).andReturn(null).once();
		request.setAttribute("arquivos", null);
		EasyMock.expectLastCall();
		
		TipoService tipoService = EasyMock.createStrictMock(TipoService.class);
		EasyMock.expect(tipoService.find(null)).andReturn(null).once();
		
		CaixaService caixaService = EasyMock.createStrictMock(CaixaService.class);
		EasyMock.expect(caixaService.find(null)).andReturn(null).once();
		
		buscaArquivo.setArquivoService(service);
		buscaArquivo.setTipoService(tipoService);
		buscaArquivo.setCaixaService(caixaService);
		
		String retorno = buscaArquivo.buscarSubmit(pessoa, dataArquivo, tipo, caixa, assunto, request);
		assertEquals("arquivo/buscado", retorno);
}
	@Test
	public void buscaSubmitQuaseTudoNulldataArquivo() throws IOException {
		
		BuscaArquivoController buscaArquivo = new BuscaArquivoController();
		
		String pessoa = null;
		String dataArquivo = "2013/12/1";
		Long tipo = null;
		Long caixa = null;
		String assunto = null;
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		
		ArquivoService service = EasyMock.createStrictMock(ArquivoService.class);
		
		TipoService tipoService = EasyMock.createStrictMock(TipoService.class);
		
		CaixaService caixaService = EasyMock.createStrictMock(CaixaService.class);
		
		buscaArquivo.setArquivoService(service);
		buscaArquivo.setTipoService(tipoService);
		buscaArquivo.setCaixaService(caixaService);
		
		String retorno = buscaArquivo.buscarSubmit(pessoa, dataArquivo, tipo, caixa, assunto, request);
		assertEquals("arquivo/buscado", retorno);
}
}