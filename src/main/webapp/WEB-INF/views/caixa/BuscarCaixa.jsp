<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/caixa/buscar" method="post">

	<div id="titulo">Busca por Caixa</div>

	<div class="campo">
		<label for="descricao"> Descrição:</label>
		<input type="text" name="descricao" size="30" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Buscar"/>
	</div>

</form>



<%@ include file="/WEB-INF/views/includes/footer.jsp"%>