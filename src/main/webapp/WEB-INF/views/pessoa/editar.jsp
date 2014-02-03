<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/pessoa/cadastrar" method="post">

	<div id="titulo">Editar a pessoa: <i> ${pessoa.nome} </i></div>

	<input type="hidden" value="${pessoa.id}" name="id" />
	<div class="campo">
		<label for="nome">Novo nome:</label>
		<input type="text" name="nome" size="30" value="${pessoa.nome}" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Cadastrar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>