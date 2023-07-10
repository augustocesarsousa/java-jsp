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
				<div class="input-left-content">
					<div class="input-content">
						<label for="login">ID:</label>
						<input type="text" id="id" name="id" value="${usuario.id}" readonly>
					</div>
					<div class="input-content">
						<label for="login">Usuário:</label>
						<input type="text" id="login" name="login" value="${usuario.login}">
					</div>	
					<div class="input-content">
						<label for="senha">Senha:</label>
						<input type="password" id="senha" name="senha" value="${usuario.senha}">		
					</div>
					<div class="input-content">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" value="${usuario.nome}">
					</div>
					<div class="input-content">
						<label for="sobrenome">Sobrenome:</label>
						<input type="text" id="sobrenome" name="sobrenome" value="${usuario.sobrenome}">
					</div>
					<div class="input-content">
						<label for="email">Email:</label>
						<input type="text" id="email" name="email" value="${usuario.email}">
					</div>
					<div class="input-content">
						<label for="telefone">Telefone:</label>
						<input type="text" id="telefone" name="telefone" value="${usuario.telefone}">
					</div>
				</div>
				<div class="input-right-content">
					<div class="input-content">
						<label for="cep">CEP:</label>
						<input type="text" id="cep" name="cep" value="${usuario.cep}">
					</div>
					<div class="input-content">
						<label for="logradouro">Logradouro:</label>
						<input type="text" id="logradouro" name="logradouro" value="${usuario.logradouro}">
					</div>
					<div class="input-content">
						<label for="numero">Numero:</label>
						<input type="number" id="numero" name="numero" value="${usuario.numero}">
					</div>
					<div class="input-content">
						<label for="bairro">Bairro:</label>
						<input type="text" id="bairro" name="bairro" value="${usuario.bairro}">
					</div>
					<div class="input-content">
						<label for="cidade">Cidade:</label>
						<input type="text" id="cidade" name="cidade" value="${usuario.cidade}">
					</div>
					<div class="input-content">
						<label for="estado">Estado:</label>
						<input type="text" id="estado" name="estado" value="${usuario.estado}">
					</div>
				</div>
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
			const inputNome = document.getElementById('nome');
			const inputEmail = document.getElementById('email');
			const inputTelefone = document.getElementById('telefone');
			const inputLogradouro = document.getElementById('logradouro');
			const inputNumero = document.getElementById('numero');
			const inputBairro = document.getElementById('bairro');
			const inputCidade = document.getElementById('cidade');
			const inputEstado = document.getElementById('estado');
			const inputCep = document.getElementById('cep');
			const smallErro = document.getElementById('mensagem-erro');
			
			if(inputLogin.value.replace(' ', '') === '' || inputLogin.value.length < 4) {
				smallErro.innerText = 'Usuário precisa ter pelo menos 4 dígitos';
				return false;
			}
			
			if(inputSenha.value.replace(' ', '') === '' || inputSenha.value.length < 4) {
				smallErro.innerText = 'Senha precisa ter pelo menos 4 dígitos';
				return false;
			}
			
			if(inputNome.value.replace(' ', '') === '' || inputNome.value === null) {
				smallErro.innerText = 'Nome inválido';
				return false;
			}
			
			if(validaTelefone(inputEmail.value)) {
				smallErro.innerText = 'Telefone inválido';
				return false;
			}
			
			if(inputLogradouro.value.replace(' ', '') === '' || inputLogradouro.value === null) {
				smallErro.innerText = 'Logradouro inválido';
				return false;
			}
			
			if(inputNumero.value < 0) {
				smallErro.innerText = 'Numero inválido';
				return false;
			}
			
			if(inputBairro.value.replace(' ', '') === '' || inputBairro.value === null) {
				smallErro.innerText = 'Bairro inválido';
				return false;
			}
			
			if(inputCidade.value.replace(' ', '') === '' || inputCidade.value === null) {
				smallErro.innerText = 'Cidade inválido';
				return false;
			}
			
			if(inputEstado.value.replace(' ', '') === '' || inputEstado.value === null) {
				smallErro.innerText = 'Estado inválido';
				return false;
			}
			
			if(inputCep.value.replace(' ', '') === '' || inputCep.value === null) {
				smallErro.innerText = 'CEP inválido';
				return false;
			}
			
			return true;
		}
		
		function validaTelefone(telefone) {
		    let regex = ^(\\d{10,11})$;
		    return regex.test(telefone);
		}
	</script>
</body>
</html>