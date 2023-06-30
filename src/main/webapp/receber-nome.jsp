<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%="Nome recebido: " + request.getParameter("nome")%>
	<p><b>Objetos implícitos</b></p>
	<%="Url: " + request.getRequestURL()%></br>
	<%="Contex path: " + request.getContextPath()%></br>
	<%="Method: " + request.getMethod()%></br>
	<%="Local name: " + request.getLocalName()%></br>
	<%="Local port: " + request.getLocalPort()%></br>
</body>
</html>