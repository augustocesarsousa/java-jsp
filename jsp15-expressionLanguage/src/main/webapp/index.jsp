<jsp:useBean id="usuario" class="bean.Usuario" type="bean.Usuario" scope="page"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Getter Setter</title>
</head>
<body>
	<h1>Curso JSP - Expression Language</h1>
	<jsp:setProperty property="nome" name="usuario" value="Augusto"/>
	<jsp:setProperty property="idade" name="usuario" value="10"/>
	<jsp:setProperty property="email" name="usuario" value="acs-03@hotmail.com"/>
	
	<p>Nome: ${usuario.nome}</p>
	<p>Idade: ${usuario.idade}</p>
	<p>Email: ${usuario.email}</p>
</body>
</html>