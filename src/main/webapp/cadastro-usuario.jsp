<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Usuário</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Cadastro de Usuário</h1>
		<form action="UsuarioServlet" method="post" onsubmit="return validarForm() ? true : false">
			<div class="input-container">
				<label for="login">Usuário:</label>
				<c:if test="${usuario.login != null}">
					<input type="text" id="login" name="login" value="${usuario.login}">				
				</c:if>
				<c:if test="${usuario.login == null}">
					<input type="text" id="login" name="login">				
				</c:if>
			</div>
			<div class="input-container">
				<label for="senha">Senha:</label>
				<c:if test="${usuario.senha != null}">
					<input type="password" id="senha" name="senha" value="${usuario.senha}">				
				</c:if>
				<c:if test="${usuario.senha == null}">
					<input type="password" id="senha" name="senha">				
				</c:if>		
			</div>
			<div class="btn-content">
				<button type="submit" class="btn btn-middle btn-blue">Cadastrar</button>
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