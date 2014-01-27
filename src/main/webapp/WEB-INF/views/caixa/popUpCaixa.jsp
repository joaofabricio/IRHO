<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<div id="titulo">Selecione uma caixa</div>
<table>
	<tr>
		<th><a href="javascript: ordenar('id')">Id</a></th>
		<th><a href="javascript: ordenar('descricao')">Descrição</a></th>
	</tr>
	<c:forEach var="o" items="${result}">
		<tr onclick="selecionarCaixa(${o.id},'${o.descricao}'); closePopup();">
			<td>${o.id}</td>
			<td>
				<a href="javascript: selecionarCaixa(${o.id},'${o.descricao}'); closePopup();">
			 		${o.descricao}
			 	</a>
			</td>
		</tr>
	</c:forEach>
</table>