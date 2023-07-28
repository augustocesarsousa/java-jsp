<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter</title>
</head>
<body>
	<h1>Curso JSP - Filter</h1>
	<p><%= "Usuário logado com sucesso, bem vindo " + session.getAttribute("usuario") %></p>
	<a href="login">Logout</a>
</body>
</html>