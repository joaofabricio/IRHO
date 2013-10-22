<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<table>
	<tr>
		<th><a href="javascript: ordenar('id')">Id</a></th>
		<th><a href="javascript: ordenar('nome')">Nome</a></th>
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