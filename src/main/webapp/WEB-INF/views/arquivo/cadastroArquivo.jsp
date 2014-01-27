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

<form action="${ctx}/arquivo/cadastroSubmit" method="post">

	<div id="titulo"> Cadastro de Arquivos</div>
	<br/>
	<div class="campo">
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
	
	<br/>
	<div class="campo">
		<label for="area">Área:</label>
		<input type="text" name="area" value="${arquivo.area}" size="30" />
	</div>	
	<br/>
	<div class="campo">
		<label for="assunto">Assunto*:</label>
		<input type="text" name="assunto" value="${arquivo.assunto}" size="30" />
	</div>
	
	<br/>
	
	<div class="campo">
		<label for="descricao">Tipo*:</label>
		
		<select name="idTipo" style="max-width: 250px">
		<option value="-1">Selecione o Tipo</option>
			<c:forEach var="o" items="${tipos}">
				<option value="${o.id}" ${(arquivo != null && arquivo.tipo.id == o.id)? 'selected=="selected"':''}>${o.descricao}</option>
			</c:forEach>
		</select>
	</div>
	
	<br/>
	
	<div class="campo">
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
		<input type="button" style="left: 52%"
			   onclick="selecionarCaixa(-1, '[nenhuma]');"
			   value="remover" />
	</div>
	<br/>
	<div class="campo">
		<label for="dataArquivo"> Data*:</label>
		<input type="text" name="dataArquivo" id="dataArquivo" value="${arquivo!=null?arquivo.getDataArquivoFormatada():'' }" size="10"/>
	</div>
	
	<br />
	
	<div class="campo">
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