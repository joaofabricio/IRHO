<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Imperium Rerum Humanis Opibus</title>
<link rel="icon" href="/favicon.ico" type="image/iRHologin.ico" />

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
		<c:if test="${not empty param.error}">
			<div class="error">
				Ocorreu um erro na tentativa de Login.<br />
				${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
			</div>
		</c:if>

		<img src="${ctx}/images/iRHologin.png" alt="utfpr" width="350" height="370" />


		<form action="${ctx}/j_spring_security_check" method="post" id="formLogin">
			<label>Por favor, identifique-se.</label>
			<!-- 				<span style="color: #F0000; font-size: 2">Preencha com o usuário e senha institucionais.</span> -->
			<div>
				<label for="j_username">Usuário:</label> 
				<input type="text" 
					   value="" 
					   id="j_username" 
					   name="j_username" 
					   autofocus="autofocus" 
					   autocomplete="off"
					   size="15" />
			</div>
			<br />
			<div>
				<label for="j_password">Senha:&nbsp;&nbsp;&nbsp;</label>
				<input type="password" 
					   value=""
					   id="j_password" 
					   name="j_password" 
					   size="15" />
			</div>
			<br /> <br />
<%-- 			<% --%>
<!-- 				out.print("<div style=\"text-align: center;\">Digite as duas palavras apresentadas abaixo:</div>"); -->
<!-- 				ReCaptcha c = ReCaptchaFactory.newReCaptcha( -->
<!-- 						"6LcCRu0SAAAAAMDfCMHmJiUGlSVC8zQ8YxQsGSNJ", -->
<!-- 						"6LcCRu0SAAAAAGO_25YIE3SoAaZZSBUjM4X7WmFC", false); -->
<!-- 				out.print(c.createRecaptchaHtml(null, null)); -->
<!-- 			%> -->
			<div>
				<input type="submit" value="Login" />
			</div>
		</form>
	</div>
</body>
</html>
