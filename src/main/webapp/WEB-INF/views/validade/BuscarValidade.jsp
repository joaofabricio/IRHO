<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/validade/buscar" method="post">


	<div id="titulo">Busca por validade</div>


	<div class="campo">
		<label for="nome"> Validade:</label>
		<input type="text" name="descricao" size="30" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Buscar"/>
	</div>

</form>


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
