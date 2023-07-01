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
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Hello World in JSP!</h1>
	<%! Date date = new Date();%>
	<p><%= "A data de hoje é: " + date %></p>
	<form action="receber-nome.jsp">
		<input type="text" id="nome" name="nome" placeholder="Escreva seu nome aqui">
		<button type="submit">Enviar</button>
	</form>
	<% session.setAttribute("usuario", "Augusto Cesar"); %>
<%-- 	<jsp:forward page="receber-nome.jsp"> --%>
<%-- 		<jsp:param value="Augusto" name="nome"/> --%>
<%-- 	</jsp:forward> --%>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>