<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<script type="text/javascript">
		
	function changeValidade(select) {
		var validades = [
		     			<c:forEach var="validade" items="${result}">
		     	                  ["${validade.id}",
		     	                  "${validade.prazoEmAnos}"],
		     	        </c:forEach>
		     	              ];

		for (var i=0; i<validades.length; i++) {
			if (validades[i][0] == select.value) {
				document.getElementById('prazoEmAnos').value = ""+validades[i][1]+" ano(s)";
				return;
			}
		}
		
	}
		
	function gravarValidade() {
		var descricao = document.getElementById('descricaoValidade').value;
		var prazoEmAnos = document.getElementById('prazoEmAnosValidade').value;
		
		showPopup('${ctx}/validade/cadastroPopupSubmit?prazoEmAnos='+prazoEmAnos+'&descricao='+descricao);
	}
	
	function selecionarValidade(id, descricao) {
		var select = document.getElementById('validadeId');
		select.value = id;
		changeValidade(select);
		document.forms[0].submit();
	}
</script>
<form action="${ctx}/tipoArquivo/cadastro" method="post">

	<div id="titulo">Cadastro de tipo de arquivo</div>

	<div class="campo">
		<span class="legendaCampo">
			Digite uma descrição para o tipo
		</span>
		<br />
		<label for="descricao">Descrição*:</label>
		<input type="text" name="descricao" size="30" value="${tipo.descricao}"
			   style="${erro!=null? 'border-color: red;' : ''}"/>
	</div>	
	<br/>
	
	<div class="campo">
		<span class="legendaCampo">
			Selecione uma validade ou 
			<a href="javascript: showPopup('${ctx}/validade/cadastroPopup')">
				clique aqui para inserir uma
			</a>
		</span>
		<br />
		<label for="descricao">Validade*:</label>
		
		<select name="validadeId" id="validadeId"
			    style="${erro!=null? 'border-color: red;' : ''}"
			    onchange="changeValidade(this)">
			<option value="-1">--SELECIONE--</option>
			<c:forEach var="o" items="${result}">
				<option value="${o.id}" ${(tipo != null && tipo.validade.id == o.id)? 'selected=="selected"':''}>${o.descricao}</option>
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
		<input type="submit" value="Gravar"/>
	</div>

</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>