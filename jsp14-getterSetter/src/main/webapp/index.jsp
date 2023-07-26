<jsp:useBean id="usuario" class="bean.Usuario" type="bean.Usuario" scope="page"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Getter Setter</title>
</head>
<body>
	<h1>Curso JSP - Getter Setter</h1>
	<jsp:setProperty property="nome" name="usuario" value="Augusto"/>
	<jsp:setProperty property="idade" name="usuario" value="10"/>
	<jsp:setProperty property="email" name="usuario" value="acs-03@hotmail.com"/>
	
	<p> Nome: <jsp:getProperty property="nome" name="usuario"/></p>	
	<p> Idade: <jsp:getProperty property="idade" name="usuario"/></p>	
	<p> Email: <jsp:getProperty property="email" name="usuario"/></p>	
</body>
</html>