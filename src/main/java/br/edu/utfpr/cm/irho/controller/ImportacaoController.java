package br.edu.utfpr.cm.irho.controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import br.edu.utfpr.cm.libutfcm.util.DateUtil;

@Controller
public class ImportacaoController {
	
	@Autowired
	private TipoService tipoService;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private CaixaService caixaService;

	@Autowired
	private ArquivoService arquivoService;
	
	@RequestMapping(value = "importar")
	public String telaInicial() {
		return "arquivo/importar";
	}
	
	@RequestMapping(value = "importar/post", method = RequestMethod.POST)
	@Transactional
	public String importar(String conteudoArquivo) throws ParseException {
		String[] linhas = conteudoArquivo.split("\n");
		for (int i = 0; i < linhas.length; i++) {
			String[] campo = linhas[i].split(",");
			if (campo.length != 8){
				throw new RuntimeException("número de campos inválido! linha "+i);
			}
			String tipoDescricao = campo[0].trim();
			Date dataArquivo = null;
			if (StringUtils.hasText(campo[1])) {
				dataArquivo = DateUtil.converteDataDDMMAAAA(campo[1].trim());
			}
			String assunto = campo[2].trim();
			String area = campo[3].trim();
			String nomePessoa = campo[4].trim();
			String caixaDescricao = campo[5].trim();
			String observacao = campo[6].trim();
			
			Arquivo arquivo = new Arquivo ();
			arquivo.setArea(area);
			arquivo.setAssunto(assunto);
			arquivo.setObservacao(observacao);
			arquivo.setDataArquivo(dataArquivo);
			
			Caixa caixa = new Caixa();
			Collection<Caixa> caixas = caixaService.findByCriterion(Criterion.equal("descricao", caixaDescricao));
			if (caixas.isEmpty()) {
				caixa.setDescricao(caixaDescricao);
				caixaService.save(caixa);
			} else {
				caixa = caixas.iterator().next();
			}
			if (caixas.size() > 1){
				throw new RuntimeException("Existe mais de uma caixa com essa descrição!");				
			}
			arquivo.setCaixa(caixa);

			if (StringUtils.hasText(nomePessoa)) {
				Pessoa pessoa = new Pessoa();
				Collection<Pessoa> pessoas = pessoaService.findByCriterion(Criterion.equal("nome", nomePessoa));
				if (pessoas.isEmpty()){
					pessoa.setNome(nomePessoa);
					pessoaService.save(pessoa);
				} else {
					pessoa = pessoas.iterator().next();
				}
				if (pessoas.size() > 1){
					throw new RuntimeException("Existe mais de uma pessoa com esse nome!");				
				}
				arquivo.setPessoa(pessoa);
			}
				
			Collection<Tipo> tipos = tipoService.findByCriterion(Criterion.equal("descricao", tipoDescricao));
			if (tipos.isEmpty() || !tipos.iterator().hasNext()) {
				throw new RuntimeException("Não existe o tipo "+tipoDescricao+" cadastrado!");
			}
			Tipo tipo = tipos.iterator().next();
			arquivo.setTipo(tipo);
			
			arquivoService.save(arquivo);
			
		}

		return telaInicial();
		
	}

}
