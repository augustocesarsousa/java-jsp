<jsp:useBean id="calcularora" class="bean.CalculadoraBean" type="bean.CalculadoraBean" scope="page"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean</title>
</head>
<body>
	<h1>Curso JSP - Bean</h1>
	<%=	"Resultado bean soma: " + calcularora.soma(25, 15)%><br>
	<%=	"Resultado bean subtração: " + calcularora.subtracao(25, 15)%><br>
	<%=	"Resultado bean multiplicação: " + calcularora.multiplicacao(25, 15)%><br>
	<%=	"Resultado bean divisão: " + calcularora.divisao(25, 15)%><br>
</body>
</html>