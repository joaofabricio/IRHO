<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/pessoa/cadastrar" method="post">

	<div id="titulo">Cadastro de Pessoas</div>

	<input type="hidden" value="${pessoa.id}" name="id" />
	<div class="campo">
		<span class="legendaCampo">
			Digite o nome da pessoa
		</span>
		<br />
		<label for="nome">Nome*:</label>
		<input type="text" name="nome" size="30" value="${pessoa.nome}"
			   style="${erro!=null? 'border-color: red;' : ''}" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Cadastrar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>