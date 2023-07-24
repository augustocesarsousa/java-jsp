<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parâmetro</title>
</head>
<body>
	<h1>Curso JSP - Parâmetro</h1>
	<p>Parâmetro GET recebido: <% out.print(request.getParameter("nome-get")); %></p>
	<p>Parâmetro POST recebido: <% out.print(request.getParameter("nome-post")); %></p>
</body>
</html>