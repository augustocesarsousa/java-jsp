<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parâmetro</title>
</head>
<body>
	<h1>Curso JSP - Parâmetro</h1>
	<form action="parametro.jsp">
		<label for="nome-get">Get:</label>
		<input type="text" id="nome-get" name="nome-get">
		<input type="submit" value="Enviar">
	</form>
	<form action="parametro.jsp" method="post">
		<label for="nome-post">Post:</label>
		<input type="text" id="nome-post" name="nome-post">
		<input type="submit" value="Enviar">
	</form>
</body>
</html>