<%@page import="br.edu.utfpr.cm.irho.model.Arquivo"%>
<%@page import="br.edu.utfpr.cm.libutfcm.util.DateUtil"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form>

	<div id="titulo">Editando Arquivo</div>
	
	<input type="hidden" name="id" value="${arquivo.id}" id="id" />
	<br/>
	<div class="campo">
		<label for="nome">Pessoa:</label>
		
		<input type="text" class="input_view" readonly="readonly" value="${arquivo.pessoa.nome}" />
	</div>
	
	<br/>
	<div class="campo">
		<label for="area">Área:</label>
		<input type="text" class="input_view" readonly="readonly" value="${arquivo.area}" />
	</div>	
	<br/>
	<div class="campo">
		<label for="assunto">Assunto*:</label>
		<input type="text" class="input_view" readonly="readonly" value="${arquivo.assunto}" />
	</div>
	
	<br/>
	
	<div class="campo">
		<label for="descricao">Tipo*:</label>
		
		<input type="text" class="input_view" readonly="readonly" value="${arquivo.tipo!=null? arquivo.tipo.descricao:'[nenhum]'}" />
	</div>
	
	<br/>
	
	<div class="campo">
		<label for="descricao"> Caixa:</label>
		
		<input type="text" class="input_view" readonly="readonly" value="${arquivo.caixa!=null? arquivo.caixa.descricao:'[nenhum]'}" />
	</div>
	<br/>
	<div class="campo">
		<label for="dataArquivo"> Data*:</label>
		<input type="text" class="input_view" readonly="readonly" value="${arquivo.getDataArquivoFormatada()}" />
	</div>
	
	<br />
	
	<div class="campo">
		<label for="observacao"> Observação:</label>
		<input type="text" class="input_view" readonly="readonly" value="${arquivo.observacao}" />
	</div>
	
	<br />
	<br />
	<br />
	
	<div class="botoes">
		<input type="button" value="voltar" onclick="history.go(-1)"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>