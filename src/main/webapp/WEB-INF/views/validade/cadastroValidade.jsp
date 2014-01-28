<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/validade/cadastrarValid" method="post">

	<div id="titulo">Cadastro de Validade</div>

	<div class="campo">
		<label for="descricao">Descri��o*:</label>
		<input type="text" name="descricao" size="30" value="${validade.descricao}"
			   style="${erro!=null? 'border-color: red;' : ''}" />
	</div>
	
	<br />
	
	<div class="campo">
		<label for="prazo">Prazo (em anos)*:</label>
		<input type="number" name="prazoEmAnos" value="${validade.prazoEmAnos}"
			   style="${erro!=null? 'border-color: red;' : ''}" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Cadastrar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>