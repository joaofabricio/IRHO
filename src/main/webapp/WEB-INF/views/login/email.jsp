<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form name="problemas" action="${ctx}/email" method="post" >
	<div id="titulo">O e-mail cadastrado é inválido. Por favor, digite seu e-mail</div>
	
	<div class="campo">
		<label for="nome">Usuário:</label>
		<input type="text" name="nome" id="nome" value="${nome}" readonly="readonly" style="border: none;" />
	</div>
	<br />
	
	<div class="campo">
		<label for="email">E-mail:</label>
		<input type="email" name="email" id="email" value="${email}" autofocus="autofocus" />
	</div>
	<br />
	
	<div class="botoes">
		<input type="submit" />
	</div>
</form>


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>