<jsp:useBean id="loginBean" class="beans.Login" type="beans.Login" scope="page"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>	
	<!-- 	Criando variável -->
	<c:set var="testeJSTL" scope="page" value="${'Teste JSTL'}"/>
	<!-- 	Saída da variável -->
	<c:out value="${testeJSTL}"/>
	<!-- 	Removendo variável -->
	<c:remove var="testeJSTL"/>
	<c:out value="${testeJSTL}"/>
	<br/>
	<br/>
	<!-- 	Condicional -->
	<c:set var="numero" scope="page" value="${48}"/>
	<c:choose>
		<c:when test="${numero < 50}">
			<c:out value="${'O número é menor que 50'}"/>
		</c:when>
		<c:when test="${numero > 50}">
			<c:out value="${'O número é maior que 50'}"/>
		</c:when>
		<c:otherwise>
			<c:out value="${'O número é igual a 50'}"></c:out>
		</c:otherwise>
	</c:choose>
	<br/>
	<br/>
	<!-- 	ForEach -->
	<c:forEach var = "n" begin = "1" end = "10">
		<c:out value="${numero} x ${n} = ${numero*n}"/><br/>		
	</c:forEach>
	<br/>
	<!-- 	ForTokens -->
	<c:forTokens items = "Curso-Java-JSP" delims = "-" var = "palavra">
		<c:out value="${palavra}"/><br/>		
	</c:forTokens>
	<br/>
	<br/>
	<form action="LoginServlet" method="post">
		<label>Login: 
			<input type="text" id="login" name="login" placeholder="Login">		
		</label><br/>	
		<label>Senha:
			<input type="password" id="senha" name="senha" placeholder="Senha">
		</label><br/>
		<button type="submit">Entrar</button>
	</form>
	
	<!-- Banco de dados -->

</body>
</html>