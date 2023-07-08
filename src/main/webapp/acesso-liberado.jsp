<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de usuários</title>
	<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Lista de usuários</h1>		
		<div id="table-container">
			<table class="table-content">
				<thead>
					<tr>
						<th>ID</th>
						<th>Usuário</th>
						<th colspan="2">
							<a href="cadastro-usuario.jsp" class="btn btn-middle btn-blue">Cadastrar</a>
						</th>			
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios}" var="usuario">
						<tr>
							<td><c:out value="${usuario.id}"></c:out></td>
							<td><c:out value="${usuario.login}"></c:out></td>
							<td>
								<a href="UsuarioServlet?acao=editar&id=${usuario.id}" class="btn btn-small btn-yellow">Editar</a>
							</td>
							<td>
								<a href="UsuarioServlet?acao=delete&id=${usuario.id}" class="btn btn-small btn-red">Excluir</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
	</div>
</body>
</html>