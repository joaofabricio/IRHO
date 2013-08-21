<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div>
	<div id="titulo">DADOS DO USUÁRIO</div>

	<div class="campo">
		<label for="nome">Nome:</label>
		<div>
			<c:out value="${usuario.nome}" />
		</div>
	</div>
	<br />
        <div class="campo">
		<label for="login">Login:</label>
		<div>
			<c:out value="${usuario.login}" />
		</div>
	</div>
	<br />
	<div class="campo">
		<label for="email">E-mail:</label>
		<div>
			<c:out value="${usuario.email.emailAddress}" />
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>