<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//pt-BR" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>IRHO - Índice de Arquivos físicos da UTFPRCM</title>
	
<!-- 	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" /> -->
	
	<link rel="shortcut icon" href="<c:url value='/images/icon.ico'/>" />

    <link rel="stylesheet" href="<c:url value='/css/blueprint/screen.css'/>" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="<c:url value='/css/blueprint/print.css'/>"  type="text/css" media="print">
    <link rel="stylesheet" href="<c:url value='/css/menu_style.css'/>"  type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/skin/css3-buttons-grey.css'/>" type="text/css" media="screen">
    <link rel="stylesheet" href="<c:url value='/css/css3-buttons.css'/>" type="text/css" media="screen">
    <!--[if lt IE 8]>
        <link rel="stylesheet" href="/css/blueprint/ie.css" type="text/css" media="screen, projection">
    <![endif]-->
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>"  type="text/css">

    <script src="<c:url value='/js/jquery.min.js'/>"></script>
<%--     <script src="<c:url value='/js/jquery.periodicalupdater.js'/>"></script> --%>
</head>
<body>
	<div id="conteudo">
		<!-- MENU -->
		<div id="navbar">
			<ul>
				<li>
					<a href="${ctx}/">INÍCIO</a>
				</li>
				<li>
					<a href="#">BUSCA</a>
					<ul>
						<li>
							<a href="${ctx}/arquivo/buscar">Arquivo</a>
						</li>
						<li>
							<a href="${ctx}/caixa/buscar">Caixa</a>
						</li>
						<li>
							<a href="${ctx}/pessoa/buscar">Pessoa</a>
						</li>
						<li>
							<a href="${ctx}/tipo/buscar">Tipo de Arquivo</a>
						</li>
						<li>
							<a href="${ctx}/validade/buscar">Validade</a>
						</li>

					</ul>
				</li>
				<li>
					<a href="#">CADASTRO</a>
					<ul>
						<li>
							<a href="${ctx}/arquivo/cadastroArquivo">Arquivo</a>
						</li>
						<li>
							<a href="${ctx}/caixa/cadastroCaixa">Caixa</a>
						</li>
						<li>
							<a href="${ctx}/pessoa/cadastro">Pessoa</a>
						</li>
						<li>
							<a href="${ctx}/tipoArquivo/cadastro">Tipo de Arquivo</a>
						</li>
						<li>
							<a href="${ctx}/validade/cadastroValidade">Validade</a>
						</li>
					</ul>
				</li>
<!-- 				<li> -->
<!-- 					<a href="#">IMPORTAR</a> -->
<!-- 					<ul> -->
<!-- 						<li> -->
<%-- 							<a href="${ctx}/importar">Arquivo</a> --%>
<!-- 						</li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
 				<li style="float: right">   
 					<a href="${ctx}/j_spring_security_logout">SAIR</a>
 				</li>
				<li style="float: right">
				   <a href="${ctx}/sobre">SOBRE</a>
				</li>
			</ul>
		</div>

<!-- 		<div id="toolbar"> -->
<%-- 			<a href="${ctx}/" class="button left"> --%>
<!-- 				<span class="icon icon56" title="Início">Home</span> -->
<!-- 			</a> -->
			
<%-- 				<a href="${ctx}/pessoa/cadastro" class="button middle"> --%>
<!-- 				<span class="icon icon51" title="Cadastro de Pessoas">CadastroPessoa</span> -->
<!-- 			</a> -->
<%-- 			<a href="${ctx}/caixa/cadastroCaixa" class="button middle"> --%>
<!-- 				<span class="icon icon58" title="Cadastro de Caixa">CadastroCaixa</span> -->
<!-- 			</a> -->
<%-- 			<a href="${ctx}/validade/cadastroValidade" class="button middle"> --%>
<!-- 				<span class="icon icon43" title="Cadastro de Validade">CadastroValidade</span> -->
<!-- 			</a> -->
			
<%-- 			<a href="${ctx}/arquivo/buscar" class="button middle"> --%>
<!-- 				<span class="icon icon52" title="Buscar Arquivo">Buscar Arquivo</span> -->
<!-- 			</a> -->
			
	
<%-- 			<a href="${ctx}/j_spring_security_logout" class="button right"> --%>
<%-- 				<img src="${ctx}/images/out.ico" /> --%>
<!-- 			</a> -->

<%-- 			<a href="${ctx}/problemas" class="button midlle right"> --%>
<!-- 				<span class="icon icon92" title="Informar problemas">Problemas</span> -->
<!-- 			</a> -->

<%-- 			<a href="${ctx}/sobre" class="button midlle right"> --%>
<!-- 				<span class="icon icon33" title="Sobre">Sobre</span> -->
<!-- 			</a> -->

<!-- 		</div> -->
		<!-- FIM MENU -->

		<div id="corpo">
			<c:if test="${erro != null}">
				<div id="msgErro">
					[<c:out value="${erro}" />]
				</div>
			</c:if>
			
			<c:if test="${msg != null}">
				<div id="msgAviso">
					[<c:out value="${msg}" />]
				</div>
			</c:if>