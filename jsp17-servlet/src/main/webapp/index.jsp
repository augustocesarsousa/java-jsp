<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet</title>
</head>
<body>
	<h1>Curso JSP - Servlet</h1>
	<form action="lista" method="post">
		<input type="text" placeholder="Digite o item" id="item" name="item">
		<input type="submit" value="Adicionar">
	</form>
	<ul>
		<c:forEach items="${lista}" var="item">
			<li><c:out value="${item}"></c:out></li>
		</c:forEach>
	</ul>
</body>
</html>