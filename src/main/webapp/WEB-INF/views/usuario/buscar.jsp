<%@page import="java.util.List"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div id="titulo">BUSCA POR USUÁRIO</div>
<script type="text/javascript">
	function ordem(campo) {
		document.forms[0].ordem.value = campo;
		document.forms[0].submit();
	}
</script>
<div>Filtro:
	<form action="${ctx}/${entidade}/buscar" method="post" name="formUsuario">
		<select name="filtro">
			<option value="nome">
				Nome
			</option>
			<option value="email">
				Email
			</option>
		</select>
		<input type="text" name="valorFiltro" id="valorFiltro" value="${valorFiltro}" autofocus="autofocus" />
		<input type="submit" value="OK" />
		<input type="hidden" name="ordem" value="nome" />
	</form>
</div>
                
<%-- <c:if test="${result != null && result.size() > 0}"> --%>
	<table>
		<tr>
			<th><a href="javascript: ordem('nome')">Nome</a></th>
            <th><a href="javascript: ordem('email')">Email</a></th>
            <th><a href="javascript: ordem('acesso')">Acesso</a></th>
			<th style="text-align: center;">detalhes</th>
			<th style="text-align: center;">editar</th>
		</tr>
		<c:forEach var="o" items="${result}">
			<tr>
				<td>${o.nome}</td>
				<td>${o.email.emailAddress}</td>
				<td>${o.acesso}</td>
				<td style="text-align: center;">
					<a href="${ctx}/admin/usuario/visualizar?id=${o.id}">
						<img src="${ctx}/images/view.png" width="16" height="16" alt="detalhes" title="detalhes" />
					</a>
				</td>
				<td style="text-align: center;">
					<a href="${ctx}/admin/usuario/alterar?id=${o.id}">
						<img src="${ctx}/images/edit.png" width="16" height="16" alt="editar" title="editar" />
					</a>
				</td>
<!-- 				<td style="text-align: center;"> -->
<%-- 					<a href="${ctx}/${entidade}/excluir?id=${o.id}"> --%>
<%-- 						<img src="${ctx}/images/delete.png" width="16" height="16" alt="excluir" title="excluir" /> --%>
<!-- 					</a> -->
<!-- 				</td> -->
			</tr>
		</c:forEach>
	</table>
<%-- </c:if> --%>
<%-- <c:if test="${result == null || result.size() <= 0}"> --%>
<!-- 	<p align="center"> -->
<!-- 		Sem resultados -->
<!-- 	</p> -->
<%-- </c:if> --%>
<button onclick="location.href='${ctx}/${entidade}/cadastrar'">Incluir novo</button>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>