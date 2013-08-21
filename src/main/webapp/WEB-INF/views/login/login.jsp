<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Controle de Problemas no laboratório</title>
	
	<link rel="shortcut icon" href="<c:url value='/images/icon.png'/>" />

    <link rel="stylesheet" href="<c:url value='/css/blueprint/screen.css'/>" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="<c:url value='/css/blueprint/print.css'/>"  type="text/css" media="print">
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>"  type="text/css">

    <script src="<c:url value='/js/jquery-1.6.1.min.js'/>"></script>
    <script src="<c:url value='/js/jquery.periodicalupdater.js'/>"></script>
</head>
<body>
	<div id="conteudo">
		<div class="botoes">
			<img src="${ctx}/images/utfpr.jpeg" alt="utfpr" width="472" height="251" />
		</div>
		<c:if test="${not empty param.error}">
   			<div class="error">
				Ocorreu um erro na tentativa de Login.<br /> 
				${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
			</div>
		</c:if>
		<div id="corpo">
			<form action="${ctx}/j_spring_security_check" method="post" id="formLogin">
				<div id="titulo">Antes de relatar um problema, por favor identifique-se.</div>
<!-- 				<span style="color: #F0000; font-size: 2">Preencha com o usuário e senha institucionais.</span> -->
				<div class="campo">
					<label for="j_username">Usuário:</label>
					<input type="text" value="" id="j_username" name="j_username" autofocus="autofocus" autocomplete="off" />
				</div>
				<br />
				<div class="campo">
					<label for="j_password">Senha:</label>
					<input type="password" value="" id="j_password" name="j_password" />
				</div>
				<br />
				<div class="botoes">
					<input type="submit" value="Login" />
				</div>
<!-- 				<div class="botoes"> -->
<!-- 					<a href="recuperaSenha">Esqueceu a senha?</a> -->
<!-- 				</div> -->
			</form>
	
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>