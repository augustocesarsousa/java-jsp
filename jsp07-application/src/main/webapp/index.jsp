<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application</title>
</head>
<body>
	<h1>Curso JSP - Application</h1>
	<%= "Resultado da application estado: " + application.getInitParameter("estado") %>
</body>
</html>