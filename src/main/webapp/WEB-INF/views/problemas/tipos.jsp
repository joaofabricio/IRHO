<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<select name="tipo">
	<c:forEach var="tipo" items="${tipos}">
		<option value="${tipo}">${tipo.descricao}</option>
	</c:forEach>
</select>