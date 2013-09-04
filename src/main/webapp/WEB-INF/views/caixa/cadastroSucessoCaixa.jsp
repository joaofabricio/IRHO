<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>


	<div id="titulo">Caixa Cadastrada com sucesso!</div>
	<div class="botoes">
		A Caixa <b> ${Descrition} </b> 
		foi cadastrada com sucesso!
	
	</div> <br />
	<div class="botoes">
		<button onclick="location.href='${ctx}/caixa/cadastroCaixa'"> Realizar novo cadastro</button>
	</div>
	
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	
	
	

