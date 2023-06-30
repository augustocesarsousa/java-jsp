<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Curso JSP</title>
</head>
<body>
	<h1>Hello World in JSP!</h1>
	<%! Date date = new Date();%>
	<p><%= "A data de hoje é: " + date %></p>
	<p><%= "Estado: " + application.getInitParameter("estado") %></p>
	<form action="receber-nome.jsp">
		<input type="text" id="nome" name="nome" placeholder="Escreva seu nome aqui">
		<button type="submit">Enviar</button>
	</form>
</body>
</html>