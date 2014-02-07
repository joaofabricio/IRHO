<%@page import="br.edu.utfpr.cm.irho.model.Arquivo"%>
<%@page import="br.edu.utfpr.cm.libutfcm.util.DateUtil"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form>

	<div id="titulo">Arquivo</div>
	
	<div class="campo">
		<label for="descricao">Tipo:</label>
		<textarea class="input_view" readonly="readonly">${arquivo.tipo.descricao}</textarea>
	</div>
	<br/>
	<div class="campo">
		<label for="dataArquivo"> Data:</label>
		<textarea class="input_view" readonly="readonly">${arquivo.dataArquivoFormatada}</textarea>
	</div>
	<br/>
	<div class="campo">
		<label for="assunto">Assunto:</label>
		<textarea class="input_view" readonly="readonly">${arquivo.assunto}</textarea>
	</div>
	<br />
	<div class="campo">
		<label for="area">Área:</label>
		<textarea class="input_view" readonly="readonly">${arquivo.area}</textarea>
	</div>	
	
	<br />
	<div class="campo">
		<label for="nome">Pessoa:</label>
		<textarea class="input_view" readonly="readonly">${arquivo.pessoa.nome}</textarea>
<%-- 		<input type="text" class="input_view" readonly="readonly" value="${arquivo.pessoa.nome}" /> --%>
	</div>
	<br />
	<br />
	
	<div class="campo">
		<label for="descricao"> Caixa:</label>
		<textarea class="input_view" readonly="readonly">${arquivo.caixa.descricao}</textarea>
	</div>
	<br/>
	<br />
	
	<div class="campo">
		<label for="observacao"> Observação:</label>
		<textarea class="input_view" readonly="readonly">${arquivo.observacao}</textarea>
	</div>
	
	<br />
	<br />
	<br />
	<br />
	<br />
	
	<div class="botoes">
		<input type="button" value="voltar" onclick="history.go(-1)"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>