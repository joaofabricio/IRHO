<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<script type="text/javascript">
	function ordenar(campo) {
		var hid = document.getElementById('ordem');
		hid.value = campo;
		document.forms[0].submit();
	}
</script>

<form action="${ctx}/tipo/buscar" method="post">

	<div id="titulo">Busca realizada!</div>

	<div class="campo">
		<label for="descricao"> Descrição:</label>
		<input type="text" name="descricao" size="30" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Buscar"/>
	</div>

</form>

	<table>
		<tr>
			<th><a href="javascript: ordenar('id')">Id</a></th>
			<th><a href="javascript: ordenar('descricao')">Descrição</a></th>
			<th><a href="javascript: ordenar('validade.descricao')">Validade</a></th>
			<th style="text-align: center;">editar</th>
			<th style="text-align: center;">excluir</th>
		</tr>
		<c:forEach var="o" items="${result}">
			<tr>
				<td>${o.id}</td>
				<td>${o.descricao}</td>
				<td>${o.validade.descricao}</td>
				<td style="text-align: center;">
					<a href="${ctx}/tipo/editarTipo?id=${o.id}">
						<img src="${ctx}/images/edit.png" width="16" height="16" alt="editar" title="editar" />
					</a>
				</td>
				<td style="text-align: center;">
					<a href="javascript: showPopup('${ctx}/tipo/excluir?id=${o.id}&ctx=${ctx}')">
						<img src="${ctx}/images/delete.png" width="16" height="16" alt="delete" title="excluir" />
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
 <br />
<!-- 	<div class="botoes"> -->
<%-- 		<button onclick="location.href='${ctx}/caixa/BuscarCaixa'"> Realizar nova busca</button> --%>
<!-- 	</div> -->
	
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
