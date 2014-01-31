<%-- <form action="${ctx}/validade/cadastrarPopup" method="get"> --%>

	<div id="titulo">Cadastro de Validade</div>

	<div class="campo">
		<span class="legendaCampo" style="position: relative">
			Digite uma descrição para identificar a validade
		</span>
		<br />
		<label for="descricao">Descrição*:</label>
		<input type="text" id="descricaoValidade" name="descricao" size="25" value="${validade.descricao}"
			   style="${erro!=null? 'border-color: red;' : ''}" />
	</div>
	
	<br />
	
	<div class="campo">
		<span class="legendaCampo" style="position: relative">
			Digite um número para especificar o prazo de validade em anos
		</span>
		<br />
		<label for="prazo">Prazo (em anos)*:</label>
		<input type="number" id="prazoEmAnosValidade" name="prazoEmAnos" value="${validade.prazoEmAnos}"
			   style="${erro!=null? 'border-color: red;' : ''}" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Gravar" onclick="gravarValidade()" />
	</div>

<!-- </form> -->
