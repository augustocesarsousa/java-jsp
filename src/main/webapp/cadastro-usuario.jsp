<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>
	<h1>Cadastro de Usuário</h1>
	<form action="UsuarioServlet" method="post">
		<label>Login: 
			<input type="text" id="login" name="login" placeholder="Login">		
		</label><br/>	
		<label>Senha:
			<input type="password" id="senha" name="senha" placeholder="Senha">
		</label><br/>
		<button type="submit">Cadastrar</button>
	</form>	
	<table>
		<tr>
			<td>ID</td>
			<td>Usuário</td>
			<td></td>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td><c:out value="${usuario.id}"></c:out></td>
				<td><c:out value="${usuario.login}"></c:out></td>
				<td>
					<a href="UsuarioServlet?acao=delete&id=${usuario.id}">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>