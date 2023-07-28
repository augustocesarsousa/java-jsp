<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<title>Load Page com JQuery</title>
</head>
<body>
	<h1>Curso JSP - Load Page com JQuery</h1>
	<button onclick="carregar()">Carregar página</button>
	<div id="pagina-container"></div>
</body>
<script type="text/javascript">
	function carregar() {
		$("#pagina-container").load('pagina-filha.jsp');
	}
</script>
</html>