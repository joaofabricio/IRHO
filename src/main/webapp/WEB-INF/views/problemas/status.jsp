<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<select name="status">
	<c:forEach var="obj" items="${status}">
		<option value="${obj}">${obj.descricao}</option>
	</c:forEach>
</select>