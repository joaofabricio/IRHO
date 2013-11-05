<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>


<form name="problemas" action="${ctx}/problemas/incluir" method="post" >
	<div id="titulo">PROBLEMAS</div>
	
	<div class="campo">
		<label for="descricao">Descreva o problema:</label>
		<textarea name="descricao" id="descricao" style="width: 250px" autofocus="autofocus">${obj.descricao}</textarea>
	</div>
	<br />
	<br />
	<br />
       
    <div class="botoes">
		<input type="submit" value="Informar problema" />
	</div>
</form>

<table>
	<tr><th>Descrição</th><th style="text-align: center;">ok?</th></tr>
	<c:forEach var="o" items="${result}">
		<tr>
			<td>
				${o.terminado?'':'<span style="color: #FF0000">'}
				${o.descricao}
				${o.terminado?'':'</span>'}
			</td>
			<td style="text-align: center; text-decoration: none;">
				<a href="${ctx}/problemas/mudaStatus?id=${o.id}">
					${o.terminado?'yes':'NOK'}
				</a>
			</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
