<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>


<form name="alteracao" action="${ctx}/usuario/alterar" method="post" >
	<c:if test="${usuario.id != null}">
		<div id="titulo">ALTERAÇÃO DE USUÁRIO </div>
		<input type="hidden" name="id" id="id" value="${usuario.id}" />
	</c:if>
	<c:if test="${usuario.id == null}">
		<div id="titulo">CADASTRO DE USUÁRIO </div>
	</c:if>

	<div class="campo">
		<label for="nome">Nome:</label>
		<input type="text" name="nome" id="nome" value="${usuario.nome}" autofocus="autofocus" />
	</div>
	
    <br />
    <div class="campo">
		<label for="login">Login:</label>
		<input type="text" name="login" id="login" value="${usuario.login}" />
	</div>
        
    <br />
    <div class="campo">
		<label for="senha">Senha:</label>
		<input type="password" name="senha" id="senha" value="${usuario.senha}" />
	</div>
    <br />
    <div class="campo">
		<label for="senha">Confirmação:</label>
		<input type="password" name="confirmacao" id="confirmacao" value="${usuario.senha}" />
	</div>
	
	<br />
        
	<div class="campo">
		<label for="email"> Email: </label>
                <input type="email" name= "email" id="email" value="${usuario.email}" /> <!--email--> 
	</div>
	<br />
       
        <div class="botoes">
		<input type="submit" />
	</div>
</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
