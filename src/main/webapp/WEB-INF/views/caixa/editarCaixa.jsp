<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/caixa/editado" method="post">

	<div id="titulo">Editar a Caixa: <i> ${caixa.descricao} </i></div>

	<input type="hidden" value="${caixa.id}" name="id" />
	<div class="campo">
		<span class="legendaCampo">
			Digite uma descrição para identificar a caixa
		</span>
		<br />
		<label for="descricao">Descrição*:</label>
		<input type="text" name="descricao" size="30" value="${caixa.descricao}"
			   style="${erro!=null? 'border-color: red;' : ''}" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Gravar"/>
	</div>
</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>