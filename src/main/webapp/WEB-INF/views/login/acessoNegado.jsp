<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IRHO - Índice de Arquivos físicos da UTFPRCM</title>
<link rel="icon" href="/favicon.ico" type="image/icon.ico" />

<!-- 	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" /> -->

<link rel="shortcut icon" href="<c:url value='/images/icon.png'/>" />

<link rel="stylesheet" href="<c:url value='/css/blueprint/screen.css'/>"
	type="text/css" media="screen, projection">
<link rel="stylesheet" href="<c:url value='/css/blueprint/print.css'/>"
	type="text/css" media="print">
<link rel="stylesheet" href="<c:url value='/css/menu_style.css'/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/css/skin/css3-buttons-grey.css'/>" type="text/css"
	media="screen">
<link rel="stylesheet" href="<c:url value='/css/css3-buttons.css'/>"
	type="text/css" media="screen">
<!--[if lt IE 8]>
        <link rel="stylesheet" href="/css/blueprint/ie.css" type="text/css" media="screen, projection">
    <![endif]-->
<link rel="stylesheet" href="<c:url value='/css/main.css'/>"
	type="text/css">

<script src="<c:url value='/js/jquery.min.js'/>"></script>
<script src="<c:url value='/js/jquery.periodicalupdater.js'/>"></script>
</head>
<body>
	<div id="conteudoLogin">

		<div>
			<img src="${ctx}/images/login.png" alt="utfpr" style="max-height: 100%;height: 450px; width: 350px; max-width: 100%;" />
		</div>
		<div id="formLogin">
			<span style="width: 50%">
				Acesso Negado!
				<br />
				<br />
				O seu usuário não está cadastrado para este acesso.
				<br />
				<br />
				Entre em contato com a COGETI-CM para solicitar acesso.
				<br />
				<br />
				<button onclick="history.go(-1)">Voltar</button>
			</span>
		</div>
	</div>
</body>
</html>
