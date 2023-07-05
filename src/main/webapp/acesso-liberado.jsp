<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de usuários</title>
</head>
<body>
	<h1>Lista de usuários</h1>
	<a href="cadastro-usuario.jsp">Cadastrar</a>
	<br/>
	<br/>
	<table>
		<tr>
			<td>ID</td>
			<td>Usuário</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td><c:out value="${usuario.id}"></c:out></td>
				<td><c:out value="${usuario.login}"></c:out></td>
				<td>
					<a href="UsuarioServlet?acao=editar&id=${usuario.id}">Editar</a>
				</td>
				<td>
					<a href="UsuarioServlet?acao=delete&id=${usuario.id}">Excluir</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>