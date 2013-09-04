<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/validade/cadastrarValid" method="post">

	<div id="titulo">Cadastro de Validade</div>

	<div class="campo">
		<label for="descricao">Insira a Validade:</label>
		<input type="text" name="descricao" size="30" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Cadastrar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>