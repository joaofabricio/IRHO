<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/pessoa/buscar" method="post">

	<div id="titulo">Busca por Pessoa</div>

	<div class="campo">
		<label for="nome"> Nome:</label>
		<input type="text" name="nome" size="30" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Buscar"/>
	</div>

</form>



<%@ include file="/WEB-INF/views/includes/footerimg.jsp"%>