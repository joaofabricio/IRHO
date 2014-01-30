package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.utfpr.cm.irho.model.Arquivo;
import br.edu.utfpr.cm.irho.model.Caixa;
import br.edu.utfpr.cm.irho.model.Pessoa;
import br.edu.utfpr.cm.irho.model.Tipo;
import br.edu.utfpr.cm.irho.service.ArquivoService;
import br.edu.utfpr.cm.irho.service.CaixaService;
import br.edu.utfpr.cm.irho.service.PessoaService;
import br.edu.utfpr.cm.irho.service.TipoService;
import br.edu.utfpr.cm.libutfcm.dao.Order;
import br.edu.utfpr.cm.libutfcm.util.DateUtil;

@Controller
public class ArquivoController {

	@Autowired
	private ArquivoService arquivoService;
	
	@Autowired
	private TipoService tipoService;

	@Autowired
	private CaixaService caixaService;

	@Autowired
	private PessoaService pessoaService;


	@RequestMapping(value = "arquivo/cadastroArquivo", method = RequestMethod.GET)
	public String cadastroArquivo(HttpServletRequest request) {
		
		Collection<Tipo> tipos = tipoService.findByCriterion(Order.ascending("descricao"));
		request.setAttribute("tipos", tipos);
		
		Collection<Caixa> caixas = caixaService.findByCriterion(Order.ascending("descricao"));
		request.setAttribute("caixas", caixas);
		
		Collection<Pessoa> pessoas = pessoaService.findByCriterion(Order.ascending("nome"));
		request.setAttribute("pessoas", pessoas);
		
		request.setAttribute("arquivo", new Arquivo());
		
		return "arquivo/cadastroArquivo";
	}
	
	@RequestMapping(value = "arquivo/editar", method = RequestMethod.GET)
	public String editar(Long id, 
						 @RequestParam(required=false) String origem, 
						 HttpServletRequest request) {
		
		Collection<Tipo> tipos = tipoService.findByCriterion(Order.ascending("descricao"));
		request.setAttribute("tipos", tipos);
		
		Collection<Caixa> caixas = caixaService.findByCriterion(Order.ascending("descricao"));
		request.setAttribute("caixas", caixas);
		
		Collection<Pessoa> pessoas = pessoaService.findByCriterion(Order.ascending("nome"));
		request.setAttribute("pessoas", pessoas);

		if (request.getAttribute("arquivo") == null) {
			request.setAttribute("arquivo", arquivoService.find(id));
		}
		
		if (origem != null) {
			request.setAttribute("msg", "O Arquivo foi gravado com sucesso");
		}

		return "arquivo/cadastroArquivo";
	}

	@RequestMapping(value = "arquivo/cadastroSubmit", method = RequestMethod.POST)
	public String cadastroSubmit(Long id,
								 Long idPessoa,
							   	 String dataArquivo,
							   	 Long idTipo,
							   	 Long idCaixa,
							   	 String assunto,
							   	 String area,
							   	 String observacao,
							   	 HttpServletRequest request,
							   	 HttpServletResponse response) throws IOException {
		
		Arquivo arquivo = id == null? new Arquivo() : arquivoService.find(id);
		arquivo.setArea(area);
		arquivo.setObservacao(observacao);
		
		String erro = "";
		
		if (!StringUtils.hasText(assunto)) {
			erro = "Digite um assunto";
		}
		arquivo.setAssunto(assunto);
		
		
		if (dataArquivo != null) {
			Date data;
			try {
				data = DateUtil.converteDataDDMMAAAA(dataArquivo);
				arquivo.setDataArquivo(data);
			} catch (ParseException e) {
				erro = "Digite a data no formato DD/MM/AAAA";
			}
		}
 		
		if (idPessoa != null && idPessoa > 0) {
			Pessoa pessoa = pessoaService.find(idPessoa);
			arquivo.setPessoa(pessoa);
			if ( pessoa == null) {
				erro="A pessoa especificada não existe";
			}
		}
		
		if (idCaixa != null && idCaixa > 0) {
			Caixa caixa = caixaService.find(idCaixa);
			arquivo.setCaixa(caixa);
			if (caixa == null) {
				erro="A caixa especificada não existe";
			}
		}
		
 		if (idTipo != null && idTipo > 0) {
 			Tipo tipo = tipoService.find(idTipo);
 			arquivo.setTipo(tipo);
 			if (tipo == null) {
 				erro="O tipo especificado não existe";
 			}
 		} else {
 			erro="Selecione o tipo";
 		}
 		
 		if(StringUtils.hasText(erro)){
 			request.setAttribute("erro", erro);
 			request.setAttribute("arquivo", arquivo);
 			
			return editar(id, null, request);
 		}
 		
 		arquivoService.save(arquivo);
 		
 		response.sendRedirect("editar?origem=cad&id="+arquivo.getId());
 		return null;
//		return "arquivo/cadastroSucessoArquivo";
		
		
	}
	
	@RequestMapping(value="arquivo/excluir")
	public String excluir(Long id, String ctx, HttpServletRequest request){
		Arquivo arquivo=arquivoService.find(id);
		request.setAttribute("id", arquivo.getId());
		request.setAttribute("descricao", arquivo.getAssunto()+" de "+arquivo.getDataArquivoFormatada());
		request.setAttribute("entidade", "arquivo");
		request.setAttribute("action", "arquivo/excluido");
		request.setAttribute("ctx", ctx);
		return "ExcluirConfirmacao";
	}
	
	@RequestMapping(value="arquivo/excluido")
	public String excluirDelete(Long id, HttpServletRequest request){
		Arquivo arquivo = arquivoService.find(id);
		request.setAttribute("Nome", arquivo.getAssunto()+" de "+arquivo.getDataArquivoFormatada());
		request.setAttribute("entidade", "arquivo");
		arquivoService.delete(arquivo);
		return "ExcluidoSucesso";
	}
	
	@RequestMapping(value = "arquivo")
	public String visualizar(Long id, HttpServletRequest request) {
		Arquivo arquivo = arquivoService.find(id);
		
		if (arquivo == null) {
			request.setAttribute("erro", "Não foi possível encontrar o arquivo com o id "+id);
			return cadastroArquivo(request);
		}
		
		request.setAttribute("arquivo", arquivo);
		return "arquivo/visualizar";
	}
	
	public void setArquivoService(ArquivoService arquivoService) {
		this.arquivoService = arquivoService;
	}
	
	public void setCaixaService(CaixaService caixaService) {
		this.caixaService = caixaService;
	}
	
	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	public void setTipoService(TipoService tipoService) {
		this.tipoService = tipoService;
	}

}
	
	
