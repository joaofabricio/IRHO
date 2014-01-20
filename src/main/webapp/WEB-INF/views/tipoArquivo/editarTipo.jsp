<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/tipo/editado" method="post">

	<div id="titulo">Editar o Tipo: <i> ${tipo.descricao} </i></div>

	<input type="hidden" value="${tipo.id}" name="id" />
	<div class="campo">
		<label for="nome">Nova descrição do tipo*:</label>
		<input type="text" name="descricao" size="30" value="${tipo.descricao}" />
	</div>
	
	<br />
	
	<div class="campo">
		<label for="descricao">Validade*:</label>
		
		<select name="validadeId">
			<c:forEach var="o" items="${validades}">
				<option value="${o.id}" ${o.id==tipo.validade.id? 'selected="selected"':''}>${o.descricao}</option>
			</c:forEach>
		</select>
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Alterar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>