<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter</title>
</head>
<body>
	<h1>Cusro JSP - Filter</h1>
	<form action="pages/login" method="post">
		<input type="text" id="login" name="login" placeholder="Login">
		<input type="password" id="password" name="password" placeholder="Senha">
		<input type="submit" value="Entrar" />
		<% request.setAttribute("urlParam", request.getAttribute("url")); %>
	</form>
	<p id="mensagem"></p>
</body>
</html>