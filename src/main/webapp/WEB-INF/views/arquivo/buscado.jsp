<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<form action="${ctx}/arquivo/buscarSubmit" method="post">

	<div id="titulo">Busca por Arquivo</div>

	<div class="campo">
		<label for="pessoa">Pessoa:</label>
		<input type="text" name="pessoa" value="${pessoa}" size="30" />
	</div>
	<br />


	<div class="campo">
		<label for="assunto">Assunto:</label>
		<input type="text" name="assunto" size="30" value="${assunto}" />
	</div>
	<br />


	<div class="campo">
		<label for="tipo">Tipo:</label>
		<select name="tipo">
			<option value="">NENHUM</option>
			<c:forEach var="o" items="${tipos}">
				<option value="${o.id}" ${tipo!=null && tipo==o.id?'selected="selected"':'' }>${o.descricao}</option>
			</c:forEach>
		</select>
	</div>
	<br />
	
	<div class="campo">
		<label for="caixa"> Caixa:</label>
		<select name="caixa">
			<option value="">NENHUMA</option>
			<c:forEach var="o" items="${caixas}">
				<option value="${o.id}" ${caixa!=null && caixa==o.id?'selected="selected"':'' }>${o.descricao}</option>
			</c:forEach>
		</select>
	</div>
	<br />
	
	<div class="campo">
		<label for="dataArquivo"> Data:</label>
		<input type="date" name="dataArquivo" value="${dataArquivo}" />
	</div>

	<br />

	<div class="botoes">
		<input type="submit" value="Buscar" />
	</div>

</form>

	<div id="titulo">Busca de arquivo Realizada!</div>

	<table>
		<tr>
			<th>Data</th>
			<th>Assunto</th>
			<th>Pessoa</th>
			<th>Tipo</th>
			<th>Caixa</th>
		</tr>
		<c:forEach var="o" items="${arquivos}">
			<tr>
				<td>${o.dataArquivo}</td>
				<td>${o.assunto}</td>
				<td>${o.pessoa.nome}</td>
				<td>${o.tipo.descricao}</td>
				<td>${o.caixa.descricao}</td>
			</tr>
		</c:forEach>
	</table>
 <br />
	<div class="botoes">
		<button onclick="location.href='${ctx}/arquivo/buscar'"> Realizar nova busca</button>
	</div>
	
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
