<%@page import="br.edu.utfpr.cm.irho.model.Arquivo"%>
<%@page import="br.edu.utfpr.cm.libutfcm.util.DateUtil"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<script type="text/javascript">
	function selecionarPessoa(id, nome) {
		document.getElementById("pessoaId").value = id;
		document.getElementById("pessoaNome").value=nome;
	}
</script>

<form action="${ctx}/arquivo/cadastroSubmit" method="post">

	<div id="titulo"> Cadastro de Arquivos</div>
	<br/>
	<div class="campo">
		<label for="nome">Pessoa:</label>
		
<!-- 		<select name="idPessoa" style="max-width: 250px"> -->
		<input type="hidden" name="pessoa" value="${arquivo.pessoa.id}" id="pessoaId" />
		<input type="text" value="${arquivo.pessoa.nome}" id="pessoaNome" size="30" readonly="readonly" />
			<!--  <option value="-1">Selecione a pessoa</option>
     		<c:forEach var="o" items="${pessoas}">
				<option value="${o.id}" ${(arquivo != null && arquivo.pessoa.id == o.id)? 'selected=="selected"':''} id="pessoa${o.id}" >${o.nome}</option>
			</c:forEach> -->
<!-- 		</select>   -->
		<br />
		<br/>
		<input onclick="showPopup('${ctx}/pessoa/popup');" value="Selecionar pessoa..." readonly="readonly" />
	</div>
	
	
	
	<br/>
	<div class="campo">
		<label for="area">�rea:</label>
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
		<label for="descricao"> Caixa:</label>
		
		<select name="idCaixa" style="max-width: 250px">
		<option value="-1">Selecione a caixa</option>
			<c:forEach var="o" items="${caixas}">
				<option value="${o.id}" ${(arquivo != null && arquivo.caixa.id == o.id)? 'selected=="selected"':''}>${o.descricao}</option>
			</c:forEach>
		</select>
	</div>
	<br/>
	<div class="campo">
		<label for="dataArquivo"> Data*:</label>
		<input type="text" name="dataArquivo" id="dataArquivo" value="${arquivo!=null?arquivo.getDataArquivoFormatada():'' }" size="10"/>
	</div>
	
	<br />
	
	<div class="campo">
		<label for="observacao"> Observa��o:</label>
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