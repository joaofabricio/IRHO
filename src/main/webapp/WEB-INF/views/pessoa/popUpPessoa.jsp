<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<div id="titulo">Selecione uma pessoa</div>
<label>pesquisar por nome: </label>
<input type="text" autofocus="autofocus" id="filtroNomePessoa" value="${nome}" />
<button onclick="showPopup('${ctx}/pessoa/popup?nome='+document.getElementById('filtroNomePessoa').value);">ok</button>
<table id="results">
	<tr>
		<th><a href="javascript: ordenar('id')">id</a></th>
		<th><a href="javascript: ordenar('nome')">nome</a></th>
	</tr>
	<c:forEach var="o" items="${result}">
		<tr onclick="selecionarPessoa(${o.id},'${o.nome}'); closePopup();">
			<td>${o.id}</td>
			<td>
				<a href="javascript: selecionarPessoa(${o.id},'${o.nome}'); closePopup();">
			 		${o.nome}
			 	</a>
			</td>
		</tr>
	</c:forEach>
</table>
