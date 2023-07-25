<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include JSP</title>
</head>
<body>
	<jsp:include page="navbar.jsp">
		<jsp:param value="Imagem Logo" name="logo"/>
	</jsp:include>
	<h1>Curso JSP - Include JSP</h1>
</body>
</html>