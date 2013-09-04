<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>


	<div id="titulo">Descrição Realizada!</div>
	<div class="botoes">
		O tipo de arquivo com a descrição: <br/> <i><b> ${descricao} </b></i> <br/>
		foi cadastrada com sucesso!
	
	</div> <br />
	<div class="botoes">
		<button onclick="location.href='${ctx}/tipoArquivo/cadastro'"> Realizar novo cadastro de tipo de arquivo</button>
	</div>
	
	
	


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>