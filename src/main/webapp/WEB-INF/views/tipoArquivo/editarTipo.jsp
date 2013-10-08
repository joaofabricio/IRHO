<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/tipo/editado" method="post">

	<div id="titulo">Editar a Caixa: <i> ${tipo.descricao} </i></div>

	<input type="hidden" value="${tipo.id}" name="id" />
	<div class="campo">
		<label for="nome">Nova descricao da caixa:</label>
		<input type="text" name="descricao" size="30" value="${tipo.descricao}" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Cadastrar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>