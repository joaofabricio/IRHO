<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/pessoa/cadastrar" method="post">

	<div id="titulo">Cadastro de Pessoas</div>

	<div class="campo">
		<label for="nome">Nome:</label>
		<input type="text" name="nome" size="30" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Cadastrar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>