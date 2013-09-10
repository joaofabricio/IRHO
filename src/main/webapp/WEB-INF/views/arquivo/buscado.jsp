<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

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
