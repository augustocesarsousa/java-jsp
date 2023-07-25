<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Perfil do usuário</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<%
		if(session.getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<div class="container">
		<h1>Perfil do usuário</h1>
		<form action="UsuarioServlet" method="post" onsubmit="return validarForm() ? true : false" enctype="multipart/form-data">
			<div class="input-container">
				<div class="input-left-content">
					<div id="input-content-id" class="input-content">
						<label for="login">ID:</label>
						<input type="text" id="id" name="id" value="${usuario.id}" readonly>
					</div>
					<div class="input-content">
						<label for="login">Usuário:</label>
						<input type="text" id="login" name="login" value="${usuario.login}" maxlength="20">
					</div>	
					<div class="input-content">
						<label for="senha">Senha:</label>
						<input type="password" id="senha" name="senha" value="${usuario.senha}" maxlength="20">		
					</div>
					<div class="input-content">
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" value="${usuario.nome}" maxlength="20">
					</div>
					<div class="input-content">
						<label for="sobrenome">Sobrenome:</label>
						<input type="text" id="sobrenome" name="sobrenome" value="${usuario.sobrenome}" maxlength="20">
					</div>
					<div class="input-content">
						<label for="email">Email:</label>
						<input type="text" id="email" name="email" value="${usuario.email}" maxlength="100">
					</div>
					<div class="input-content">
						<label for="telefone">Telefone:</label>
						<input type="text" id="telefone" name="telefone" value="${usuario.telefone}">
					</div>
					<div class="input-arquivo">
						<span>Foto</span>
						<label id="label-input-foto" for="foto">Carregar arquivo...</label>
						<input type="file" name="foto" id="foto" onchange="validarFoto()">
					</div>
				</div>
				<div class="input-right-content">
					<div class="input-content">
						<label for="cep">CEP:</label>
						<input type="text" id="cep" name="cep" value="${usuario.cep}" maxlength="8">
					</div>
					<div class="input-content">
						<label for="logradouro">Logradouro:</label>
						<input type="text" id="logradouro" name="logradouro" value="${usuario.logradouro}" maxlength="100">
					</div>
					<div class="input-content">
						<label for="numero">Numero:</label>
						<input type="number" id="numero" name="numero" value="${usuario.numero}" maxlength="5">
					</div>
					<div class="input-content">
						<label for="bairro">Bairro:</label>
						<input type="text" id="bairro" name="bairro" value="${usuario.bairro}" maxlength="100">
					</div>
					<div class="input-content">
						<label for="cidade">Cidade:</label>
						<input type="text" id="cidade" name="cidade" value="${usuario.cidade}" maxlength="100">
					</div>
					<div class="input-content">
						<label for="estado">Estado:</label>
						<input type="text" id="estado" name="estado" value="${usuario.estado}" maxlength="2">
					</div>
					<div class="input-arquivo">
						<span>Currículo</span>
						<label id="label-input-curriculo" for="curriculo">Carregar arquivo...</label>
						<input type="file" id="curriculo" name="curriculo" onchange="validarCurriculo()">
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
	<script type="text/javascript" src="resources/javascript/index.js"></script>
</body>
</html>