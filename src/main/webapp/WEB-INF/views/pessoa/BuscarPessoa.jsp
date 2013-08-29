
<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<form action="${ctx}/pessoa/buscar" method="post">

	<div id="titulo">Busca por Pessoa</div>

	<div class="campo">
		<label for="nome"> Nome:</label>
		<input type="text" name="nome" size="30" />
	</div>
	
	<br />
	
	<div class="botoes">
		<input type="submit" value="Buscar"/>
	</div>

</form>



<!-- <TABLE> -->
<!-- 		<TR> -->
<!-- 			<TH><A HREF="JAVASCRIPT: ORDEM('DATAHORA')">DATA/HORA</A></TH> -->
<!-- 			<TH><A HREF="JAVASCRIPT: ORDEM('DESCRICAO')">DESCRIÇÃO</A></TH> -->
<!-- 			<TH><A HREF="JAVASCRIPT: ORDEM('TIPO')">TIPO</A></TH> -->
<!-- 			<TH><A HREF="JAVASCRIPT: ORDEM('MAQUINA.NOME')">MÁQUINA</A></TH> -->
<!-- 			<TH><A HREF="JAVASCRIPT: ORDEM('STATUS')">STATUS</A></TH> -->
<!-- 			<TH><A HREF="JAVASCRIPT: ORDEM('USUARIO.NOME')">USUÁRIO</A></TH> -->
<!-- 			<TH STYLE="TEXT-ALIGN: CENTER;">DETALHES</TH> -->
<!-- 			<TH STYLE="TEXT-ALIGN: CENTER;">EDITAR</TH> -->
<!-- 			<TH STYLE="TEXT-ALIGN: CENTER;">EXCLUIR</TH> -->
<!-- 		</TR> -->
<%-- 		<C:FOREACH VAR="O" ITEMS="${RESULT}"> --%>
<!-- 			<TR> -->
<%-- 				<TD>${O.DATAHORA}</TD> --%>
<%-- 				<TD>${O.DESCRICAO}</TD> --%>
<%-- 				<TD>${O.TIPO}</TD> --%>
<%-- 				<TD>${O.MAQUINA.NOME}</TD> --%>
<%-- 				<TD>${O.STATUS}</TD> --%>
<%-- 				<TD><A HREF="${CTX}/ADMIN/USUARIO/VISUALIZAR?ID=${O.USUARIO.ID}">${O.USUARIO.NOME}</A></TD> --%>
<!-- 				<TD STYLE="TEXT-ALIGN: CENTER;"> -->
<%-- 					<A HREF="${CTX}/${ENTIDADE}/VISUALIZAR?ID=${O.ID}"> --%>
<%-- 						<IMG SRC="${CTX}/IMAGES/VIEW.PNG" WIDTH="16" HEIGHT="16" ALT="DETALHES" TITLE="DETALHES" /> --%>
<!-- 					</A> -->
<!-- 				</TD> -->
<!-- 				<TD STYLE="TEXT-ALIGN: CENTER;"> -->
<%-- 					<A HREF="${CTX}/${ENTIDADE}/ALTERAR?ID=${O.ID}"> --%>
<%-- 						<IMG SRC="${CTX}/IMAGES/EDIT.PNG" WIDTH="16" HEIGHT="16" ALT="EDITAR" TITLE="EDITAR" /> --%>
<!-- 					</A> -->
<!-- 				</TD> -->
<!-- 				<TD STYLE="TEXT-ALIGN: CENTER;"> -->
<%-- 					<A HREF="${CTX}/${ENTIDADE}/EXCLUIR?ID=${O.ID}"> --%>
<%-- 						<IMG SRC="${CTX}/IMAGES/DELETE.PNG" WIDTH="16" HEIGHT="16" ALT="EXCLUIR" TITLE="EXCLUIR" /> --%>
<!-- 					</A> -->
<!-- 				</TD> -->
<!-- 			</TR> -->
<!-- 		</C:FOREACH> -->
<!-- 	</TABLE> -->
	<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
