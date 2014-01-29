<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div id="homeContent">
	<div id="titulo">${saudacao}</div>
	<br/> <br/>
	<div style="width: 100%; text-align: center " >
	<img src="${ctx}/images/iRHo.png" width="40%" height="40%" /> 
	<br/> <br/><br/> <br/><br/> <br/>
   	</div>
   	
   	<div>
   	<fieldset>
   		<legend>Arquivo</legend>
   		<button onclick="location.href='${ctx}/arquivo/cadastroArquivo'">Cadastrar</button>
   		<button onclick="location.href='${ctx}/arquivo/buscar'">Buscar</button>
   	</fieldset>

   	<fieldset>
   		<legend>Pessoa</legend>
   		<button onclick="location.href='${ctx}/pessoa/cadastro'">Cadastrar</button>
   		<button onclick="location.href='${ctx}/pessoa/buscar'">Buscar</button>
   	</fieldset>

   	<fieldset>
   		<legend>Caixa</legend>
   		<button onclick="location.href='${ctx}/caixa/cadastro'">Cadastrar</button>
   		<button onclick="location.href='${ctx}/caixa/buscar'">Buscar</button>
   	</fieldset>
    </div>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>