<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div id="homeContent">
	<div id="titulo"><h2>Bem-vindo(a) ao i<b>RH</b>o </h2></div>
	
<%--    	<img src="${ctx}/images/iRHo.png" /> --%>
   	
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

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>