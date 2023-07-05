<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>
	<h1>Cadastro de Usuário</h1>
	<form action="UsuarioServlet" method="post">
		<label>Login: 
			<input type="text" id="login" name="login" placeholder="Login">		
		</label><br/>	
		<label>Senha:
			<input type="password" id="senha" name="senha" placeholder="Senha">
		</label><br/>
		<button type="submit">Cadastrar</button>
	</form>	
</body>
</html>