<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/validade/editado" method="post">

	<div id="titulo">Editar a Validade: <i> ${validade.descricao} </i></div>

	<input type="hidden" value="${validade.id}" name="id" />
	<div class="campo">
		<label for="nome">Nova descricao da validade:</label>
		<input type="text" name="descricao" size="30" value="${validade.descricao}" />
	</div>
	
	<br />
	
	<div class="campo">
		<label for="prazo">Prazo (em anos)*:</label>
		<input type="number" name="prazoEmAnos" value="${validade.prazoEmAnos}" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Cadastrar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>