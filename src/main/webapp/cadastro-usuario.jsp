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
		<form action="UsuarioServlet" method="post" onsubmit="return validarForm() ? true : false" enctype="multipart/form-data">
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
							<input type="number" id="telefone" name="telefone" value="${usuario.telefone}">				
						</c:if>
						<c:if test="${usuario.telefone == null}">
							<input type="number" id="telefone" name="telefone">				
						</c:if>
					</div>
					<div  class="input-arquivo">
						<label for="foto">Foto:</label>
						<input type="file" name="foto" placeholder="png, jpg - 256bk">
					</div>
				</div>
				<div class="input-right-content">				
					<div class="input-content">
						<label for="cep">CEP:</label>
						<c:if test="${usuario.cep != null}">
							<input type="number" id="cep" name="cep" value="${usuario.cep}">				
						</c:if>
						<c:if test="${usuario.cep == null}">
							<input type="number" id="cep" name="cep">				
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
					<div class="input-arquivo">
						<label for="curriculo">Curriculo:</label>
						<input type="file" id="curriculo" name="curriculo" onchange="validarCurriculo()">
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
	<script type="text/javascript" src="resources/javascript/index.js"></script>
</body>
</html>