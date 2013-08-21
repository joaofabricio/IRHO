<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div>
	<div id="titulo">O PROBLEMA FOI RELATADO COM SUCESSO</div>

	<div class="botoes">
		<c:out value="Em breve enviaremos uma resposta para ${usuario.email.emailAddress}" />
	</div>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>