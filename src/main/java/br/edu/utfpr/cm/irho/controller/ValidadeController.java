package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.utfpr.cm.irho.model.Validade;
import br.edu.utfpr.cm.irho.service.ValidadeService;
@Controller
public class ValidadeController {

	@Autowired
	private ValidadeService validadeService;
	
	@RequestMapping(value = "validade/editarValidade", method =  RequestMethod.GET)
	public String editarValidade(Long id, HttpServletRequest request) {
		Validade p = validadeService.find(id);
		request.setAttribute("validade", p);
		
		return "validade/editarValidade";
	}

	@RequestMapping(value = "validade/cadastroValidade", method = RequestMethod.GET)
	public String cadastroValidade() {
		return "validade/cadastroValidade";
	}

	@RequestMapping(value="validade/excluir")
	public String excluir(Long id, String ctx, HttpServletRequest request){
		Validade validade = validadeService.find(id);
		request.setAttribute("id", validade.getId());
		request.setAttribute("descricao", validade.getDescricao());
		request.setAttribute("entidade", "validade");
		request.setAttribute("action", "validade/ExcluirValidade");
		request.setAttribute("ctx", ctx);
		return "ExcluirConfirmacao";
	}
	@RequestMapping(value="validade/ExcluirValidade")
	public String excluirDelete(Long id, HttpServletRequest request){
		Validade validade= validadeService.find(id);
		request.setAttribute("Nome", validade.getDescricao());
		request.setAttribute("entidade", "validade");
		validadeService.delete(validade);
		return "ExcluidoSucesso";
	}
	
	@RequestMapping(value = "validade/cadastrarValid", method = RequestMethod.POST)
	public String cadastroValidade(Integer prazoEmAnos, String descricao, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Validade validade = new Validade();
		
		if (!StringUtils.hasText(descricao)) {
			request.setAttribute("erro", "Descrição inválida.");
			request.setAttribute("validade", validade);
			return cadastroValidade();
		}
		
		validade.setDescricao(descricao);
		
		if (prazoEmAnos == null || prazoEmAnos < 0) {
			request.setAttribute("erro", "Prazo inválido.");
			request.setAttribute("validade", validade);
			return cadastroValidade();
		}

		validade.setPrazoEmAnos(prazoEmAnos);
		validadeService.save(validade);

		response.sendRedirect("cadastroSucessoValidade?id="+validade.getId());
		return null;
	}
	@RequestMapping(value = "validade/editado", method = RequestMethod.POST)
	public String cadastrarCaixa(String descricao, Long id, Integer prazoEmAnos,
								  HttpServletRequest request,
								  HttpServletResponse response) throws IOException {
		
		Validade validade = new Validade();
		validade.setId(id);
		
		if (!StringUtils.hasText(descricao)) {
			request.setAttribute("erro", "Nome invalido.");
			return cadastroValidade();
		}

	    validade.setDescricao(descricao);
		
		if (prazoEmAnos == null || prazoEmAnos < 0) {
			request.setAttribute("erro", "Prazo inválido.");
			request.setAttribute("validade", validade);
			return cadastroValidade();
		}

		validade.setPrazoEmAnos(prazoEmAnos);
		validadeService.save(validade);
		
		response.sendRedirect("cadastroSucessoValidade?id="+validade.getId());
		return null;
	}

	@RequestMapping(value = "validade/cadastroSucessoValidade", method = RequestMethod.GET)
	public String cadastroSucesso(Long id,HttpServletRequest request) {
		
		Validade validade=validadeService.find(id);
		request.setAttribute("Descrition", validade.getDescricao());
		
		return "validade/cadastroSucessoValidade";
	}

	public void setValidadeService(ValidadeService validService) {
		this.validadeService = validService;
	}

}
