<%@page import="br.edu.utfpr.cm.irho.model.Arquivo"%>
<%@page import="br.edu.utfpr.cm.libutfcm.util.DateUtil"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<script type="text/javascript">
	function selecionarPessoa(id, nome) {
		document.getElementById("pessoaId").value = id;
		document.getElementById("pessoaNome").value=nome;
	}
	function selecionarCaixa(id, nome) {
		document.getElementById("caixaId").value = id;
		document.getElementById("caixaDescricao").value=nome;
	}
</script>

<form action="${ctx}/arquivo/cadastroSubmit" method="post" onload="dataAtual()">

	<div id="titulo"> Cadastro de Arquivos</div>
	<br/>
	
	<div class="campo">
		<span class="legendaCampo">
			Escolha um tipo para o Arquivo
		</span>
		<br />
		
		<label for="descricao">Tipo*:</label>
		
		<select name="idTipo" style="max-width: 250px; ${erro!=null? 'border-color: red;' : ''}" autofocus="autofocus">
		<option value="-1">Selecione o Tipo</option>
			<c:forEach var="o" items="${tipos}">
				<option value="${o.id}" ${(arquivo != null && arquivo.tipo.id == o.id)? 'selected=="selected"':''}>
					${o.descricao}
				</option>
			</c:forEach>
		</select>
	</div>
	
	<br/>
	
	<div class="campo">
		<span class="legendaCampo">
			Digite uma data de entrada no formato dd/mm/aaaa
		</span>
		<br />
		
		<label for="dataArquivo"> Data*:</label>
		<input type="text"
			   name="dataArquivo" 
			   id="dataArquivo" 
			   value="${arquivo!=null?arquivo.getDataArquivoFormatada():''}"
			   style="${erro!=null? 'border-color: red;' : ''}" 
			   size="10"/>
	</div>
	
	<br />
	
	<div class="campo">
		<span class="legendaCampo">
			Digite um assunto para a melhor localização do Arquivo
		</span>
		<br />
		
		<label for="assunto">Assunto*:</label>
		<input type="text"
			   name="assunto"
			   value="${arquivo.assunto}"
			   style="${erro!=null? 'border-color: red;' : ''}"
			   size="30" />
	</div>
	
	<br/>
	<div class="campo">
		<span class="legendaCampo">
			Opcionalmente, pode-se digitar uma área no caso de testes seletivos
		</span>
		<br />
		<label for="area">Área:</label>
		<input type="text" name="area" value="${arquivo.area}" size="30" />
	</div>	
	<br/>
	
	<div class="campo">
		<span class="legendaCampo">
			Selecione uma pessoa para vinculá-la ao Arquivo
		</span>
		<br />
		<label for="nome">Pessoa:</label>
		
		<input type="hidden" name="idPessoa" value="${arquivo.pessoa.id}" id="pessoaId" />
		<input type="text" 
			   value="${arquivo.pessoa!=null? arquivo.pessoa.nome : '[nenhuma]'}" 
			   id="pessoaNome" 
			   size="30" 
			   style="border-style: none;"
			   readonly="readonly" />
		<br />
		<input type="button"
			   onclick="showPopup('${ctx}/pessoa/popup');"
			   value="buscar" />
		<input type="button" style="left: 53%"
			   onclick="selecionarPessoa(-1, '[nenhuma]');"
			   value="remover" />
	</div>
	<br />
	<div class="campo">
		<span class="legendaCampo">
			Selecione a caixa em que será arquivado
		</span>
		<br />
		
		<label for="caixaDescricao">Caixa:</label>
		<input type="hidden" name="idCaixa" value="${arquivo.caixa.id}" id="caixaId" />
		<input type="text" 
			   value="${arquivo.caixa!=null? arquivo.caixa.descricao : '[nenhuma]'}" 
			   id="caixaDescricao" 
			   size="30" 
			   style="border-style: none;"
			   readonly="readonly" />
		<br />
		<input type="button"
			   onclick="showPopup('${ctx}/caixa/popup');"
			   value="buscar" />
		<input type="button" style="left: 53%"
			   onclick="selecionarCaixa(-1, '[nenhuma]');"
			   value="remover" />
	</div>
	<br/>
	
	<div class="campo">
		<span class="legendaCampo">
			Digite aqui observações importantes sobre o Arquivo
		</span>
		<br />
		
		<label for="observacao"> Observação:</label>
		<textarea name="observacao">${arquivo.observacao}</textarea>
<%-- 		<input type="text" name="observacao" id="observacao" value="${arquivo!=null?arquivo.observacao:''}" /> --%>
	</div>
	
	<br />
	<br />
	<br />
	
	<div class="botoes">
		<input type="submit" value="Cadastro"/>
	</div>

</form>

<script type="text/javascript">
	$(function() {
		$("#dataArquivo").mask("99/99/9999");
	});
</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>