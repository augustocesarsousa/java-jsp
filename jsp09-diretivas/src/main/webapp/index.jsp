<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diretivas</title>
</head>
<body>
	<h1>Curso JSP - Diretivas</h1>
	<%@ page import="java.util.Date" %>
	<%= "Diretiva data: " + new Date() %>
	<%@ page info="Informações da página, pode ser recuperado na Servlet" %>
</body>
</html>