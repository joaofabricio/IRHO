<%@ page language="java" isErrorPage="true"%> 
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/headera.jsp"%>



<div style="text-align: center;">
	</br>
	</br>
	<img src="${ctx}/images/iRHologin.png" alt="utfpr" width="350"height="370" /> 
	<h1>Desculpe, Ocorreu um erro grave!</h1>
	</br>
	<h5>Entre em contato com a COGETI para maiores infomações pelo e-mail cogeti-cm@utfpr.edu.br ou pelo telefone (44) 3518 1422 </h5>
	<input name="voltar" type="button" onClick="history.go(-1)" value="Voltar">
</div>



<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
