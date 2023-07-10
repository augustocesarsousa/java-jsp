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
				<div class="input-left-content">
					<div class="input-content">
						<label for="login">Usuário:</label>
						<c:if test="${usuario.login != null}">
							<input type="text" id="login" name="login" value="${usuario.login}">				
						</c:if>
						<c:if test="${usuario.login == null}">
							<input type="text" id="login" name="login">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="senha">Senha:</label>
						<c:if test="${usuario.senha != null}">
							<input type="password" id="senha" name="senha" value="${usuario.senha}">				
						</c:if>
						<c:if test="${usuario.senha == null}">
							<input type="password" id="senha" name="senha">				
						</c:if>		
					</div>
					<div class="input-content">
						<label for="nome">Nome:</label>
						<c:if test="${usuario.nome != null}">
							<input type="text" id="nome" name="nome" value="${usuario.nome}">				
						</c:if>
						<c:if test="${usuario.nome == null}">
							<input type="text" id="nome" name="nome">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="sobrenome">Sobrenome:</label>
						<c:if test="${usuario.sobrenome != null}">
							<input type="text" id="sobrenome" name="sobrenome" value="${usuario.sobrenome}">				
						</c:if>
						<c:if test="${usuario.sobrenome == null}">
							<input type="text" id="sobrenome" name="sobrenome">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="email">Email:</label>
						<c:if test="${usuario.email != null}">
							<input type="text" id="email" name="email" value="${usuario.email}">				
						</c:if>
						<c:if test="${usuario.email == null}">
							<input type="text" id="email" name="email">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="telefone">Telefone:</label>
						<c:if test="${usuario.telefone != null}">
							<input type="text" id="telefone" name="telefone" value="${usuario.telefone}">				
						</c:if>
						<c:if test="${usuario.telefone == null}">
							<input type="text" id="telefone" name="telefone">				
						</c:if>
					</div>
				</div>
				<div class="input-right-content">				
					<div class="input-content">
						<label for="cep">CEP:</label>
						<c:if test="${usuario.cep != null}">
							<input type="text" id="cep" name="cep" value="${usuario.cep}">				
						</c:if>
						<c:if test="${usuario.cep == null}">
							<input type="text" id="cep" name="cep">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="logradouro">Logradouro:</label>
						<c:if test="${usuario.logradouro != null}">
							<input type="text" id="logradouro" name="logradouro" value="${usuario.logradouro}">				
						</c:if>
						<c:if test="${usuario.logradouro == null}">
							<input type="text" id="logradouro" name="logradouro">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="numero">Numero:</label>
						<c:if test="${usuario.numero != null}">
							<input type="number" id="numero" name="numero" value="${usuario.numero}">				
						</c:if>
						<c:if test="${usuario.logradouro == null}">
							<input type="text" id="numero" name="numero">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="bairro">Bairro:</label>
						<c:if test="${usuario.bairro != null}">
							<input type="text" id="bairro" name="bairro" value="${usuario.bairro}">				
						</c:if>
						<c:if test="${usuario.logradouro == null}">
							<input type="text" id="bairro" name="bairro">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="cidade">Cidade:</label>
						<c:if test="${usuario.cidade != null}">
							<input type="text" id="cidade" name="cidade" value="${usuario.cidade}">				
						</c:if>
						<c:if test="${usuario.cidade == null}">
							<input type="text" id="cidade" name="cidade">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="estado">Estado:</label>
						<c:if test="${usuario.estado != null}">
							<input type="text" id="estado" name="estado" value="${usuario.estado}">				
						</c:if>
						<c:if test="${usuario.estado == null}">
							<input type="text" id="estado" name="estado">				
						</c:if>
					</div>
				</div>
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