<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Usuário</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Cadastro de Usuário</h1>
		<form action="UsuarioServlet" method="post">
			<div class="input-container">
				<label for="login">Usuário:</label>
				<c:if test="${usuario.login != null}">
					<input type="text" id="login" name="login" value="${usuario.login}">				
				</c:if>
				<c:if test="${usuario.login == null}">
					<input type="text" id="login" name="login">				
				</c:if>
			</div>
			<div class="input-container">
				<label for="senha">Senha:</label>
				<c:if test="${usuario.senha != null}">
					<input type="password" id="senha" name="senha" value="${usuario.senha}">				
				</c:if>
				<c:if test="${usuario.senha == null}">
					<input type="password" id="senha" name="senha">				
				</c:if>		
			</div>
			<div class="btn-content">
				<button type="submit" class="btn btn-middle btn-blue">Cadastrar</button>
				<a href="UsuarioServlet?acao=listar" class="btn btn-middle btn-red">Cancelar</a>			
			</div>
		</form>
		<c:if test="${erro == true}">
			<small>${mensagem}</small>
		</c:if>
	</div>
<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<td>ID</td> -->
<!-- 			<td>Usuário</td> -->
<!-- 			<td></td> -->
<!-- 		</tr> -->
<%-- 		<c:forEach items="${usuarios}" var="usuario"> --%>
<!-- 			<tr> -->
<%-- 				<td><c:out value="${usuario.id}"></c:out></td> --%>
<%-- 				<td><c:out value="${usuario.login}"></c:out></td> --%>
<!-- 				<td> -->
<%-- 					<a href="UsuarioServlet?acao=delete&id=${usuario.id}">Excluir</a> --%>
<%-- 					<a href="UsuarioServlet?acao=editar&id=${usuario.id}">Excluir</a> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
</body>
</html>