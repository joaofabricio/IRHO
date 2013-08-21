<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div>
	<div id="titulo">Tem certeza que deseja excluir o Local com os dados a seguir?</div>
	<form method="POST" action="${ctx}/local/excluir" style="text-align: center;">
		<input type="hidden" name="id" value="${obj.id}" />
		<input type="submit" value="sim" />
		<input type="button" onclick="location.href='${ctx}/local/buscar'" value="não" />
	</form>

	<div class="campo">
		<label>Descrição: </label>
		<div>
			<c:out value="${obj.descricao}" />
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>