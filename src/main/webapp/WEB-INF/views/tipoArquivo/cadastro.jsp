<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/tipoArquivo/cadastro" method="post">

	<div id="titulo">Cadastro de tipo de arquivo</div>

	<div class="campo">
		<span class="legendaCampo">
			Digite uma descrição para o tipo
		</span>
		<br />
		<label for="descricao">Descrição*:</label>
		<input type="text" name="descricao" size="30" value="${tipo.descricao}"
			   style="${erro!=null? 'border-color: red;' : ''}"/>
	</div>	
	<br/>
	
	<div class="campo">
		<label for="descricao">Validade*:</label>
		
		<select name="validadeId"
			    style="${erro!=null? 'border-color: red;' : ''}">
			<option value="-1">--SELECIONE--</option>
			<c:forEach var="o" items="${result}">
				<option value="${o.id}" ${(tipo != null && tipo.validade.id == o.id)? 'selected=="selected"':''}>${o.descricao}</option>
			</c:forEach>
		</select>
	</div>
  
		
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Cadastro"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>