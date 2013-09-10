package br.edu.utfpr.cm.irho.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.utfpr.cm.irho.model.Arquivo;
import br.edu.utfpr.cm.irho.model.Caixa;
import br.edu.utfpr.cm.irho.model.Pessoa;
import br.edu.utfpr.cm.irho.model.Tipo;
import br.edu.utfpr.cm.irho.service.ArquivoService;
import br.edu.utfpr.cm.irho.service.CaixaService;
import br.edu.utfpr.cm.irho.service.PessoaService;
import br.edu.utfpr.cm.irho.service.TipoService;
import br.edu.utfpr.cm.libutfcm.dao.Criterion;
import br.edu.utfpr.cm.libutfcm.service.IGenericService;
import br.edu.utfpr.cm.libutfcm.util.DateUtil;

@Controller
public class BuscaArquivoController {

	@Autowired
	private ArquivoService arquivoService;
	
	@Autowired
	private TipoService tipoService;

	@Autowired
	private CaixaService caixaService;

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value = "arquivo/buscar", method = RequestMethod.GET)
	public String buscaArquivo(HttpServletRequest request) {
		
		Collection<Tipo> tipos = tipoService.findByCriterion();
		request.setAttribute("tipos", tipos);
		
		Collection<Caixa> caixas = caixaService.findByCriterion();
		request.setAttribute("caixas", caixas);
		
		return "arquivo/buscar";
	}
	
	@RequestMapping(value = "arquivo/buscarSubmit", method = RequestMethod.POST)
	public String buscarSubmit(String pessoa,
							   String dataArquivo,
							   Long tipo,
							   Long caixa,
							   String assunto,
							   HttpServletRequest request) {
		
 		Collection<Criterion> criterios = new ArrayList<Criterion>();
		

		if (StringUtils.hasText(pessoa)) {
			criterios.add(Criterion.like("pessoa.nome", pessoa));
		}
		
		Tipo t = tipoService.find(tipo);
		if (t != null) {
			criterios.add(Criterion.equal("tipo", t));
		}
		
		Caixa c = caixaService.find(caixa);
		if (c != null) {
			criterios.add(Criterion.equal("caixa", c));
		}
		
		if (dataArquivo != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date data;
			try {
				data = sdf.parse(dataArquivo);
				criterios.add(Criterion.equal("dataArquivo", data));
			} catch (ParseException e) {
				//data invalida
			}
		}
		
		if (StringUtils.hasText(assunto)) {
			criterios.add(Criterion.like("assunto", assunto));
		}
		
		Collection<Arquivo> arquivos = arquivoService.findByCriterion(criterios.toArray(new Criterion[0]));
		

		request.setAttribute("arquivos", arquivos);		
		
		return "arquivo/buscado";
		
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