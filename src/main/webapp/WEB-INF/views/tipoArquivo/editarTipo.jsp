<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<script type="text/javascript">
		
	function changeValidade(select) {
		var validades = [
		     			<c:forEach var="validade" items="${validades}">
		     	                  ["${validade.id}",
		     	                  "${validade.prazoEmAnos}"],
		     	        </c:forEach>
		     	              ];

		for (var i=0; i<validades.length; i++) {
			if (validades[i][0] == select.value) {
				document.getElementById('prazoEmAnos').value = +validades[i][1]+" ano(s)";
				return;
			}
		}
		
	}
</script>
<form action="${ctx}/tipo/editado" method="post">

	<div id="titulo">Editar o Tipo: <i> ${tipo.descricao} </i></div>

	<input type="hidden" value="${tipo.id}" name="id" />
	<div class="campo">
		<span class="legendaCampo">
			Digite uma descrição para o tipo
		</span>
		<br />
		<label for="nome">Nova descrição do tipo*:</label>
		<input type="text" name="descricao" size="30" value="${tipo.descricao}" />
	</div>
	
	<br />
	
	<div class="campo">
		<span class="legendaCampo">
			Selecione uma validade ou 
			<a href="javascript: showPopup('${ctx}/validade/cadastroPopup')">
				clique aqui para inserir uma
			</a>
		</span>
		<br />
		<label for="descricao">Validade*:</label>
		
		<select name="validadeId"
			    style="${erro!=null? 'border-color: red;' : ''}"
			    onchange="changeValidade(this)">
			<c:forEach var="o" items="${validades}">
				<option value="${o.id}" ${o.id==tipo.validade.id? 'selected="selected"':''}>${o.descricao}</option>
			</c:forEach>
		</select>
		<br />
		<input value="${(tipo != null && tipo.validade != null)? tipo.validade.prazoEmAnos:''} ano(s)"
			   id="prazoEmAnos"
			   readonly="readonly"
			   style="border: none" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Alterar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>