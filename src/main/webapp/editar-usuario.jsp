<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Edição de Usuário</h1>
		<form action="UsuarioServlet" method="post" onsubmit="return validarForm() ? true : false">
			<div class="input-container">
				<label for="login">ID:</label>
				<input type="text" id="id" name="id" value="${usuario.id}" readonly>
			</div>
			<div class="input-container">
				<label for="login">Usuário:</label>
				<input type="text" id="login" name="login" value="${usuario.login}">
			</div>	
			<div class="input-container">
				<label for="senha">Senha:</label>
				<input type="password" id="senha" name="senha" value="${usuario.senha}">		
			</div>
			<div class="btn-content">
				<button type="submit" class="btn btn-middle btn-blue">Salvar</button>
				<a href="UsuarioServlet?acao=listar" class="btn btn-middle btn-red">Cancelar</a>
			</div>
		</form>
		<small id="mensagem-erro">${mensagem}</small>
	</div>
	<script type="text/javascript">		
		function validarForm() {
			const inputLogin = document.getElementById('login');
			const inputSenha = document.getElementById('senha');
			const smallErro = document.getElementById('mensagem-erro');
			
			if(inputLogin.value.replace(' ', '') === '' || inputLogin.value.length < 4) {
				smallErro.innerText = 'Usuário precisa ter pelo menos 4 dígitos';
				return false;
			}
			
			if(inputSenha.value.replace(' ', '') === '' || inputSenha.value.length < 4) {
				smallErro.innerText = 'Senha precisa ter pelo menos 4 dígitos';
				return false;
			}
			
			return true;
		}
	</script>
</body>
</html>