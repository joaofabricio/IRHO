<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<script type="text/javascript">
	function ordenar(campo) {
		var hid = document.getElementById('ordem');
		hid.value = campo;
		document.forms[0].submit();
	}
</script>

<form action="" method="post">

	<div id="titulo">Busca Realizada!</div>

	<div class="campo">
		<label for="nome"> Descri��o:</label>
		<input type="text" name="descricao" size="30" value="${descricaoTipo}" />
	</div>
	
	<input type="hidden" value="${ordem==null?'nome':ordem}" name="ordem" id="ordem" />
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Nova busca"/>
	</div>
	

</form>

	<table>
		<tr>
			<th><a href="javascript: ordenar('id')">Id</a></th>
			<th><a href="javascript: ordenar('descricao')">Descri��o:</a></th>
			<th style="text-align: center;">editar</th>
		</tr>
		<c:forEach var="o" items="${result}">
			<tr>
				<td>${o.id}</td>
				<td>${o.descricao}</td>
				<td style="text-align: center;">
					<a href="${ctx}/tipo/editarTipo?id=${o.id}">
						<img src="${ctx}/images/edit.png" width="16" height="16" alt="editar" title="editar" />
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
 <br />
	<div class="botoes">
		<button onclick="location.href='${ctx}/caixa/BuscarCaixa'"> Realizar nova busca</button>
	</div>
	
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
