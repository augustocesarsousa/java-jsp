<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Usuário</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Cadastro de Usuário</h1>
		<form action="UsuarioServlet" method="post" onsubmit="return validarForm() ? true : false" enctype="multipart/form-data">
			<div class="input-container">
				<div class="input-left-content">
					<div class="input-content">
						<label for="login">Usuário</label>
						<c:if test="${usuario.login != null}">
							<input type="text" id="login" name="login" value="${usuario.login}" maxlength="20">				
						</c:if>
						<c:if test="${usuario.login == null}">
							<input type="text" id="login" name="login" maxlength="20">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="senha">Senha</label>
						<c:if test="${usuario.senha != null}">
							<input type="password" id="senha" name="senha" value="${usuario.senha}" maxlength="20">				
						</c:if>
						<c:if test="${usuario.senha == null}">
							<input type="password" id="senha" name="senha" maxlength="20">				
						</c:if>		
					</div>
					<div class="input-content">
						<label for="nome">Nome</label>
						<c:if test="${usuario.nome != null}">
							<input type="text" id="nome" name="nome" value="${usuario.nome}" maxlength="20">				
						</c:if>
						<c:if test="${usuario.nome == null}">
							<input type="text" id="nome" name="nome" maxlength="20">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="sobrenome">Sobrenome</label>
						<c:if test="${usuario.sobrenome != null}">
							<input type="text" id="sobrenome" name="sobrenome" value="${usuario.sobrenome}" maxlength="20">				
						</c:if>
						<c:if test="${usuario.sobrenome == null}">
							<input type="text" id="sobrenome" name="sobrenome" maxlength="20">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="email">Email</label>
						<c:if test="${usuario.email != null}">
							<input type="text" id="email" name="email" value="${usuario.email}" maxlength="100">				
						</c:if>
						<c:if test="${usuario.email == null}">
							<input type="text" id="email" name="email" maxlength="100">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="telefone">Telefone</label>
						<c:if test="${usuario.telefone != null}">
							<input type="number" id="telefone" name="telefone" value="${usuario.telefone}">				
						</c:if>
						<c:if test="${usuario.telefone == null}">
							<input type="number" id="telefone" name="telefone">				
						</c:if>
					</div>
					<div  class="input-arquivo">
						<span>Foto</span>
						<label id="label-input-foto" for="foto">Carregar arquivo...</label>
						<input type="file" name="foto" id="foto" onchange="validarFoto()">
					</div>
				</div>
				<div class="input-right-content">				
					<div class="input-content">
						<label for="cep">CEP</label>
						<c:if test="${usuario.cep != null}">
							<input type="number" id="cep" name="cep" value="${usuario.cep}" maxlength="8">				
						</c:if>
						<c:if test="${usuario.cep == null}">
							<input type="number" id="cep" name="cep" maxlength="8">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="logradouro">Logradouro</label>
						<c:if test="${usuario.logradouro != null}">
							<input type="text" id="logradouro" name="logradouro" value="${usuario.logradouro}" maxlength="100">				
						</c:if>
						<c:if test="${usuario.logradouro == null}">
							<input type="text" id="logradouro" name="logradouro" maxlength="100">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="numero">Numero</label>
						<c:if test="${usuario.numero != null}">
							<input type="number" id="numero" name="numero" value="${usuario.numero}" maxlength="5">				
						</c:if>
						<c:if test="${usuario.logradouro == null}">
							<input type="text" id="numero" name="numero" maxlength="5">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="bairro">Bairro</label>
						<c:if test="${usuario.bairro != null}">
							<input type="text" id="bairro" name="bairro" value="${usuario.bairro}" maxlength="100">				
						</c:if>
						<c:if test="${usuario.logradouro == null}">
							<input type="text" id="bairro" name="bairro" maxlength="100">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="cidade">Cidade</label>
						<c:if test="${usuario.cidade != null}">
							<input type="text" id="cidade" name="cidade" value="${usuario.cidade}" maxlength="100">				
						</c:if>
						<c:if test="${usuario.cidade == null}">
							<input type="text" id="cidade" name="cidade" maxlength="100">				
						</c:if>
					</div>
					<div class="input-content">
						<label for="estado">UF</label>
						<c:if test="${usuario.estado != null}">
							<input type="text" id="estado" name="estado" value="${usuario.estado}" maxlength="2">				
						</c:if>
						<c:if test="${usuario.estado == null}">
							<input type="text" id="estado" name="estado" maxlength="2">				
						</c:if>
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
			<small id="mensagem-erro">${mensagem}</small>
		</form>
	</div>
	<script type="text/javascript" src="resources/javascript/index.js"></script>
</body>
</html>