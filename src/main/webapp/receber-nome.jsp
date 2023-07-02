<jsp:useBean id="meuBean" class="beans.MeuBean" type="beans.MeuBean"/>
<%@page import="java.util.TimeZone"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<p><b>Setters e Getters</b></p>
	<jsp:setProperty property="*" name="meuBean"/>
	<jsp:getProperty property="nome" name="meuBean"/><br/>
	<jsp:getProperty property="email" name="meuBean"/><br/>
	<jsp:getProperty property="telefone" name="meuBean"/><br/>
	
	<p><b>Objetos implícitos</b></p>
	<%="Url: " + request.getRequestURL()%><br/>
	<%="Contex path: " + request.getContextPath()%><br/>
	<%="Method: " + request.getMethod()%><br/>
	<%="Local name: " + request.getLocalName()%><br/>
	<%="Local port: " + request.getLocalPort()%><br/>
	
	<p><b>Appication</b></p>
	<%= "Estado: " + application.getInitParameter("estado") %>
	
	<p><b>Session</b></p>
	<%="Usuário: " + session.getAttribute("usuario")%><br/>
	
	<p><b>Diretivas</b></p>
	<%@page import="java.util.Date"%>
	<%= "TimeZone: " + TimeZone.getDefault().getID() %>
	
	<p><b>Include</b></p>
	<%@ include file="pagina-include.jsp" %>
	
	<p><b>Tag</b></p>
	<%@ taglib prefix="meuprefix" uri="WEB-INF/minhatag.tld"%>
	<meuprefix:minhatag/>
	
	<p><b>Expression language</b></p>
	<span>Nome: ${param.nome}</span><br/>
	<span>Email: ${param.email}</span><br/>
	<span>Telefone: ${param.telefone}</span><br/>
	<span>Sessão: ${sessionScope.usuario}</span><br/>
</body>
</html>