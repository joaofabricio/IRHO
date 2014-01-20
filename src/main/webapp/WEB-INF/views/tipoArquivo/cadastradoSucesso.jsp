<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>


	<div id="titulo">Descrição Realizada!</div>
	<div class="botoes">
		O tipo de arquivo com a descrição: <br/> <i><b> ${descricao} </b></i> <br/>
		foi cadastrado/alterado com sucesso!
	
	</div> <br />
	<div class="botoes">
		<button onclick="location.href='${ctx}/tipoArquivo/cadastro'"> Realizar novo cadastro de tipo de arquivo</button>
		<br />
		<button onclick="location.href='${ctx}/tipo/buscar'"> Buscar Tipo de Arquivo</button>
	</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>