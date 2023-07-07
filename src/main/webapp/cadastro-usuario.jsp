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
				<input type="text" id="login" name="login">
			</div>
			<div class="input-container">
				<label for="senha">Senha:</label>
				<input type="password" id="senha" name="senha">		
			</div>
			<div class="btn-content">
				<button type="submit" class="btn btn-middle btn-blue">Cadastrar</button>
				<a href="UsuarioServlet?acao=listar" class="btn btn-middle btn-red">Cancelar</a>			
			</div>
		</form>	
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