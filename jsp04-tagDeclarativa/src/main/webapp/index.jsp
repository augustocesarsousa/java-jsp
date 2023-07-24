<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tag Declarativa</title>
</head>
<body>
	<h1>Curso JSP - Tag Declarativa</h1>
	<%! 
		public int multiplicacao(int numero1, int numero2){
			return numero1 * numero2;
		} 
	%>
	<%= "Resultado da tag declarativa: " + multiplicacao(5, 10) %>
</body>
</html>