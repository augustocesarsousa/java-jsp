<jsp:useBean id="loginBean" class="beans.Usuario" type="beans.Usuario" scope="page"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>	
	<!-- 	Criando variável -->
<%-- 	<c:set var="testeJSTL" scope="page" value="${'Teste JSTL'}"/> --%>
	<!-- 	Saída da variável -->
<%-- 	<c:out value="${testeJSTL}"/> --%>
	<!-- 	Removendo variável -->
<%-- 	<c:remove var="testeJSTL"/> --%>
<%-- 	<c:out value="${testeJSTL}"/> --%>
<!-- 	<br/> -->
<!-- 	<br/> -->
	<!-- 	Condicional -->
<%-- 	<c:set var="numero" scope="page" value="${48}"/> --%>
<%-- 	<c:choose> --%>
<%-- 		<c:when test="${numero < 50}"> --%>
<%-- 			<c:out value="${'O número é menor que 50'}"/> --%>
<%-- 		</c:when> --%>
<%-- 		<c:when test="${numero > 50}"> --%>
<%-- 			<c:out value="${'O número é maior que 50'}"/> --%>
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<%-- 			<c:out value="${'O número é igual a 50'}"></c:out> --%>
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>
<!-- 	<br/> -->
<!-- 	<br/> -->
	<!-- 	ForEach -->
<%-- 	<c:forEach var = "n" begin = "1" end = "10"> --%>
<%-- 		<c:out value="${numero} x ${n} = ${numero*n}"/><br/>		 --%>
<%-- 	</c:forEach> --%>
<!-- 	<br/> -->
	<!-- 	ForTokens -->
<%-- 	<c:forTokens items = "Curso-Java-JSP" delims = "-" var = "palavra"> --%>
<%-- 		<c:out value="${palavra}"/><br/>		 --%>
<%-- 	</c:forTokens> --%>
<!-- 	<br/> -->
<!-- 	<br/> -->
	<div class="container">
		<h1>Login</h1>
		<form action="LoginServlet" method="post" onsubmit="return validarForm() ? true : false">
			<div class="input-content">
				<label for="login">Usuário:</label>
				<input type="text" id="login" name="login">
			</div>
			<div class="input-content">
				<label for="senha">Senha:</label>
				<input type="password" id="senha" name="senha">		
			</div>
			<button type="submit" class="btn btn-blue">Entrar</button>
		</form>	
		<small id="mensagem-erro">${mensagem}</small>
	</div>
	<script type="text/javascript" src="resources/javascript/login.js"></script>
</body>
</html>