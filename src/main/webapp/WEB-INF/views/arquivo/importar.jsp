<%@page import="br.edu.utfpr.cm.irho.model.Arquivo"%>
<%@page import="br.edu.utfpr.cm.libutfcm.util.DateUtil"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/importar/post" method="post">

	<div id="titulo">Importação de Arquivos</div>
	<br/>
	
	<div class="campo">
		<span class="legendaCampo">
			Insira no formato de importação
		</span>
		<br />
		
		<label for="conteudoArquivo">Conteúdo:</label>
		<textarea name="conteudoArquivo">${arquivo.observacao}</textarea>
	</div>
	
	<br />
	<br />
	<br />
	
	<div class="botoes">
		<input type="submit" value="Enviar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>