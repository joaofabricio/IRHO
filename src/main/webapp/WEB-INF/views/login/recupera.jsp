<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Controle de Processo de Compra</title>

    <link rel="stylesheet" href="<c:url value='/css/blueprint/screen.css'/>" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="<c:url value='/css/blueprint/print.css'/>"  type="text/css" media="print">
    <link rel="stylesheet" href="<c:url value='/css/main.css'/>"  type="text/css">

    <script src="<c:url value='/js/jquery-1.6.1.min.js'/>"></script>
    <script src="<c:url value='/js/jquery.periodicalupdater.js'/>"></script>
</head>
<body>
	<div id="conteudo">
		<div id="corpo">
			<form action="recuperar" method="post" id="formLogin">
				<span style="color: #FF0000; font-size: 2; text-align: center">${msg}</span>
				<div id="titulo">Digite o nome de usuário que um link de verificação será enviado ao seu e-mail</div>
				<div class="campo">
					<label for="login">Usuário:</label>
					<input type="text" value="" id="login" name="login" autofocus="autofocus" autocomplete="off" />
				</div>
				<br />
				<div class="botoes">
					<input type="submit" value="OK" />
				</div>
			</form>
	
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>