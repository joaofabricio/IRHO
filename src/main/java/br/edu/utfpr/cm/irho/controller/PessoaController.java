package br.edu.utfpr.cm.irho.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.utfpr.cm.irho.model.Pessoa;
import br.edu.utfpr.cm.irho.service.PessoaService;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(value = "pessoa/cadastro", method =  RequestMethod.GET)
	public String cadastroPessoa() {
		return "pessoa/cadastro";
	}
	
	@RequestMapping(value = "pessoa/cadastrar", method = RequestMethod.POST)
	public String cadastrarPessoa(String nome, 
								  HttpServletRequest request,
								  HttpServletResponse response) throws IOException {
		
		if (!StringUtils.hasText(nome)) {
			request.setAttribute("erro", "Nome invalido.");
			return "pessoa/cadastro";
		}
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoaService.save(pessoa );
		
		response.sendRedirect("cadastradoSucesso?id="+pessoa.getId());
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
		
		
//		@RequestMapping(value = "pessoa/cadastradoSucesso", method = RequestMethod.POST)
//		public String cadastrarSucesso(String nome) {
//			
//			return "pessoa/cadastroSucesso";
//	}

}

