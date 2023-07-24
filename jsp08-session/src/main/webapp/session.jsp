<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<h1>Curso JSP - Session</h1>
	<%= "Usuário da sessão: " + session.getAttribute("user")%>
</body>
</html>