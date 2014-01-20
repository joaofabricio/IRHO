<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>


<div id="titulo">Cadastrado com sucesso!</div>
<div class="botoes">
	A Validade: <b> ${Descrition} </b> 
	foi cadastrada com sucesso!

</div> <br />
<div class="botoes">
	<button onclick="location.href='${ctx}/validade/cadastroValidade'"> Realizar novo cadastro</button>
</div>


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>