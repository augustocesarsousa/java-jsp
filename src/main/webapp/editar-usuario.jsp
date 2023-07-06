<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edição de Usuário</h1>
	<form action="UsuarioServlet" method="post">
		<label>ID: 
			<input type="text" id="id" name="id" value="${usuario.id}" readonly>		
		</label><br/>	
		<label>Login: 
			<input type="text" id="login" name="login" value="${usuario.login}">		
		</label><br/>	
		<label>Senha:
			<input type="password" id="senha" name="senha" value="${usuario.senha}">
		</label><br/>
		<button type="submit">Salvar</button>
<%-- 		<a href="UsuarioServlet?acao=update&id=${usuario.id}&login=${usuario.login}&senha=${usuario.senha}">Salvar</a> --%>
		<a href="UsuarioServlet?acao=listar">Cancelar</a>
	</form>
</body>
</html>