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
	<%
		if(session.getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<div class="container">
		<a href="perfil.jsp" id="btn-novo" title="Cadastrar usuário"><i class="fa-solid fa-plus"></i>&nbsp;Novo</a>
		<a href="LogoutServlet" id="btn-sair" title="Sair">Sair&nbsp;<i class="fa-solid fa-right-from-bracket"></i></a>
		<h1>Lista de usuários</h1>	
		<form action="pesquisa" method="POST" id="formPesquisa">			
			<div class="input-content">
				<label for="nomePesquisa">Nome:</label>
				<input type="text" id="nomePesquisa" name="nomePesquisa" maxlength="100">
				<input type="submit" id="submitNomePesquisa" value="Pesquisar">
			</div>
		</form>
		<div id="table-container">
			<table class="table-content">
				<thead>
					<tr>
						<th>ID</th>
						<th>Foto</th>
						<th>Usuário</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Curriculo</th>
						<th colspan="2">
						</th>			
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios}" var="usuario">
						<tr>
							<td><c:out value="${usuario.id}"></c:out></td>
							<td>
								<c:if test="${usuario.fotoMiniaturaBase64 != null}">
									<a href="UsuarioServlet?acao=download&tipo=foto&id=${usuario.id}" title="Download da foto">
										<img alt="Foto do usuário" src="<c:out value="${usuario.fotoMiniaturaBase64}"></c:out>" width="32px" height="32px">
									</a>
								</c:if>
								<c:if test="${usuario.fotoMiniaturaBase64 == null}">
									<img alt="Foto do usuário" src="resources/img/usuario_padrao.jpeg" width="32px" height="32px">
								</c:if>
							</td>
							<td><c:out value="${usuario.login}"></c:out></td>
							<td><c:out value="${usuario.nome}"></c:out></td>
							<td><c:out value="${usuario.email}"></c:out></td>
							<td>
								<c:if test="${usuario.temCurriculo == true}">
									<a href="UsuarioServlet?acao=download&tipo=curriculo&id=${usuario.id}" class="btn btn-square" title="Download do curriculo">
										<i class="fa-solid fa-file-arrow-down fa-xl"></i>
									</a>
								</c:if>
								<c:if test="${usuario.temCurriculo == false}">
									<i class="fa-solid fa-file-excel fa-xl"></i>
								</c:if>
								
							</td>
							<td>
								<a href="UsuarioServlet?acao=editar&id=${usuario.id}" class="btn btn-square" title="Editar">
									<i class="fa-regular fa-pen-to-square fa-xl"></i>
								</a>
							</td>
							<td>
								<a href="UsuarioServlet?acao=delete&id=${usuario.id}" class="btn btn-square" title="Excluir"><i class="fa fa-trash fa-lg"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
	</div>
</body>
</html>