<jsp:useBean id="loginBean" class="beans.Login" type="beans.Login" scope="page"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>	
	<form action="LoginServlet" method="post">
		<label>Login: 
			<input type="text" id="login" name="login" placeholder="Login">		
		</label><br/>	
		<label>Senha:
			<input type="password" id="senha" name="senha" placeholder="Senha">
		</label><br/>
		<button type="submit">Entrar</button>
	</form>

</body>
</html>