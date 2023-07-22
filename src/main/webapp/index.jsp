<jsp:useBean id="loginBean" class="beans.Usuario" type="beans.Usuario" scope="page"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<small id="mensagem-erro">${mensagem}</small>
		<form action="LoginServlet" method="post" onsubmit="return validarForm() ? true : false">
			<div class="input-content">
				<label for="login">Usuário</label>
				<input type="text" id="login" name="login" maxlength="20">
			</div>
			<div class="input-content">
				<label for="senha">Senha</label>
				<input type="password" id="senha" name="senha" maxlength="20">
			</div>
			<button type="submit" class="btn btn-blue">Entrar</button>
		</form>	
	</div>
	<script type="text/javascript" src="resources/javascript/login.js"></script>
</body>
</html>