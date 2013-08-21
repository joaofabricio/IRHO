<%@page import="java.util.List"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div id="titulo">PROBLEMAS NO LABORATÓRIO B001</div>
<script type="text/javascript">
	function ordem(campo) {
		document.forms[0].ordem.value = campo;
		document.forms[0].submit();
	}
	function mudaFiltro(filtro) {
		if (filtro.value == 'descricao') {
			document.getElementById('valorFiltro').innerHTML = '<input type="text" name="descricao" />';
		}
		if (filtro.value == 'tipo') {
			abrirPag('${ctx}/problemas/tipos', 'valorFiltro');
		}
		if (filtro.value == 'status') {
			abrirPag('${ctx}/problemas/status', 'valorFiltro');
		}
	}
</script>
<div>Filtro:
	<form action="${ctx}/admin/problemas" method="post">
		<select name="filtro" onchange="mudaFiltro(this)">
			<option value="descricao">
				Descrição
			</option>
			<option value="tipo">
				Tipo
			</option>
			<option value="status">
				Status
			</option>
		</select>
		<span id="valorFiltro">
			<input type="text" name="descricao" />
		</span>
		<input type="submit" value="OK" />
		<input type="hidden" name="ordem" value="status" />
	</form>
</div>
                
<%-- <c:if test="${result != null && result.size() > 0}"> --%>
	<table>
		<tr>
			<th><a href="javascript: ordem('dataHora')">Data/Hora</a></th>
			<th><a href="javascript: ordem('descricao')">Descrição</a></th>
			<th><a href="javascript: ordem('tipo')">Tipo</a></th>
			<th><a href="javascript: ordem('maquina.nome')">Máquina</a></th>
			<th><a href="javascript: ordem('status')">Status</a></th>
			<th><a href="javascript: ordem('usuario.nome')">Usuário</a></th>
			<th style="text-align: center;">detalhes</th>
			<th style="text-align: center;">editar</th>
			<th style="text-align: center;">excluir</th>
		</tr>
		<c:forEach var="o" items="${result}">
			<tr>
				<td>${o.dataHora}</td>
				<td>${o.descricao}</td>
				<td>${o.tipo}</td>
				<td>${o.maquina.nome}</td>
				<td>${o.status}</td>
				<td><a href="${ctx}/admin/usuario/visualizar?id=${o.usuario.id}">${o.usuario.nome}</a></td>
				<td style="text-align: center;">
					<a href="${ctx}/${entidade}/visualizar?id=${o.id}">
						<img src="${ctx}/images/view.png" width="16" height="16" alt="detalhes" title="detalhes" />
					</a>
				</td>
				<td style="text-align: center;">
					<a href="${ctx}/${entidade}/alterar?id=${o.id}">
						<img src="${ctx}/images/edit.png" width="16" height="16" alt="editar" title="editar" />
					</a>
				</td>
				<td style="text-align: center;">
					<a href="${ctx}/${entidade}/excluir?id=${o.id}">
						<img src="${ctx}/images/delete.png" width="16" height="16" alt="excluir" title="excluir" />
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
<%-- </c:if> --%>
<%-- <c:if test="${result == null || result.size() <= 0}"> --%>
<!-- 	<p align="center"> -->
<!-- 		Sem resultados -->
<!-- 	</p> -->
<%-- </c:if> --%>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>