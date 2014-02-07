package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.utfpr.cm.irho.model.Pessoa;
import br.edu.utfpr.cm.irho.service.PessoaService;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(value = "pessoa/editar", method =  RequestMethod.GET)
	public String editarPessoa(Long id,
							   @RequestParam(required = false) String origem,
							   HttpServletRequest request) {
		
		Pessoa p = pessoaService.find(id);
		request.setAttribute("pessoa", p);
		
		if (origem != null) {
			request.setAttribute("msg", "Pessoa gravada com sucesso");
		}
		
		return "pessoa/cadastro";
	}
	
	@RequestMapping(value="pessoa/excluir")
	public String excluir(Long id, String ctx, HttpServletRequest request){
		Pessoa pessoa=pessoaService.find(id);
		request.setAttribute("id", pessoa.getId());
		request.setAttribute("descricao", pessoa.getNome());
		request.setAttribute("entidade", "pessoa");
		request.setAttribute("action", "pessoa/ExcluirPessoa");
		request.setAttribute("ctx", ctx);
		return "ExcluirConfirmacao";
	}
	@RequestMapping(value="pessoa/ExcluirPessoa")
	public String excluirDelete(Long id, HttpServletRequest request){
		Pessoa pessoa = pessoaService.find(id);
		request.setAttribute("Nome", pessoa.getNome());
		request.setAttribute("entidade", "pessoa");
		pessoaService.delete(pessoa);
		return "ExcluidoSucesso";
	}
	
	@RequestMapping(value = "pessoa/cadastro", method =  RequestMethod.GET)
	public String cadastroPessoa(HttpServletRequest request) {
		request.setAttribute("pessoa", new Pessoa());
		return "pessoa/cadastro";
	}
	
	@RequestMapping(value = "pessoa/cadastrar", method = RequestMethod.POST)
	public String editadoPessoa(String nome, Long id,
								  HttpServletRequest request,
								  HttpServletResponse response) throws IOException {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(id);
		pessoa.setNome(nome);
		if (!StringUtils.hasText(nome)) {
			request.setAttribute("erro", "Nome inválido");
			return "pessoa/cadastro";
		}
		
		pessoaService.save(pessoa);
		
		response.sendRedirect("editar?origem=cad&id="+pessoa.getId());
		return null;
	}
		
		
	
	@RequestMapping(value = "pessoa/cadastradoSucesso", method = RequestMethod.GET)
	public String cadastradoSucesso(Long id,HttpServletRequest request) {
		
		Pessoa pessoa=pessoaService.find(id);
		request.setAttribute("nomePessoa", pessoa.getNome());
		
		
		return "pessoa/cadastradoSucesso";
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
		
		
}

