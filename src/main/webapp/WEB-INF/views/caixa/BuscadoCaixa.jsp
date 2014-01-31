<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<script type="text/javascript">
	function ordenar(campo) {
		var hid = document.getElementById('ordem');
		hid.value = campo;
		document.forms[0].submit();
	}
</script>

<form action="${ctx}/caixa/buscar" method="post">

	<div id="titulo">Busca Realizada!</div>

	<div class="campo">
		<label for="nome"> Descrição:</label>
		<input type="text" name="descricao" size="30" value="${descricaoCaixa}" />
	</div>
	
	<input type="hidden" value="${ordem==null?'descricao':ordem}" name="ordem" id="ordem" />
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Nova busca"/>
	</div>
	

</form>

	<table>
		<tr>
			<th><a href="javascript: ordenar('id')">Id</a></th>
			<th><a href="javascript: ordenar('descricao')">Descrição:</a></th>
			<th style="text-align: center;">editar</th>
			<th style="text-align: center;">Excluir</th>
		</tr>
		<c:forEach var="o" items="${result}">
			<tr>
				<td>${o.id}</td>
				<td>${o.descricao}</td>
				<td style="text-align: center;">
					<a href="${ctx}/caixa/editarCaixa?id=${o.id}">
						<img src="${ctx}/images/edit.png" width="16" height="16" alt="editar" title="editar" />
					</a>
				</td>
				<td style="text-align: center;">
					<a href="javascript: showPopup('${ctx}/caixa/excluir?id=${o.id}&ctx=${ctx}')">
						<img src="${ctx}/images/delete.png" width="16" height="16" alt="delete" title="excluir" />
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
