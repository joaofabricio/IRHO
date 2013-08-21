<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>


<form name="problemas" action="${ctx}/incluir" method="post" >
	<div id="titulo">PROBLEMAS NO LABORATÓRIO</div>
	
	<div class="campo">
		<label for="nomeMaquina">Usuário:</label>
		<input type="text" name="usuario" id="usuario" style="border: none;" readonly="readonly" value="${usuario.nome}" />
	</div>
	<br />
	<div class="campo">
		<span class="legendaCampo">
				identifique o nome da máquina pela etiqueta na parte superior do gabinete
		</span>
		<br />
		<label for="idMaquina">Máquina:</label>
		
		<select name="idMaquina">
			<option value="0">--SELECIONE--</option>
			<c:forEach var="maquina" items="${maquinas}">
				<option value="${maquina.id}" ${obj.maquina.id == maquina.id? 'selected="selected"': ''}>${maquina.nome}</option>
			</c:forEach>
		</select>
	</div>
	<br />
	
	<div class="campo">
		<span class="legendaCampo">
				descreva o problema de forma clara e sucinta
		</span>
		<br />
		<label for="descricao">Descrição:</label>
		<textarea name="descricao" id="descricao" style="width: 250px" autofocus="autofocus">${obj.descricao}</textarea>
	</div>
	
	<br />
	<br />
	<br />
	
	<div class="campo">
		<span class="legendaCampo">
				escolha um dos tipos de problema abaixo
		</span>
		<br />
		<label for="tipos">Tipo:</label>
		<select name="tipo">
			<option value="">--SELECIONE--</option>
			<c:forEach var="tipo" items="${tipos}">
				<option value="${tipo}" ${obj.tipo==tipo? 'selected="selected"':'' }>${tipo.descricao}</option>
			</c:forEach>
		</select>
	</div>
	<br />
	<br />
       
    <div class="botoes">
		<input type="submit" value="Informar problema" />
	</div>
</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
