
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/arquivo/buscarSubmit" method="post">

	<div id="titulo">Busca por Arquivo</div>

	<div class="campo">
		<label for="pessoa">Pessoa:</label>
		<input type="text" name="pessoa" size="30" />
	</div>
	<br />


	<div class="campo">
		<label for="assunto">Assunto:</label>
		<input type="text" name="assunto" size="30" />
	</div>
	<br />


	<div class="campo">
		<label for="tipo">Tipo:</label>
		<select name="tipo">
			<option value="-1">NENHUM</option>
			<c:forEach var="o" items="${tipos}">
				<option value="${o.id}">${o.descricao}</option>
			</c:forEach>
		</select>
	</div>
	<br />
	
	<div class="campo">
		<label for="caixa"> Caixa:</label>
		<select name="caixa">
			<option value="-1">NENHUMA</option>
			<c:forEach var="o" items="${caixas}">
				<option value="${o.id}">${o.descricao}</option>
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

<script type="text/javascript">
	$(function() {
		$("#dataArquivoInicio").mask("99/99/9999");
		$("#dataArquivoFim").mask("99/99/9999");
	});
</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
