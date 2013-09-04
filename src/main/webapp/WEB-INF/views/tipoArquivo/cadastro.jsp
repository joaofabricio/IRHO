<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/tipoArquivo/cadastro" method="post">

	<div id="titulo">Cadastro de tipo de arquivo</div>

	<div class="campo">
		<label for="descricao">Descrição:</label>
		<input type="text" name="descricao" size="30" />
	</div>	
	<br/>
	
	<div class="campo">
		<label for="descricao">Validade:</label>
		
		<select name="validade">
			<c:forEach var="o" items="${result}">
				<option value="${o.id}">${o.descricao}</option>
			</c:forEach>
		</select>
	</div>
  
		
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Cadastro"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>