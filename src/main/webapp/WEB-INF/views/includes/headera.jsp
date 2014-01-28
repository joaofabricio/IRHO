<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Imperium Rerum Humanis Opibus</title>
	
<!-- 	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" /> -->
	
	<link rel="shortcut icon" href="<c:url value='/images/icon.png'/>" />

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
    <script src="<c:url value='/js/jquery.periodicalupdater.js'/>"></script>
</head>
<body>
	<div id="conteudo">
		<!-- MENU -->
		<div id="navbar">
			<ul>
				<li>
					<a href="${ctx}/">IN�CIO</a>
				</li>
				
			
				<li style="float: right">
				   <a href="${ctx}/sobre">SOBRE</a>
				</li>
			</ul>
		</div>

	
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