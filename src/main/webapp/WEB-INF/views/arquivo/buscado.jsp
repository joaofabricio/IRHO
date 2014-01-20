<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<form action="${ctx}/arquivo/buscarSubmit" method="post">

	<div id="titulo">Busca por Arquivo</div>

	<div class="campo">
		<label for="pessoa">Pessoa:</label>
		<input type="text" name="pessoa" value="${pessoa}" size="30" />
	</div>
	<br />


	<div class="campo">
		<label for="assunto">Assunto:</label>
		<input type="text" name="assunto" size="30" value="${assunto}" />
	</div>
	<br />


	<div class="campo">
		<label for="tipo">Tipo:</label>
		<select name="tipo">
			<option value="">NENHUM</option>
			<c:forEach var="o" items="${tipos}">
				<option value="${o.id}" ${tipo!=null && tipo==o.id?'selected="selected"':'' }>${o.descricao}</option>
			</c:forEach>
		</select>
	</div>
	<br />
	
	<div class="campo">
		<label for="caixa"> Caixa:</label>
		<select name="caixa">
			<option value="">NENHUMA</option>
			<c:forEach var="o" items="${caixas}">
				<option value="${o.id}" ${caixa!=null && caixa==o.id?'selected="selected"':'' }>${o.descricao}</option>
			</c:forEach>
		</select>
	</div>
	<br />
	
	<div class="campo">
		<label for="dataArquivoInicio">Entre:</label>
		
		<input type="text" name="dataArquivoInicio" id="dataArquivoInicio" size="10" value="${dataArquivoInicio}" />
		<br />
		<label for="dataArquivoFim">e</label>
		<input type="text" name="dataArquivoFim" id="dataArquivoFim" size="10" value="${dataArquivoFim}" />
	</div>


	<br />

	<div class="botoes">
		<input type="submit" value="Buscar" />
	</div>

</form>

	<div id="titulo">Busca de arquivo Realizada!</div>

	<table>
		<tr>
			<th>Data</th>
			<th>Assunto</th>
			<th>Pessoa</th>
			<th>Tipo</th>
			<th>Caixa</th>
			<th>editar</th>
			<th>excluir</th>
		</tr>
		<c:forEach var="o" items="${arquivos}">
			<tr>
				<td>${o.dataArquivo}</td>
				<td>${o.assunto}</td>
				<td>${o.pessoa.nome}</td>
				<td>${o.tipo.descricao}</td>
				<td>${o.caixa.descricao}</td>
				<td style="text-align: center;">
					<a href="${ctx}/arquivo/editar?id=${o.id}">
						<img src="${ctx}/images/edit.png" width="16" height="16" alt="editar" title="editar" />
					</a>
				</td>
				<td style="text-align: center;">
					<a href="javascript: showPopup('${ctx}/arquivo/excluir?id=${o.id}&ctx=${ctx}')">
						<img src="${ctx}/images/delete.png" width="16" height="16" alt="delete" title="excluir" />
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
 <br />
<!-- 	<div class="botoes"> -->
<%-- 		<button onclick="location.href='${ctx}/arquivo/buscar'"> Realizar nova busca</button> --%>
<!-- 	</div> -->
<script type="text/javascript">
	$(function() {
		$("#dataArquivoInicio").mask("99/99/9999");
		$("#dataArquivoFim").mask("99/99/9999");
	});
</script>
	
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
