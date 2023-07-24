<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Objeto Implícito</title>
</head>
<body>
	<h1>Curso JSP - Objeto Implícito</h1>
	<%= request.getContextPath()%> <br>
	<%= request.getLocalName()%> <br>
	<%= request.getMethod()%> <br>
	<%= request.getProtocol()%> <br>
	<%= request.getRequestedSessionId()%> <br>
	<%= request.getRequestURI()%> <br>
	<%= request.getRequestURL()%> <br>
	<%= request.getRequestedSessionId()%> <br>
	<%= request.getServerName()%> <br>
</body>
</html>