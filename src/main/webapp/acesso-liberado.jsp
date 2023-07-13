<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de usuários</title>
	<link rel="stylesheet" href="resources/css/style.css">
	<!-- Font awesome -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
</head>
<body>
	<div class="container">
		<a href="index.jsp" title="Sair" id="btn-sair"><i class="fa fa-xmark"></i></a>
		<h1>Lista de usuários</h1>		
		<div id="table-container">
			<table class="table-content">
				<thead>
					<tr>
						<th>ID</th>
						<th>Foto</th>
						<th>Usuário</th>
						<th>Nome</th>
						<th>Sobrenome</th>
						<th>Email</th>
						<th>Telefone</th>
						<th>Logradouro</th>
						<th>Numero</th>
						<th>Bairro</th>
						<th>Cidade</th>
						<th>Estado</th>
						<th>CEP</th>
						<th colspan="2">
							<a href="cadastro-usuario.jsp" class="btn btn-middle btn-green">Cadastrar</a>
						</th>			
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios}" var="usuario">
						<tr>
							<td><c:out value="${usuario.id}"></c:out></td>
							<td><img alt="Foto do usuário" title="Foto" src="<c:out value="${usuario.fotoBase64}"></c:out>" width="32px" height="32px"></td>
							<td><c:out value="${usuario.login}"></c:out></td>
							<td><c:out value="${usuario.nome}"></c:out></td>
							<td><c:out value="${usuario.sobrenome}"></c:out></td>
							<td><c:out value="${usuario.email}"></c:out></td>
							<td><c:out value="${usuario.telefone}"></c:out></td>
							<td><c:out value="${usuario.logradouro}"></c:out></td>
							<td><c:out value="${usuario.numero}"></c:out></td>
							<td><c:out value="${usuario.bairro}"></c:out></td>
							<td><c:out value="${usuario.cidade}"></c:out></td>
							<td><c:out value="${usuario.estado}"></c:out></td>
							<td><c:out value="${usuario.cep}"></c:out></td>
							<td>
								<a href="UsuarioServlet?acao=editar&id=${usuario.id}" class="btn btn-square btn-yellow" title="Editar"><i class="fa-regular fa-pen-to-square fa-xl"></i></a>
							</td>
							<td>
								<a href="UsuarioServlet?acao=delete&id=${usuario.id}" class="btn btn-square btn-red" title="Excluir"><i class="fa fa-trash fa-lg"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
	</div>
</body>
</html>